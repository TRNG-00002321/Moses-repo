// Manager App (Java)
//
//As a manager, I want to log in securely so that I can access and manage employee expense reports.
//As a manager, I want to view a list of all pending expenses so that I can review them efficiently.
//As a manager, I want to approve or deny submitted expenses so that I can manage reimbursements appropriately.
//As a manager, I want to add comments to expense decisions so that employees understand the reasoning behind approvals or denials.
//As a manager, I want to generate reports by employee, category, or date so that I can analyze spending trends and make informed decisions.

package com.raveture.manage;

import com.raveture.manage.model.Manager;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n==============================");
        System.out.println("    Welcome to Manager App    ");
        System.out.println("==============================\n");

        // Login process
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!manager.login(username, password)) {
            System.out.println("\n❌ Login failed! Check your credentials.\n");
            scanner.close();
            return;
        }

        System.out.println("\n✅ Login successful! Welcome, " + username + "\n");

        // Manager menu
        while (true) {
            System.out.println("========== Manager Menu ==========");
            System.out.println("1. View All Expenses");
            System.out.println("2. Approve / Deny Expense");
            System.out.println("3. View Expenses by Employee");
            System.out.println("4. Insights / Reports");
            System.out.println("5. Logout");
            System.out.println("=================================");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> displayExpenses(manager.viewAllExpenses());

                case "2" -> {
                    displayExpenses(manager.viewAllExpenses());

                    System.out.print("\nEnter Expense ID to approve/deny: ");
                    int expenseId;
                    try {
                        expenseId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid ID.\n");
                        break;
                    }

                    System.out.print("Enter A to approve or D to deny: ");
                    String statusInput = scanner.nextLine().trim().toUpperCase();

                    if (!statusInput.equals("A") && !statusInput.equals("D")) {
                        System.out.println("❌ Invalid choice. Use 'A' or 'D'.\n");
                        break;
                    }

                    String status = statusInput.equals("A") ? "approved" : "denied";

                    System.out.print("Enter your comment: ");
                    String comment = scanner.nextLine().trim();

                    if (comment.isEmpty()) {
                        comment = "No comment provided.";
                    }

                    boolean statusUpdated = manager.updateExpenseStatus(expenseId, status);
                    boolean commentAdded = manager.addComment(expenseId, comment);

                    if (statusUpdated && commentAdded) {
                        System.out.println("\n✅ Expense " + expenseId +
                                " has been " + status.toUpperCase() +
                                " with comment.\n");
                    } else {
                        System.out.println("\n❌ Failed to fully update the expense.\n");
                    }
                }

                case "3" -> {
                    System.out.print("\nEnter Employee ID: ");
                    int empId = Integer.parseInt(scanner.nextLine());
                    displayExpenses(manager.viewExpensesByEmployee(empId));
                }

                case "4" -> {
                    System.out.println("\n--- View Expenses By ---");
                    System.out.println("1. Status (Pending / Approved / Denied)");
                    System.out.println("2. Date Range (YYYY-MM-DD to YYYY-MM-DD)");
                    System.out.print("Choose option (1 or 2): ");

                    String option = scanner.nextLine().trim();
                    List<Map<String, Object>> expenses;

                    if (option.equals("1")) {
                        System.out.print("Enter Status (Pending / Approved / Denied): ");
                        String status = scanner.nextLine().trim();
                        expenses = manager.viewExpensesByStatus(status);
                    } 
                    else if (option.equals("2")) {
                        System.out.print("Enter Start Date (YYYY-MM-DD): ");
                        String start = scanner.nextLine().trim();

                        System.out.print("Enter End Date (YYYY-MM-DD): ");
                        String end = scanner.nextLine().trim();

                        expenses = manager.viewExpensesByDateRange(start, end);
                    } 
                    else {
                        System.out.println("❌ Invalid choice.\n");
                        break;
                    }

                    if (expenses == null || expenses.isEmpty()) {
                        System.out.println("\n⚠️ No expenses found.\n");
                        break;
                    }

                    displayExpenses(expenses);

                    // Calculate total
                    double total = 0;
                    for (Map<String, Object> e : expenses) {
                        Object amount = e.get("amount");
                        if (amount != null) total += ((Number) amount).doubleValue();
                    }

                    System.out.println("\n===============================");
                    System.out.printf("TOTAL AMOUNT: $%.2f%n", total);
                    System.out.println("===============================\n");
                }

                case "5" -> {
                    manager.logout();
                    System.out.println("\n✅ You have been logged out. Goodbye!\n");
                    scanner.close();
                    return;
                }

                default -> System.out.println("\n❌ Invalid option. Try again.\n");
            }
        }
    }

    // Helper method to display expenses neatly
    private static void displayExpenses(List<Map<String, Object>> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("\n⚠️ No expenses found.\n");
            return;
        }

        System.out.println("\n--- Expenses ---");
        System.out.printf("%-5s | %-7s | %-10s | %-25s | %-12s | %-10s | %-20s%n",
                "ID", "UserID", "Amount", "Description", "Date", "Status", "Comment");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (Map<String, Object> e : expenses) {
            System.out.printf("%-5s | %-7s | $%-9s | %-25s | %-12s | %-10s | %-20s%n",
                    e.get("id"),
                    e.get("user_id"),
                    e.get("amount"),
                    e.get("description"),
                    e.get("date"),
                    e.get("status"),
                    e.get("comment")
                );
        }

        System.out.println("-----------------------------------------------------------------------------------------------\n");
    }
}
