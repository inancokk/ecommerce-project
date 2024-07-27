import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class LoginUser {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ecommerce");

        UserService userService = new UserService(database);

        User user = userService.getUserByUsername("username");
        if (user != null) {
            System.out.println("Kullanıcı adı: " + user.getUsername());
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }
    }
}
