package com.raveture.mockingJava.utils;

public interface AuditLogger {
    void log(String eventType, String userId, String bookId);
}
