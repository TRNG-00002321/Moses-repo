

//Write tests for BookReservationService.reserveBook() method. You should write at least these test cases:
//
//Happy path: Successfully reserve an available book
//Book not found: Throw exception when book doesn't exist
//Book not available: Throw exception when book is already reserved


// Structure
// // ARRANGE - Prepare test data and stub mocks
//    when(mock.method()).thenReturn(value);
//
//    // ACT - Call the method being tested
//    Result result = service.methodUnderTest();
//
//    // ASSERT - Check the return value
//    assertEquals(expected, result);
//
//    // VERIFY - Check mock interactions
//    verify(mock).method();

import com.raveture.mockingJava.exception.BookNotAvailableException;
import com.raveture.mockingJava.exception.BookNotFoundException;
import com.raveture.mockingJava.repository.BookRepository;
import com.raveture.mockingJava.service.BookReservationService;
import com.raveture.mockingJava.utils.*;
import com.raveture.mockingJava.model.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Test class for BookReservationService
@ExtendWith(MockitoExtension.class) // Using Mockito extension for JUnit 5
public class BookReservationServiceTest {
    @Mock
    private BookRepository mockBookRepo; // Mocked BookRepository
    @Mock
    private EmailService mockEmailService; // Mocked EmailService
    @Mock
    private AuditLogger mockAuditLogger; // Mocked AuditLogger
    @InjectMocks
    private BookReservationService bookReservationService; // Service under test

    // Test case: Successfully reserve an available book
    @Test
    @DisplayName("Happy Path: Sucessfully reserve an available book")
    void testReserveBook_Success(){

        // Arrange
        String userId = "user123";
        String bookId = "book123";
        // Creating a mock available book
        Book availableBook = new Book(bookId, "Mockito in Action", true);
        // Stubbing the mock repository to return the available book
        Mockito.when(mockBookRepo.findById(bookId)).thenReturn(availableBook);
        // Act
        bookReservationService.reserveBook(userId, bookId);
        // Assert - Verify interactions with mocks
        // Verify that findById was called with the correct bookId
        Mockito.verify(mockBookRepo, times(1)).findById(bookId); // Also verifies it was called once
        // Verify that the book's availability was updated
        Mockito.verify(mockBookRepo).update(availableBook);
        // Verify that a reservation confirmation email was sent
        Mockito.verify(mockEmailService).sendReservationConfirmation(userId, availableBook.getTitle());
        // Verify that an audit log entry was created
        Mockito.verify(mockAuditLogger).log("RESERVATION_CREATED", userId, bookId);
    }
    // Test case: Throw exception when book doesn't exist
    @Test
    @DisplayName("Book Not Found: Throw exception when book doesn't exist")
    void testReserveBook_BookNotFound(){
        // Arrange
        String userId = "user124";
        String bookId = "book123";
        // Create a book object
        Book newBook = new Book(bookId, "Love", false);

        // Stub
        when(mockBookRepo.findById(bookId)).thenReturn(null);

        // Act -  Assert using assertThrows
        BookNotFoundException exception = assertThrows(BookNotFoundException.class, ()->
                bookReservationService.reserveBook(userId,bookId)
        );
        //  Assert
        assertEquals("Book not found: "+ bookId, exception.getMessage());
    }

}
