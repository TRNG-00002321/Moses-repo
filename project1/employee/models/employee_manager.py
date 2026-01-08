# As an employee, I want to log in with my credentials so that I can securely access my expense reports.
# As an employee, I want to submit a new expense with details about amount and description so that I can request reimbursement or track spending.
# As an employee, I want to view the status of my submitted expenses so that I know whether they are pending, approved, or denied.
# As an employee, I want to edit or delete expenses that are still pending so that I can correct mistakes before they are reviewed.
# As an employee, I want to view a history of all my approved and denied expenses so that I can track my financial activity over time.
# from employee_class import Employee
# employee_manager.py
from employee_class import Employee
from datetime import datetime


LINE = "=" * 80
SUB_LINE = "-" * 80


def menu():
    print(f"\n{LINE}")
    print("           EXPENSE MANAGER DASHBOARD".center(80))
    print(LINE)
    print("  1. Submit Expense")
    print("  2. View Pending Expenses")
    print("  3. Edit Expense")
    print("  4. Delete Expense")
    print("  5. View Expense History")
    print("  6. Logout")
    print(LINE)


# ================== INPUT HELPERS ==================

def get_valid_int(prompt):
    while True:
        value = input(prompt).strip()
        if not value:
            print("❌ Input cannot be empty.")
            continue
        try:
            return int(value)
        except ValueError:
            print("❌ Please enter a valid whole number.")


def get_valid_amount(prompt):
    while True:
        value = input(prompt).strip()

        if not value:
            print("❌ Amount cannot be empty.")
            continue

        try:
            amount = float(value)
            if amount <= 0:
                print("❌ Amount must be greater than 0.")
                continue
            return round(amount, 2)
        except ValueError:
            print("❌ Please enter a valid number. Example: 25.50")


def get_non_empty_string(prompt):
    while True:
        value = input(prompt).strip()
        if value:
            return value
        print("❌ This field cannot be empty.")


def get_date_string(prompt):
    while True:
        value = input(prompt).strip()

        try:
            return datetime.strptime(value, "%Y-%m-%d").strftime("%Y-%m-%d")
        except ValueError:
            print("❌ Invalid format. Use YYYY-MM-DD (Example: 2024-01-31)")


# ================= DISPLAY FUNCTIONS =================

def safe_value(x, default="N/A"):
    return default if (x is None or x == "") else str(x)


def display_expenses_list(expenses):
    if not expenses:
        print("\n⚠️ No expenses found.")
        return

    print(f"\n{LINE}")
    print("YOUR EXPENSES".center(80))
    print(LINE)

    header = f"{'ID':<6}{'AMOUNT':<14}{'DATE':<16}{'STATUS':<14}DESCRIPTION"
    print(header)
    print(SUB_LINE)

    for e in expenses:
        expense_id = safe_value(e.get("id"))
        amount = safe_value(e.get("amount"))
        date = safe_value(e.get("date"))
        status = safe_value(e.get("status")).upper()
        description = safe_value(e.get("description"), "")

        print(
            f"{expense_id:<6}"
            f"${amount:<13}"
            f"{date:<16}"
            f"{status:<14}"
            f"{description}"
        )


