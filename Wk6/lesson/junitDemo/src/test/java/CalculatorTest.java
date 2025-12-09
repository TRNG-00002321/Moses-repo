
import org.junit.jupiter.api.*;

import com.raveture.junitDemo.Calculator; // Make sure this matches your actual package
import static org.junit.jupiter.api.Assertions.*;  // Use static import for cleaner assertions

public class CalculatorTest {
    
    // Better practice: Initialize in @BeforeEach instead of here
    private Calculator calculator;
    
    @BeforeAll
    public static void setupClass() {  // FIXED: Added 'static'
        System.out.println("BeforeAll: Setting up class-level resources");
    }
    
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();  // Initialize fresh for each test
        System.out.println("Setting up tests: BeforeEach");
    }
    
    @Test
    @DisplayName("Testing addition of two numbers")
    // @Disabled : to disable a test
    void testAddition() {
        // Arrange
        int n1 = 10;
        int n2 = 20;
        int expectedResult = 30;
        
        // Act
        int actualResult = calculator.add(n1, n2);
        
        // Assertion
        assertEquals(expectedResult, actualResult, "Addition result should be 30");
    }
    
    // Add more tests here
    @Test
    @DisplayName("Testing subtraction")
    void testSubtraction() {
        
        assertEquals(10, calculator.subtract(20, 10), "20 - 10 should be 10");
    }

    @Test
    @DisplayName("Testing multiplication")
    void testMultiplication() {
        assertEquals(200, calculator.multiply(20, 10), "20 * 10 should be 200");
    }

    // Testing division: implement the exception case as well
    @Test
    @DisplayName("Testing division")
    void testDivision() {
        assertEquals(2, calculator.divide(20, 10), "20 / 10 should be 2");
    }   
    @Test
    @DisplayName("Testing division by zero")
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0), "Division by zero should throw ArithmeticException");
    }

    
    @AfterEach
    public void tearDown() {
        System.out.println("Tearing down tests: AfterEach");
        calculator = null;  // Optional cleanup
    }
    
    @AfterAll
    public static void tearDownClass() {  // FIXED: Added 'static' and return type 'void'
        System.out.println("AfterAll: Cleaning up class-level resources");
    }

    
}