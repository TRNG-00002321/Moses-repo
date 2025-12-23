// A simple repository interface for Book entities
package com.raveture.mockingJava.repository;
// Importing the Book model
import com.raveture.mockingJava.model.Book;

// BookRepository interface with methods to find and update books
public interface BookRepository {
    // Method to find a book by its ID
    Book findById(String bookId);
    // Method to update a book's information
    void update(Book book);
}
