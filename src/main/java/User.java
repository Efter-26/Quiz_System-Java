import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static User login() throws IOException, ParseException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();

        JSONParser parser = new JSONParser();
        JSONArray usersArray = (JSONArray) parser.parse(new FileReader("./src/main/resources/users.json"));

        for (Object userObj : usersArray) {
            JSONObject userJSON = (JSONObject) userObj;
            if (userJSON.get("username").equals(username) && userJSON.get("password").equals(password)) {
                return new User(username, password, (String) userJSON.get("role"));
            }
        }
        System.out.println("Invalid credentials, try again.");
        return null;
    }

    public String getRole() {
        return this.role;
    }

    public String getName() {
        return this.username;
    }
}

