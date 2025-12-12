import com.raveture.testLifeCycle.MockDatabase;
import com.raveture.testLifeCycle.User;
import com.raveture.testLifeCycle.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest {
    private static MockDatabase database;
    private UserRepository repository;

    @BeforeAll
    static void setUpDatabase() {
        // TODO: Initialize the database connection
        // This runs ONCE before all tests
        System.out.println("Connecting to database...");
        database = new MockDatabase();
        database.connect();
    }

    @AfterAll
    static void tearDownDatabase() {
        // TODO: Close the database connection
        // This runs ONCE after all tests
        System.out.println("Disconnecting from database...");
        database.disconnect();
    }

    @BeforeEach
    void setUpTest() {
        // TODO: Clear all data from database
        database.clearAll();
        // TODO: Create a new repository instance
        repository = new UserRepository(database);
        // TODO: Insert any test fixtures needed
        // Optional: Insert baseline test data
        database.insert(new User(1, "Admin", "admin@test.com"));
    }

    @AfterEach
    void tearDownTest() {
        // TODO: Any per-test cleanup
        // Note: The database is cleared in setUpTest anyway
        System.out.println("Test completed, data will be reset");
    }

    @Test
    @DisplayName("Test 1: Add user and verify")
    void test1_addUser() {
        // Add a user
        repository.save(new User(2, "John", "john@test.com"));

        // Verify it exists
        Assertions.assertEquals(2, repository.count());  // Admin + John
    }

    @Test
    @DisplayName("Test 2: Should have fresh state")
    void test2_freshState() {
        // This test should ONLY see the Admin user
        // NOT the John user from test1
        Assertions.assertEquals(1, repository.count());  // Only Admin
    }

    @Test
    @DisplayName("Test 3: Database operations work independently")
    void test3_independentOperations() {
        repository.save(new User(3, "Jane", "jane@test.com"));
        repository.save(new User(4, "Bob", "bob@test.com"));
        // Should have Admin + 2 new users
        Assertions.assertEquals(3, repository.count());
    }
}


