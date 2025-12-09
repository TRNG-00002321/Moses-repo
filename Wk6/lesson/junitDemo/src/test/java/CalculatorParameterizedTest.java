import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


import com.raveture.junitDemo.Calculator;

public class CalculatorParameterizedTest {
    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest(name="Addition Test with {0} + {1} = {2}")
    @CsvSource({
        "1, 1, 2",
        "2, 3, 5",
        "5, 8, 13"
    })

    public void testAdd(int a, int b, int expected) {
        int result = calculator.add(a, b);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name="Subtraction Test with {0} - {1} = {2}")
    @CsvSource({
        "5, 3, 2",
        "10, 4, 6",
        "20, 5, 15"
    })
    public void testSubtract(int a, int b, int expected) {
        int result = calculator.subtract(a, b);
        assertEquals(expected, result);
    }
    
    // csv resource in a file
    @ParameterizedTest(name="Multiplication Test with {0} * {1} = {2}")
    @CsvFileSource(resources="/TestData.csv", numLinesToSkip=1)
    public void testMultiply(int a, int b, int expected) {
        int result = calculator.multiply(a, b);
        assertEquals(expected, result);
    }  
    
    static Stream<Arguments> divisionProvider() {
        return Stream.of(
            Arguments.of(10, 2, 5),
            Arguments.of(20, 4, 5),
            Arguments.of(15, 3, 5)
        );
    }

}
