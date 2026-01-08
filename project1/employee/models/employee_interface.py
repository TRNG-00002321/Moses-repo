from abc import ABC, abstractmethod
# Project Overview
# A Python-based Employee App for submitting and managing personal expense reports.
# A Java-based Manager App for reviewing, approving, or denying submitted expenses.
# The system uses a shared SQLite database to ensure consistent data access and persistence across both applications.
#
# Technologies Used
#
# Python 3.x – Employee CLI interface and data entry
# Java 17+ – Manager CLI interface and expense approval logic
# SQLite – Lightweight relational database for shared persistence
# Git – Version control software for collaboration facilitation
# User Stories
# Employee App (Python)
class EmployeeInterface(ABC):
    @abstractmethod
    # As an employee, I want to log in with my credentials so that I can securely access my expense reports.
    def login(self, username: str, password: str) -> bool:
        """Log in with user credentials."""
        pass

    @abstractmethod
    # As an employee, I want to submit a new expense with details about amount and description so that I can request reimbursement or track spending.
    def submit_expense(self, amount: float, description: str, date: str) -> int:
        """Submit a new expense report."""
        pass

    @abstractmethod
    # As an employee, I want to view the status of my submitted expenses so that I know whether they are pending, approved, or denied.
    def view_expense_status(self, expense_id: int) -> str:
        """View the status of a submitted expense."""
        pass

    @abstractmethod
    # As an employee, I want to edit or delete expenses that are still pending so that I can correct mistakes before they are reviewed.
    def edit_expense(self, expense_id: int, amount: float, description: str) -> bool:
        """Edit a pending expense report."""
        pass

    @abstractmethod
    def delete_expense(self, expense_id: int) -> bool:
        """Delete a pending expense report."""
        pass

    @abstractmethod
    # As an employee, I want to view a history of all my approved and denied expenses so that I can track my financial activity over time.
    def view_expense_history(self) -> list:
        """View history of all approved and denied expenses."""
        pass

    def logout(self) -> None:
        """Log out the current user."""
        pass
