import com.raveture.exceptionTesting04.UserValidation;
import com.raveture.exceptionTesting04.ValidationException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class ExceptionTest {

    // This test method checks that validateEmail throws IllegalArgumentException
    // when a null email is provided and verifies the exception message.
    @Test
    @DisplayName("Validate email method throws IllegalArgumentException for invalid emails")
    void ValidateEmail_nullEmail_cannotBeNull() {
        // Arrange
        UserValidation userValidation = new UserValidation();
        String nullEmail = null;
        // Act & Assert
        // Using assertThrows to check for IllegalArgumentException
        // verify exception type captured and verify message
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            userValidation.validateEmail(nullEmail);
        });

        // Optionally, verify the exception message
        assertEquals("Email cannot be null", exception.getMessage());
    }


    // Testing for empty email
    @Test
    @DisplayName("Validate email method throws IllegalArgumentException for empty email")
    void ValidateEmail_emptyEmail_cannotBeEmpty() {

        // Arrange
        UserValidation userValidation = new UserValidation();

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, () ->{
           userValidation.validateEmail("");
        });
        // Assert
        assertEquals("Email cannot be empty",exception.getMessage());
    }

    // Testing for Sign in the email
    @Test
    @DisplayName("Validate email method throws IllegalArgumentException")
    void validateEmail_notSign_mustContainAt(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        String email = "noatsign";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class,()->{
            userValidation.validateEmail(email);
        });

        // Assert
        assertEquals("Email must contain @", exception.getMessage());
    }

    @Test
    @DisplayName("Testing for invalid email format")
    void validdateEmail_invalidFormat_invalidFormat(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        String email = "@nodomain";

        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
           userValidation.validateEmail(email);
        });

        // Assert
        assertEquals("Email has invalid format", exception.getMessage());
    }


//"nouppercase"	No uppercase letter
//"NOLOWERCASE"	No lowercase letter
//Write tests that verify both exception type AND message.

    // Task 2: Test Password Validation (15 minutes): //The validatePassword() method should throw ValidationException.
    @Test
    @DisplayName("Test null Password Validation ")
    void validatePassword_nullPassword_passwordCannotBeNull(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        // Act
        Exception exception = assertThrows(ValidationException.class, ()->{
           userValidation.validatePassword(null);
        });

        // Assert
        assertEquals("Password cannot be null", exception.getMessage());
    }

    @Test
    @DisplayName("Test password Less than 8 characters")
    void validatePassword_passwordLess8Chars_passwordCannotLessThan8(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        String psswd = "short";

        // Act
        Exception exception = assertThrows(ValidationException.class, ()->{
            userValidation.validatePassword(psswd);
        });
        assertEquals("Password must be at least 8 characters", exception.getMessage());
    }

    //Task 3: Test Age Validation (10 minutes)
    @Test
    @DisplayName("Test validate age method, Throw IllegalArgumentException for negative ages")
    void validateAge_negativeAge_ageCannotBeNegative(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            userValidation.validateAge(-12);
        });
        // Assert
        assertEquals("Age cannot be negative", exception.getMessage());
    }

    //Throw IllegalArgumentException for ages over 150

    @Test
    @DisplayName("Test validate age method, Throw IllegalArgumentException for ages over 150")
    void validateAge_ageOver150_ageCannotBeOver150(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        // Act
        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            userValidation.validateAge(151);
        });
        // Assert
        assertEquals("Age cannot exceed 150", exception.getMessage());
    }

    //NOT throw for valid ages (0-150)
    @Test
    @DisplayName("Use assertDoesNotThrow() to verify valid cases!")
    void validateAge_validAge_noException(){
        // Arrange
        UserValidation userValidation = new UserValidation();
        // Act & Assert
        assertDoesNotThrow(()->{
            userValidation.validateAge(30);
        });

    }

    //Task 4: Combine with assertAll (10 minutes)
    //Write a single test that validates multiple invalid inputs:
    @Test
    @DisplayName("Combine multiple assertions using assertAll")
    void validateEmail_multipleInvalidInputs_allThrowExceptions() {
        // Arrange
        UserValidation validator = new UserValidation();
        assertAll("Email validation exceptions",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail(null), "Expected exception for null email"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail(""), "Expected exception for empty email"),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> validator.validateEmail("invalid"), "Expected exception for missing @")
        );

    }

}
