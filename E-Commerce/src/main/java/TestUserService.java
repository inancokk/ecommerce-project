import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class TestUserService {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ecommerce");

        UserService userService = new UserService(database);
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password123");
        user.setFullName("Test User");

        userService.addUser(user);

        List<User> users = userService.listUsers();
        for (User u : users) {
            System.out.println("Username: " + u.getUsername());
        }

        mongoClient.close();
    }
}
