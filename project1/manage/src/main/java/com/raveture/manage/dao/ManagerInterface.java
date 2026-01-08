package com.raveture.manage.dao;
import java.util.List;
import java.util.Map;
// Manager App (Java)
//As a manager, I want to log in securely so that I can access and manage employee expense reports.
//As a manager, I want to view a list of all pending expenses so that I can review them efficiently.
//As a manager, I want to approve or deny submitted expenses so that I can manage reimbursements appropriately.
//As a manager, I want to add comments to expense decisions so that employees understand the reasoning behind approvals or denials.
//As a manager, I want to generate reports by employee, category, or date so that I can analyze spending trends and make informed decisions.


public interface ManagerInterface {
    boolean login(String username, String password);
    boolean updateExpenseStatus(int expenseId, String status);
    boolean addComment(int expenseId, String comment);
    List<Map<String, Object>> viewAllExpenses();
    List<Map<String, Object>> viewExpensesByEmployee(int employeeId);
    List<Map<String, Object>> viewExpensesByDateRange(String startDate, String endDate);
    List<Map<String, Object>> viewExpensesByStatus(String status);



}
