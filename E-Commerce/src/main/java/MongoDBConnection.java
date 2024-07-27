import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "ecommerce";
    private static MongoDatabase database;

    static {
        try {
            MongoClient mongoClient = MongoClients.create(CONNECTION_STRING);
            database = mongoClient.getDatabase(DATABASE_NAME);
            System.out.println("MongoDB'ye başarılı bir şekilde bağlanıldı.");
        } catch (Exception e) {
            System.err.println("MongoDB bağlantı hatası: " + e.getMessage());
        }
    }

    public static MongoDatabase getDatabase() {
        return database;
    }
}
