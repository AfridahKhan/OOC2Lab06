
public class PowerUser implements MutableUser {
    private int userId;
    private String username;
    private String email;
    private String password;
    private int userType = UserType.POWER;

    public PowerUser(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public int getUserType() {
        return userType;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUserType(int userType) {
        this.userType = userType;
    }
}