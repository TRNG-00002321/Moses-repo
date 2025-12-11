import com.raveture.unitTesting.Calculator;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;


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

    @ParameterizedTest
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
    @ParameterizedTest
    @CsvSource({
            "4, 2, 2",
            "6, 4, 2",
            "8, 5, 3",
            "10, 5, 5"
    })
    void subtract_variousInputs_returnCorrectDiff(int a, int b, int expected){
        assertEquals(expected, calc.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "4, 2, 8",
            "6, 4, 24",
            "8, 5, 40",
            "10, 5, 50"
    })
    void multiply_variousInputs_returnCorrectProduct(int a, int b, int expected){
        assertEquals(expected, calc.multiply(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2, 5",
            "4, 2, 2",
            "6, 2, 3",
            "100, 5, 20"
    })
    void divide_variousInput_returnCorrectQuotient(int a, int b, int expected){
        assertEquals(expected, calc.divide(a, b));
    }

}
