package users;

import com.raveture.service.UserService;
import com.raveture.users.dao.UserRepository;

@ExtendWith(MockitoExtension.class) // Enable Mockito annotations
public class UserServiceTest {
    @Mock // Creates the mocked userRepository
    @InjectMocks // Injects the mocked repository into the service
    private UserRepository repository;
    @InjectMocks // Injects the mocked repository into the service
    private UserService service;
    private User existingUser;
    private User newUser;

    @BeforeEach
    public void setUp(){
        existingUser=new User(1L, "John Doe", "johndoe@gmail.com");
        newUser=new User(null, "Jane Smith", "Janesmith@gmail.com");
    }

    @Test
    public void testUserById_positive(){
        // Arrange
        when(repository.findById(1L)).thenReturn(existingUser);
        // Act
        User foundUser=service.getUserById(1L);
        // Assert
        assertEquals(existingUser, foundUser);

        // Verify that repository's findById was called once with 1L
        verify(repository, times(1)).findById(1L);
    }

    // Negative test case for getUserById
    @Test
    public void testUserById_negative(){
        // Arrange
        when(repository.findById(2L)).thenReturn(null);
        // Act
        User foundUser=service.getUserById(2L);
        // Assert
        assertNull(foundUser);

    // test for successful registration of a new user
    // Test for registering for an existing user

}
