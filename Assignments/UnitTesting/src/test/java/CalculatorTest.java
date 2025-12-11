
import com.raveture.unitTesting.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.*;

public class CalculatorTest {


    @Test
    @DisplayName("Test Addition, two positive integers")
    // Method name should be methodName_scenario_expecetedBehavior
    void addition_twoPositiveIntegers_correctSum(){
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.addition(3,5);
        // Assert
        assertEquals(8, result, "The correct sum 7");
    }

    // Positive and negative numbers
    @Test
    @DisplayName("Test Addition, positive and negative integers")
    void addition_PositiveNegativeIntegers_correctSum(){
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.addition(10, -4);

        // Asserts
        assertEquals(6, result, "The correct sum 6");
    }

    @Test
    @DisplayName("Test: Two negative intergers")
    void addition_twoNegativeIntegers_correctSum(){
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.addition(-3, -5);

        // Assert
        assertEquals(-8, result, "The correct sum -8");
    }

    @Test
    @DisplayName("Test: Addition of zero to an intergers")
    void addition_zeroToInteger_correctSum(){
        // Arrange
        Calculator calculator = new Calculator();

        // Act
        int result = calculator.addition(0, 8);

        // Assert
        assertEquals(8, result, "The correct sum 8");
    }

    // TEST SUBTRACTION METHOD OF THE CALCULATOR

    @Test
    @DisplayName("Test Subtract, two positive integers")
        // Method name should be methodName_scenario_expecetedBehavior
    void subtract_twoPositiveIntegers_correctProduct(){
        // Arrange
        Calculator calculator = new Calculator();
        // Act
        int result = calculator.subtract(5,3);
        // Assert
        assertEquals(2, result, "The correct sum 2");
    }

    @Test
    @DisplayName("Subtracting a larger number (negative result)")
    void subtract_twoLargeValueFromSmall_negativeProduct(){
        // Arrange
        Calculator  calculator = new Calculator();

        // Act
        int result = calculator.subtract(2, 14);

        // Assert
        assertEquals(-12, result, "negative product -12");
    }

    @Test
    @DisplayName("Subtracting zero")
    void subtract_zero_correctProduct(){
        // Arrange
        Calculator  calculator = new Calculator();

        // Act
        int result = calculator.subtract(2, 0);

        // Assert
        assertEquals(2, result, "negative product 2");
    }

    @Test
    @DisplayName("Test with even positive numbers (2, 4, 100)")
    void isEven_TestEvenIntegers_True(){
        // Arrange
        Calculator  calculator = new Calculator();

        // Act
        boolean result = calculator.isEven(2);
        // Assert
        assertTrue(result, "2 is even");
        assertTrue(calculator.isEven(4), "4 is Even");
        assertTrue(calculator.isEven(100), "100 is Even ");
    }

    @Test
    @DisplayName("Test with odd numbers (1, 3, 99)")
    void isEven_threeOddIntegers_False(){
        // Arrange
        Calculator calculator = new Calculator();

        // Act & Assert. This is a combined step since we are not storing the result in a variable
        // Using assertFalse to check odd numbers. This will pass if the isEven method returns false for odd numbers
        assertFalse(calculator.isEven(1), "1 is Odd");
        assertFalse(calculator.isEven(3), "3 is Odd");
        assertFalse(calculator.isEven(99), "99 is Odd");
    }

    @Test
    @DisplayName("Test with zero (is 0 even?)")
    void isEven_Zero_True(){
        // Arrange
        Calculator calculator = new Calculator();
        // Act & Assert
        assertTrue(calculator.isEven(0), "0 is Even");
    }

    @Test
    @DisplayName("Test with negative)")
    void isEven_negative_True(){
        // Arrange
        Calculator calculator = new Calculator();
        // Act & Assert
        assertTrue(calculator.isEven(-2), "-2 is Even");
    }










}
