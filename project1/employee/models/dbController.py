# Sqlite Database Schema for Employee Expense Management System
#users

# Column	Type	    Description
# id	    Integer	    Primary Key
# username	TEXT	    Unique Login Name
# password	TEXT	    account password
# role	    TEXT	    Employee or Manager
#
# expenses
#
# Column        Type	    Description
# id	        Integer	    Primary Key
# user_id	    Integer	    Foreign Key to users
# amount	    REAL	    Expense amount
# description	TEXT	    Reason for expense request
# date	        TEXT	    Date of expense

# approvals
#
# Column	    Type	    Description
# id	        Integer	    Primary Key
# expense_id	Integer	    Foreign Key to expenses
# status	    TEXT	    pending, approved, denied
# reviewer	    INTEGER	    Manager user ID (null if not reviewed yet)
# comment	    TEXT	    Feedback from Manager
# review_date	TEXT	    Date review decision was madeA


# Using with open to create and manage the SQLite database
import mysql.connector
from mysql.connector import Error


DB_NAME = "expense_manager"
DB_USER = "root"
DB_PASSWORD = "1234"
DB_HOST = "localhost"


def get_connection(with_db=True):
    """Create MySQL connection"""
    return mysql.connector.connect(
        host=DB_HOST,
        user=DB_USER,
        password=DB_PASSWORD,
        database=DB_NAME if with_db else None
    )


def create_database():
    try:
        conn = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD
        )
        cursor = conn.cursor()

        cursor.execute(f"CREATE DATABASE IF NOT EXISTS {DB_NAME}")
        print(f"✅ Database `{DB_NAME}` ready")

    except Error as e:
        print(f"❌ Error creating database: {e}")
    finally:
        if conn.is_connected():
            cursor.close()
            conn.close()


def initialize_database():
    try:
        create_database()
        conn = get_connection()

        if conn.is_connected():
            print("✅ Connected to MySQL")

        cursor = conn.cursor()

        # USERS TABLE
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS users (
            id INT AUTO_INCREMENT PRIMARY KEY,
            username VARCHAR(100) UNIQUE NOT NULL,
            password VARCHAR(255) NOT NULL,
            role ENUM('Employee','Manager') NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        ) ENGINE=InnoDB;
        """)

        # EXPENSES TABLE
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS expenses (
            id INT AUTO_INCREMENT PRIMARY KEY,
            user_id INT NOT NULL,
            amount DECIMAL(10,2) NOT NULL,
            description TEXT NOT NULL,
            date DATE NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (user_id)
                REFERENCES users(id)
                ON DELETE CASCADE
        ) ENGINE=InnoDB;
        """)

        # APPROVALS TABLE
        cursor.execute("""
        CREATE TABLE IF NOT EXISTS approvals (
            id INT AUTO_INCREMENT PRIMARY KEY,
            expense_id INT NOT NULL,
            status ENUM('pending','approved','denied') NOT NULL DEFAULT 'pending',
            reviewer INT,
            comment TEXT,
            review_date DATE,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            FOREIGN KEY (expense_id)
                REFERENCES expenses(id)
                ON DELETE CASCADE,
            FOREIGN KEY (reviewer)
                REFERENCES users(id)
                ON DELETE SET NULL
        ) ENGINE=InnoDB;
        """)

        # Insert default users if missing
        cursor.execute("SELECT id FROM users WHERE username = 'employee1'")
        if not cursor.fetchone():
            cursor.execute("""
                INSERT INTO users (username, password, role)
                VALUES 
                ('employee1', 'pass123', 'Employee'),
                ('manager1', 'admin123', 'Manager')
            """)
            conn.commit()
            print("✅ Default users added (employee1 / manager1)")

        print("✅ All tables ready!")

    except Error as e:
        print(f"❌ Error: {e}")

    finally:
        if conn.is_connected():
            cursor.close()
            conn.close()
            print("✅ MySQL connection closed")


if __name__ == "__main__":
    initialize_database()
    print("✅ Database initialized successfully.")
