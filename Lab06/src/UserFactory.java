public class UserFactory {
    public static MutableUser createUser(int userId, String username, String email, String password, int userType) {
        switch (userType) {
            case UserType.REGULAR:
                return new RegularUser(userId, username, email, password);
            case UserType.POWER:
                return new PowerUser(userId, username, email, password);
            case UserType.ADMIN:
                return new AdminUser(userId, username, email, password);
            default:
                throw new IllegalArgumentException("Invalid user type");
        }
    }
}