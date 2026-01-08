# Revature Expense Manager is a console-based expense tracking system designed for small teams or organizations.
# It features two distinct applications:
# - A Python-based Employee App for submitting and managing personal expense reports.
# - A Java-based Manager App for reviewing, approving, or denying submitted expenses.
# The system uses a shared SQLite database to ensure consistent data access and persistence across both applications.

# Employee App (Python)
# As an employee, I want to log in with my credentials so that I can securely access my expense reports.
# As an employee, I want to submit a new expense with details about amount and description so that I can request reimbursement or track spending.
# As an employee, I want to view the status of my submitted expenses so that I know whether they are pending, approved, or denied.
# As an employee, I want to edit or delete expenses that are still pending so that I can correct mistakes before they are reviewed.
# As an employee, I want to view a history of all my approved and denied expenses so that I can track my financial activity over time.
from typing import Dict, List, Optional
from employee_interface import EmployeeInterface
from crud import CrudOps


class Employee(EmployeeInterface):

    def __init__(self):
        # MySQL connection
        self.crud = CrudOps(
            host="localhost",
            user="root",
            password="1234",
            database="expense_manager"
        )

        # Session-like tracking
        self.user_id: Optional[int] = None
        self.username: Optional[str] = None
        self.role: Optional[str] = None

    # ---------- AUTH ----------

    def login(self, username: str, password: str) -> bool:
        """
        Authentic user login
        """
        user = self.crud.get_user_by_credentials(username, password)

        if user and user['role'] == 'Employee':
            self.user_id = user['id']
            self.username = user['username']
            self.role = user['role']
            return True

        return False

    # ---------- EXPENSE ACTIONS ----------

    def submit_expense(self, amount: float, description: str, date: str) -> int:
        """
        Submit a new expense request
        """
        if not self.user_id:
            raise Exception("User must be logged in first")

        return self.crud.create_expense(self.user_id, amount, description, date)

    def view_expense_status(self, expense_id: int) -> str:
        """
        View a single expense approval status
        """
        approval = self.crud.get_approval_by_expense_id(expense_id)
        return approval['status'] if approval else 'Not Found'

    def edit_expense(self, expense_id: int, amount: float, description: str) -> bool:
        """
        Edit only if status is pending
        """
        if not self.user_id:
            raise Exception("User must be logged in first")

        approval = self.crud.get_approval_by_expense_id(expense_id)

        if approval and approval["status"] == "pending":
            return self.crud.update_expense(expense_id, amount, description)

        return False

    def delete_expense(self, expense_id: int) -> bool:
        """
        Delete a pending expense
        """
        if not self.user_id:
            raise Exception("User must be logged in first")

        approval = self.crud.get_approval_by_expense_id(expense_id)

        if approval and approval["status"] == "pending":
            return self.crud.delete_expense(expense_id)

        return False

    def get_pending_expenses(self) -> List[Dict]:
        """
        Get all pending expenses for the logged-in employee
        """
        if not self.user_id:
            raise Exception("User must be logged in first")

        return self.crud.get_pending_expenses_by_user_id( self.user_id)

    def view_expense_history(self) -> List[Dict]:
        """
        View all employee expenses + status
        """
        if not self.user_id:
            raise Exception("User must be logged in first")

        return self.crud.get_all_expenses_history_by_user_id(self.user_id)

    # ---------- LOGOUT ----------

    def logout(self):
        """
        Clear current session
        """
        self.user_id = None
        self.username = None
        self.role = None

# ===== END OF EMPLOYEE CLASS =====


