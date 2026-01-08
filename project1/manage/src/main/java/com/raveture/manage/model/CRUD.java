package com.raveture.manage.model;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CRUD {

    private final String host;
    private final String user;
    private final String password;
    private final String database;

    public CRUD(String host, String user, String password, String database) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
    }

   private Connection getConnection() throws SQLException {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }

    String url = "jdbc:mysql://" + host + ":3306/" + database + "?useSSL=false&serverTimezone=UTC";
    return DriverManager.getConnection(url, user, password);
}


    // ---------- USER OPERATIONS ----------
    public Map<String, Object> getUserById(int userId) {
        String sql = "SELECT id, username, role FROM users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("username", rs.getString("username"));
                user.put("role", rs.getString("role"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, Object> getUserByCredentials(String username, String password) {
        String sql = "SELECT id, username, role FROM users WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Map<String, Object> user = new HashMap<>();
                user.put("id", rs.getInt("id"));
                user.put("username", rs.getString("username"));
                user.put("role", rs.getString("role"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ---------- EXPENSE OPERATIONS ----------
    public List<Map<String, Object>> getAllExpenses() {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date, a.status, a.comment " +
                     "FROM expenses e JOIN approvals a ON e.id = a.expense_id ORDER BY e.date DESC";
        return executeQuery(sql);
    }

    public List<Map<String, Object>> getExpensesByStatus(String status) {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date, a.status, a.comment " +
                     "FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE a.status = ? ORDER BY e.date DESC";
        return executeQuery(sql, status);
    }

    public List<Map<String, Object>> getExpensesByEmpId(int empId) {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date, a.status, a.comment " +
                     "FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE e.user_id = ? ORDER BY e.date DESC";
        return executeQuery(sql, empId);
    }

    public List<Map<String, Object>> getExpensesByDateRange(String start, String end) {
        String sql = "SELECT e.id, e.user_id, e.amount, e.description, e.date, a.status, a.comment " +
                     "FROM expenses e JOIN approvals a ON e.id = a.expense_id WHERE e.date BETWEEN ? AND ? ORDER BY e.date DESC";
        return executeQuery(sql, start, end);
    }

    // ---------- APPROVAL OPERATIONS ----------
    public boolean changeStatus(int expenseId, String status, int reviewerId) {
        String sql = "UPDATE approvals SET status = ?, reviewer = ?, review_date = NOW() WHERE expense_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, reviewerId);
            stmt.setInt(3, expenseId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateComment(int expenseId, String comment) {
        String sql = "UPDATE approvals SET comment = ? WHERE expense_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, comment);
            stmt.setInt(2, expenseId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------- DELETE ----------
    public boolean deleteExpense(int expenseId) {
        String sqlApproval = "DELETE FROM approvals WHERE expense_id = ?";
        String sqlExpense = "DELETE FROM expenses WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmtApproval = conn.prepareStatement(sqlApproval);
             PreparedStatement stmtExpense = conn.prepareStatement(sqlExpense)) {

            stmtApproval.setInt(1, expenseId);
            stmtApproval.executeUpdate();

            stmtExpense.setInt(1, expenseId);
            return stmtExpense.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ---------- PRIVATE HELPER ----------
    private List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }

            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= colCount; i++) {
                    row.put(meta.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
