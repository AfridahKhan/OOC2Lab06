import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserFileManager {
    private static final String USER_FILE = "User.csv";

    public Map<String, MutableUser> loadUsers() {
        Map<String, MutableUser> users = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int userId = Integer.parseInt(parts[0]);
                String username = parts[1];
                String email = parts[2];
                String password = parts[3];
                int userType = Integer.parseInt(parts[4]);
                MutableUser user = UserFactory.createUser(userId, username, email, password, userType);
                users.put(username, user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void saveUsers(Map<String, MutableUser> userMap) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(USER_FILE))) {
            pw.println("UserID,Username,Email,Password,UserType");
            for (MutableUser user : userMap.values()) {
                pw.println(user.getUserId() + "," + user.getUsername() + "," + user.getEmail() + "," + user.getPassword() + "," + user.getUserType());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}