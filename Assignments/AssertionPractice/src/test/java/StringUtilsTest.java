import com.raveture.assertionpractice.StringUtils;
import com.raveture.assertionpractice.User;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    @DisplayName("Test reverse() Method")
    void testReversePositive() {
        // Arrange
        StringUtils stringUtils = new StringUtils();
        // Act
        String result = stringUtils.reverse("Moses");
        // Assert
        assertEquals("sesoM", result, "Correct reverse is sesoM");
        assertEquals("a", "a", "Correct reverse is a");
        assertEquals("", "", "Correct reverse is ");
    }

    @Test
    @DisplayName("Test isEmpty() Method")
    void testIsEmptyPositive() {
        // Arrange
        StringUtils stringUtils = new StringUtils();
        // Act and Assert
        assertTrue(stringUtils.isEmpty(""));
        // Using the assertFalse to check a value that is not empty
        assertFalse(stringUtils.isEmpty("Thank You Jesus"));
    }

    @Test
    @DisplayName("Test findFirst() with Null Handling")
    void firstFind_assertNull_outPutNull(){
        // Arrange
        StringUtils stringUtils = new StringUtils();

        // Act
        String[] items = {"prefixOne", "prefixTwo", "other"};

        // Assert
        // why can't i pass an array with is not null here? Because the first test is for null input array
        assertNull(stringUtils.findFirst(items, "kai"), "Output should be null");
        // Test with existing prefix value
        assertNotNull(stringUtils.findFirst(items, "pre"), "Output should be not null");
        // Test with not null with items existing
        assertEquals("prefixOne", stringUtils.findFirst(items, "prefix"), "Output should be 'prefixOne'");

    }

    @Test
    @DisplayName("Master assertAll()")
    void user_allPropertiesValid() {
        User user = StringUtils.parseUser("John,Doe,30,john@test.com");

        assertAll("User properties",
                () -> assertEquals("John", user.getFirstName()),
                () -> assertEquals("Doe", user.getLastName()),
                () -> assertEquals(30, user.getAge()),
                () -> assertNotNull(user.getEmail()),
                () -> assertTrue(user.getEmail().contains("@"))
        );
    }

}
