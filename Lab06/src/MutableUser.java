public interface MutableUser extends ReadOnlyUser {
    void setEmail(String email);
    void setPassword(String password);
    void setUserType(int userType);

    String getPassword();
}
