package com.raveture.mockingJava.service;

import com.raveture.mockingJava.exception.*;
import com.raveture.mockingJava.model.*;
import com.raveture.mockingJava.repository.*;
import com.raveture.mockingJava.utils.*;

public class BookReservationService {
    private final BookRepository bookRepository;
    private final EmailService emailService;
    private final AuditLogger auditLogger;

    public BookReservationService(BookRepository bookRepository,
                                  EmailService emailService,
                                  AuditLogger auditLogger) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
        this.auditLogger = auditLogger;
    }

    public Reservation reserveBook(String userId, String bookId) {
        // Check if book exists and is available
        Book book = bookRepository.findById(bookId);

        if (book == null) {
            throw new BookNotFoundException("Book not found: " + bookId);
        }

        if (!book.isAvailable()) {
            throw new BookNotAvailableException("Book is already reserved");
        }

        // Create reservation
        Reservation reservation = new Reservation(userId, bookId);
        book.setAvailable(false);
        bookRepository.update(book);

        // Send confirmation email
        emailService.sendReservationConfirmation(userId, book.getTitle());

        // Log for audit
        auditLogger.log("RESERVATION_CREATED", userId, bookId);

        return reservation;
    }
}
