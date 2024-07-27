import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ecommerce");

        UserDAO userDAO = new UserDAO(database);


        String testUserId = "60c72b2f9b1d8b3f3f3f3f3f";
        User user = userDAO.getUserById(testUserId);

        if (user != null) {
            System.out.println("Kullanıcı adı: " + user.getUsername());
        } else {
            System.out.println("Kullanıcı bulunamadı.");
        }

        mongoClient.close();
    }
}
