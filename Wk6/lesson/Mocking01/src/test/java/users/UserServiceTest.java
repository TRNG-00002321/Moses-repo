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
    public void testUserById_negative() {
        // Arrange
        when(repository.findById(2L)).thenReturn(null);
        // Act
        User foundUser = service.getUserById(2L);
        // Assert
        assertNull(foundUser);
        // Verify that repository's findById was called once with 2L
        verify(repository, times(1)).findById(2L);
    }

    // test for successful registration of a new user
    @Test
    public void testRegisterUser_successful() {
        // Arrange
        when(repository.findByEmail(newUser.getEmail())).thenReturn(null);
        when(repository.save(newUser)).thenReturn(new User(2L, newUser.getName(), newUser.getEmail()));
        // Act
        User registeredUser = service.registerUser(newUser);
        // Assert

        assertNotNull(registeredUser); // Ensure the returned user is not null
        assertEquals(2L, registeredUser.getId()); // Ensure the ID is set correctly

        assertEquals(newUser.getName(), registeredUser.getName()); // Ensure the name matches
        assertEquals(newUser.getEmail(), registeredUser.getEmail()); // Ensure the email matches

        // Verify that repository's findByEmail was called once with the new user's email
        verify(repository, times(1)).findByEmail(newUser.getEmail()); // Verify that repository's save was called once with the new user
        verify(repository, times(1)).save(newUser);
    }
    // Test for registering for an existing user

}
