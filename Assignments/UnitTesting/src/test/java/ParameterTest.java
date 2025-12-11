import com.raveture.unitTesting.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;


public class ParameterTest {

    Calculator calc = new Calculator();

    // BEFORE: Repetitive!
    // Testig isEven method with multiple test cases. But this is repetitive!
    @Test void isEven_2_returnsTrue() { assertTrue(calc.isEven(2)); }
    @Test void isEven_4_returnsTrue() { assertTrue(calc.isEven(4)); }
    @Test void isEven_100_returnsTrue() { assertTrue(calc.isEven(100)); }

    // AFTER: Parameterized Test
    @ParameterizedTest// Indicate that this is a parameterized test
    @ValueSource(ints = {2,4,6,8,100,0,-4})
    void isEven_evenNumbers_returnsTrue(int number){
        assertTrue(calc.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7})
    void isEven_oddNumbers_returnsFalse(int number){
        assertFalse(calc.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5,2,1})
    void isPositive_positiveNumbers_returnsTrue(int n){
        assertTrue(calc.isPositive(n));
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "3,5,8",
            "10,-4,6",
            "-3,-5,-8",
            "0,8,8",
            "3,5,8",
            "10,-4,6"
    })
    void add_variousInputs_returnCorrectSum(int a, int b, int expected){
        assertEquals(expected, calc.addition(a, b));
    }

    // Subtract method parameterized test
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({
            "4, 2, 2",
            "6, 4, 2",
            "8, 5, 3",
            "10, 5, 5"
    })
    void subtract_variousInputs_returnCorrectDiff(int a, int b, int expected){
        assertEquals(expected, calc.subtract(a, b));
    }

    // Multiply method parameterized test
    @ParameterizedTest(name="{0} * {1} = {2}")
    @CsvSource({
            "4, 2, 8",
            "6, 4, 24",
            "8, 5, 40",
            "10, 5, 50"
    })
    void multiply_variousInputs_returnCorrectProduct(int a, int b, int expected){
        assertEquals(expected, calc.multiply(a, b));
    }

    // Divide method parameterized test
    @ParameterizedTest(name="{0} / {1} = {2}") //  Added custom display name
    @CsvSource({
            "10, 2, 5",
            "4, 2, 2",
            "6, 2, 3",
            "100, 5, 20"
    })
    void divide_variousInput_returnCorrectQuotient(int a, int b, int expected){
        assertEquals(expected, calc.divide(a, b));
    }

    // Using Method Source for more complex parameterized tests and custom display names
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @MethodSource("provideDivisionTestCases")
    void divide_variousCases_returnsCorrectQuotient(int a, int b, int expected) {
        assertEquals(expected, calc.divide(a, b));
    }

    // The Stream is a sequence of elements supporting sequential and parallel aggregate operations.
    static Stream<Arguments> provideDivisionTestCases() {
        return Stream.of(
                Arguments.of(10, 2, 5),
                Arguments.of(9, 3, 3),
                Arguments.of(-10, 2, -5),
                Arguments.of(7, 2, 3)  // Integer division
        );
    }

    // isEven method using Method Source
    @ParameterizedTest(name = "{0} is even: {1}")
    @MethodSource("provideIsEvenTestCases")
    void isEven_variousCases_returnsExpected(int number, boolean expected) {
        assertEquals(expected, calc.isEven(number));
    }

    static Stream<Arguments> provideIsEvenTestCases() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, false),
                Arguments.of(0, true),
                Arguments.of(-4, true),
                Arguments.of(-5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("egdeCasesForPower()")
    void power_edgeCases(int base, int exponent, int expected) {
        assertEquals(expected, Math.pow(base, exponent));
    }
    static Stream<Arguments> egdeCasesForPower() {
        return Stream.of(
                Arguments.of(0, 0, 1),   // 0^0 is typically defined as 1
                Arguments.of(0, 5, 0),   // 0^n = 0 for n > 0
                Arguments.of(5, 0, 1),   // n^0 = 1 for n > 0
                Arguments.of(-2, 3, -8), // Negative base with odd exponent
                Arguments.of(-2, 4, 16)  // Negative base with even exponent
        );
    }

    // Custome display names for parameterized tests
    @ParameterizedTest(name = "Adding {0} and {1} should equal {2}")
    @CsvSource({
            "1, 2, 3",
            "5, 7, 12",
            "-3, 3, 0"
    })
    void add_withCustomDisplayName(int a, int b, int expected) {
        assertEquals(expected, calc.addition(a, b));
    }

}
