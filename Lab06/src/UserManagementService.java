public interface UserManagementService {
    ReadOnlyUser authenticateUser(String username, String password);
    ReadOnlyUser getUser(String username);
    void addUser(String username, String email, String password, int userType);
    void updateUser(String username, String email, String password, int userType);
}