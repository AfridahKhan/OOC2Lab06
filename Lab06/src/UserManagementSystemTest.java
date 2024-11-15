import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserManagementSystemTest {
    @Test
    void testAuthenticateUser() {
        UserManagementService userManagementService = UserManagement.getInstance();
        userManagementService.addUser("regularuser", "regularuser@example.com", "password123", UserType.REGULAR);

        ReadOnlyUser user = userManagementService.authenticateUser("regularuser", "password123");
        assertNotNull(user);
        assertEquals(UserType.REGULAR, user.getUserType());

        user = userManagementService.authenticateUser("invaliduser", "wrongpassword");
        assertNull(user);
    }

    @Test
    void testGetUser() {
        UserManagementService userManagementService = UserManagement.getInstance();
        userManagementService.addUser("poweruser", "poweruser@example.com", "password456", UserType.POWER);

        ReadOnlyUser user = userManagementService.getUser("poweruser");
        assertNotNull(user);
        assertEquals(UserType.POWER, user.getUserType());

        user = userManagementService.getUser("nonexistentuser");
        assertNull(user);
    }

    @Test
    void testAddUser() {
        UserManagementService userManagementService = UserManagement.getInstance();
        userManagementService.addUser("newregularuser", "newregularuser@example.com", "password456", UserType.REGULAR);

        ReadOnlyUser user = userManagementService.getUser("newregularuser");
        assertNotNull(user);
        assertEquals(UserType.REGULAR, user.getUserType());

        userManagementService.addUser("newadminuser", "newadminuser@example.com", "password789", UserType.ADMIN);
        user = userManagementService.getUser("newadminuser");
        assertNotNull(user);
        assertEquals(UserType.ADMIN, user.getUserType());
    }

    @Test
    void testUpdateUser() {
        UserManagementService userManagementService = UserManagement.getInstance();
        userManagementService.addUser("regularuser", "regularuser@example.com", "password123", UserType.REGULAR);

        userManagementService.updateUser("regularuser", "regularuser@example.com", "newpassword123", UserType.POWER);
        ReadOnlyUser user = userManagementService.getUser("regularuser");
        assertNotNull(user);
        assertEquals(UserType.POWER, user.getUserType());
        assertEquals("regularuser@example.com", user.getEmail());
    }
}
