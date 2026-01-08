import mysql.connector
from mysql.connector import Error
from typing import List, Optional, Dict


class CrudOps:

    def __init__(self,
                 host: str = "localhost",
                 user: str = "root",
                 password: str = "1234",
                 database: str = "expense_manager"):

        self.host = host
        self.user = user
        self.password = password
        self.database = database


    def _get_connection(self):
        """Create MySQL connection"""
        return mysql.connector.connect(
            host=self.host,
            user=self.user,
            password=self.password,
            database=self.database
        )

    # ---------- USER OPERATIONS ----------

    def create_user(self, username: str, password: str, role: str = "Employee") -> bool:
        """Creates a new user account"""
        try:
            conn = self._get_connection()
            cursor = conn.cursor(dictionary=True)

            cursor.execute(
                """
                INSERT INTO users (username, password, role)
                VALUES (%s, %s, %s)
                """,
                (username, password, role)
            )

            conn.commit()
            return True

        except Error:
            return False

        finally:
            if conn.is_connected():
                cursor.close()
                conn.close()


    def get_user_by_credentials(self, username: str, password: str) -> Optional[Dict]:
        """Used for login"""
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT id, username, role
            FROM users
            WHERE username = %s AND password = %s
            """,
            (username, password)
        )

        row = cursor.fetchone()

        cursor.close()
        conn.close()
        return row


    def get_user_by_id(self, user_id: int) -> Optional[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            "SELECT * FROM users WHERE id = %s",
            (user_id,)
        )

        row = cursor.fetchone()

        cursor.close()
        conn.close()
        return row


    def get_all_users(self) -> List[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute("SELECT * FROM users ORDER BY username")

        results = cursor.fetchall()

        cursor.close()
        conn.close()

        return results

    # ---------- EXPENSE OPERATIONS ----------

    def create_expense(self, user_id: int, amount: float, description: str, date: str) -> int:
        """Create expense + default pending approval"""
        conn = self._get_connection()
        cursor = conn.cursor()

        cursor.execute(
            """
            INSERT INTO expenses (user_id, amount, description, date)
            VALUES (%s, %s, %s, %s)
            """,
            (user_id, amount, description, date)
        )

        expense_id = cursor.lastrowid

        cursor.execute(
            """
            INSERT INTO approvals (expense_id, status)
            VALUES (%s, 'pending')
            """,
            (expense_id,)
        )

        conn.commit()
        cursor.close()
        conn.close()

        return expense_id


    def get_expense_by_id(self, expense_id: int) -> Optional[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT e.*, a.status, a.comment
            FROM expenses e
            LEFT JOIN approvals a ON e.id = a.expense_id
            WHERE e.id = %s
            """,
            (expense_id,)
        )

        row = cursor.fetchone()

        cursor.close()
        conn.close()

        return row


    def get_expenses_by_user_id(self, user_id: int) -> List[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT e.*, a.status
            FROM expenses e
            LEFT JOIN approvals a ON e.id = a.expense_id
            WHERE e.user_id = %s
            ORDER BY e.date DESC
            """,
            (user_id,)
        )

        results = cursor.fetchall()

        cursor.close()
        conn.close()
        return results


    # def get_all_expenses(self) -> List[Dict]:
    #     conn = self._get_connection()
    #     cursor = conn.cursor(dictionary=True)
    #
    #     cursor.execute(
    #         """
    #         SELECT e.*, u.username, a.status, a.comment, a.reviewer, a.review_date
    #         FROM expenses e
    #         JOIN users u ON e.user_id = u.id
    #         LEFT JOIN approvals a ON e.id = a.expense_id
    #         ORDER BY e.date DESC
    #         """
    #     )

    # results = cursor.fetchall()
    #
    # cursor.close()
    # conn.close()
    # return results



    def get_all_expenses_history_by_user_id(self, user_id: int) -> List[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT e.*, a.status, a.comment, a.reviewer, a.review_date
            FROM expenses e
            LEFT JOIN approvals a ON e.id = a.expense_id
            WHERE e.user_id = %s
            ORDER BY e.date DESC
            """,
            (user_id,)
        )

        results = cursor.fetchall()

        cursor.close()
        conn.close()
        return results





    def update_expense(self, expense_id: int, amount: float, description: str) -> bool:
        conn = self._get_connection()
        cursor = conn.cursor()

        cursor.execute(
            """
            UPDATE expenses
            SET amount = %s, description = %s
            WHERE id = %s
            """,
            (amount, description, expense_id)
        )

        conn.commit()
        updated = cursor.rowcount > 0

        cursor.close()
        conn.close()

        return updated


    # ---------- APPROVAL OPERATIONS ----------

    def get_approval_by_expense_id(self, expense_id: int) -> Optional[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT *
            FROM approvals
            WHERE expense_id = %s
            """,
            (expense_id,)
        )

        row = cursor.fetchone()

        cursor.close()
        conn.close()

        return row


    def update_approval_status(self,
                               expense_id: int,
                               status: str,
                               reviewer_id: int = None,
                               comment: str = None) -> bool:

        conn = self._get_connection()
        cursor = conn.cursor()

        cursor.execute(
            """
            UPDATE approvals
            SET status = %s,
                reviewer = %s,
                comment = %s,
                review_date = CURDATE()
            WHERE expense_id = %s
            """,
            (status, reviewer_id, comment, expense_id)
        )

        conn.commit()
        updated = cursor.rowcount > 0

        cursor.close()
        conn.close()

        return updated


    def get_pending_approvals(self) -> List[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT e.*, u.username, a.id AS approval_id
            FROM expenses e
            JOIN users u ON e.user_id = u.id
            JOIN approvals a ON e.id = a.expense_id
            WHERE a.status = 'pending'
            ORDER BY e.date DESC
            """
        )

        results = cursor.fetchall()

        cursor.close()
        conn.close()

        return results

    #
    def get_pending_expenses_by_user_id(self, user_id: int) -> List[Dict]:
        conn = self._get_connection()
        cursor = conn.cursor(dictionary=True)

        cursor.execute(
            """
            SELECT e.*, a.status
            FROM expenses e
            JOIN approvals a ON e.id = a.expense_id
            WHERE e.user_id = %s AND a.status = 'pending'
            ORDER BY e.date DESC
            """,
            (user_id,)
        )

        results = cursor.fetchall()

        cursor.close()
        conn.close()
        return results



    # ---------- DELETE ----------

    def delete_expense(self, expense_id: int) -> bool:
        try:
            conn = self._get_connection()
            cursor = conn.cursor()

            cursor.execute("DELETE FROM approvals WHERE expense_id = %s", (expense_id,))
            cursor.execute("DELETE FROM expenses WHERE id = %s", (expense_id,))

            conn.commit()
            return cursor.rowcount > 0

        except Error:
            return False

        finally:
            if conn.is_connected():
                cursor.close()
                conn.close()
