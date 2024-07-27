import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

public class UserDAO {
    private MongoCollection<Document> collection;

    public UserDAO(MongoDatabase database) {
        this.collection = database.getCollection("users");
    }
    public User getUserById(String id) {
        try {
            ObjectId objectId = new ObjectId(id);
            Document doc = collection.find(eq("_id", objectId)).first();
            if (doc != null) {
                return new User(
                        doc.getObjectId("_id").toString(),
                        doc.getString("username"),
                        doc.getString("email"),
                        doc.getString("password"),
                        doc.getString("fullName")
                );
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Geçersiz ObjectId formatı: " + id);
        }
        return null;
    }



    public User getUserByUsername(String username) {
        Document doc = collection.find(eq("username", username)).first();
        if (doc != null) {
            return new User(
                    doc.getObjectId("_id").toString(),
                    doc.getString("username"),
                    doc.getString("email"),
                    doc.getString("password"),
                    doc.getString("fullName")
            );
        }
        return null;
    }

    public void addUser(User user) {
        Document document = new Document("username", user.getUsername())
                .append("email", user.getEmail())
                .append("password", user.getPassword())
                .append("fullName", user.getFullName());
        collection.insertOne(document);
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        for (Document doc : collection.find()) {
            User user = new User(
                    doc.getObjectId("_id").toString(),
                    doc.getString("username"),
                    doc.getString("email"),
                    doc.getString("password"),
                    doc.getString("fullName")
            );
            users.add(user);
        }
        return users;
    }
}
