package com.raveture.manage.model;

import com.raveture.manage.dao.ManagerInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager implements ManagerInterface {

    private String username;
    private Integer userId;
    private String role;

    private CRUD crud;

    // Update with your MySQL credentials
    private static final String HOST = "localhost";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static final String DATABASE = "expense_manager";

    public Manager() {
        this.crud = new CRUD(HOST, USER, PASSWORD, DATABASE);
    }

    @Override
    public boolean login(String username, String password) {
        Map<String, Object> user = crud.getUserByCredentials(username, password);
        if (user != null && "Manager".equals(user.get("role"))) {
            this.userId = (Integer) user.get("id");
            this.username = (String) user.get("username");
            this.role = (String) user.get("role");
            return true;
        }
        return false;
    }

    @Override
    public boolean updateExpenseStatus(int expenseId, String status) {
        return (userId != null) && crud.changeStatus(expenseId, status, userId);
    }

    @Override
    public boolean addComment(int expenseId, String comment) {
        return (userId != null) && crud.updateComment(expenseId, comment);
    }

    @Override
    public List<Map<String, Object>> viewAllExpenses() {
        return crud.getAllExpenses();
    }

    @Override
    public List<Map<String, Object>> viewExpensesByEmployee(int empId) {
        return crud.getExpensesByEmpId(empId);
    }

    @Override
    public List<Map<String, Object>> viewExpensesByDateRange(String start, String end) {
        return (userId != null) ? crud.getExpensesByDateRange(start, end) : new ArrayList<>();
    }

    @Override
    public List<Map<String, Object>> viewExpensesByStatus(String status) {
        return (userId != null) ? crud.getExpensesByStatus(status) : new ArrayList<>();
    }

    public void logout() {
        this.username = null;
        this.userId = null;
        this.role = null;
    }
}