def display_reviewed_expenses(expenses, status_filter="both"):
    """
    status_filter options:
    - 'approved'
    - 'denied'
    - 'both'
    """

    if status_filter == "approved":
        filtered = [e for e in expenses if str(e.get("status")).lower() == "approved"]
        title = "APPROVED EXPENSES"
    elif status_filter == "denied":
        filtered = [e for e in expenses if str(e.get("status")).lower() == "denied"]
        title = "DENIED EXPENSES (WITH COMMENTS)"
    else:
        filtered = [
            e for e in expenses
            if str(e.get("status")).lower() in ["approved", "denied"]
        ]
        title = "APPROVED + DENIED EXPENSES"

    if not filtered:
        print("\n⚠️ No matching expenses found.")
        return

    print(f"\n{LINE}")
    print(title.center(80))
    print(LINE)

    print(f"{'ID':<6}{'AMOUNT':<14}{'STATUS':<14}{'REVIEWER':<25}COMMENT")
    print(SUB_LINE)

    for e in filtered:
        expense_id = safe_value(e.get("id"))
        amount = safe_value(e.get("amount"))
        status = safe_value(e.get("status")).upper()
        reviewer = safe_value(e.get("reviewer"))
        comment = safe_value(e.get("comment"), "")

        print(
            f"{expense_id:<6}"
            f"${amount:<13}"
            f"{status:<14}"
            f"{reviewer:<25}"
            f"{comment}"
        )


def header(title):
    print(f"\n{LINE}")
    print(title.center(80))
    print(LINE)


# ======================= MAIN =======================

def main():
    employee = Employee()

    header("EMPLOYEE LOGIN")

    username = input("Username: ").strip()
    password = input("Password: ").strip()

    if not username or not password:
        print("❌ Username and password required.")
        return

    if not employee.login(username, password):
        print("❌ Invalid credentials.")
        return

    print(f"\n✅ Welcome, {username}!")

    while True:
        menu()
        choice = input("Select option (1-6): ").strip()

        # ---------- SUBMIT ----------
        if choice == "1":
            header("SUBMIT NEW EXPENSE")

            amount = get_valid_amount("Amount: $ ")
            description = get_non_empty_string("Description: ")
            date = get_date_string("Date (YYYY-MM-DD): ")

            try:
                expense_id = employee.submit_expense(amount, description, date)
                print("\n✅ Expense submitted successfully.")
                print(f"📌 Expense ID: {expense_id}")
            except Exception as e:
                print(f"❌ Failed to submit: {e}")

        # ---------- VIEW PENDING ----------
        elif choice == "2":
            header("PENDING EXPENSES")

            expenses = employee.view_expense_history()
            pending = [e for e in expenses if str(e.get("status")).lower() == "pending"]

            display_expenses_list(pending)

        # ---------- EDIT ----------
        elif choice == "3":
            header("EDIT EXPENSE")

            expenses = employee.view_expense_history()
            display_expenses_list(expenses)

            expense_id = get_valid_int("Enter Expense ID to edit: ")
            amount = get_valid_amount("New Amount: $ ")
            description = get_non_empty_string("New Description: ")

            if employee.edit_expense(expense_id, amount, description):
                print("\n✅ Expense updated successfully.")
            else:
                print("\n❌ Only PENDING expenses can be edited.")

        # ---------- DELETE ----------
        elif choice == "4":
            header("DELETE EXPENSE")

            expenses = employee.view_expense_history()
            display_expenses_list(expenses)

            expense_id = get_valid_int("Enter Expense ID to delete: ")
            confirm = input("Are you sure? (y/n): ").strip().lower()

            if confirm == "y":
                if employee.delete_expense(expense_id):
                    print("\n✅ Expense deleted.")
                else:
                    print("\n❌ Only PENDING expenses can be deleted.")

        # ---------- HISTORY ----------
        elif choice == "5":
            header("EXPENSE HISTORY")

            expenses = employee.view_expense_history()
            option = input("View (a)pproved, (d)enied, (b)oth: ").lower()

            if option == "a":
                approved = [e for e in expenses if str(e.get("status")).lower() == "approved"]
                display_reviewed_expenses(approved)

            elif option == "d":
                display_reviewed_expenses(expenses)

            elif option == "b":
                display_reviewed_expenses(expenses)

            else:
                print("❌ Invalid option.")

        # ---------- LOGOUT ----------
        elif choice == "6":
            employee.logout()
            print("\n✅ Logged out successfully.")
            break

        else:
            print("\n❌ Invalid selection. Please choose 1–6.")


if __name__ == "__main__":
    main()
