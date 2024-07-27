import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import static com.mongodb.client.model.Filters.eq;

public class ProductService {
    private MongoCollection<Document> collection;

    public ProductService(MongoDatabase database) {
        this.collection = database.getCollection("products");
    }

    public void addProduct(Product product) {
        Document document = new Document("name", product.getName())
                .append("description", product.getDescription())
                .append("price", product.getPrice())
                .append("category", product.getCategory());
        collection.insertOne(document);
    }

    public void updateProduct(String id, Product product) {
        collection.updateOne(eq("_id", new ObjectId(id)),
                new Document("$set", new Document("name", product.getName())
                        .append("description", product.getDescription())
                        .append("price", product.getPrice())
                        .append("category", product.getCategory())));
    }

    public List<Product> listProducts() {
        List<Product> products = new ArrayList<>();
        for (Document doc : collection.find()) {
            Product product = new Product();
            product.setId(doc.getObjectId("_id").toString());
            product.setName(doc.getString("name"));
            product.setDescription(doc.getString("description"));
            product.setPrice(doc.getDouble("price"));
            product.setCategory(doc.getString("category"));
            products.add(product);
        }
        return products;
    }
}
