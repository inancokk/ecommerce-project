import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class TestProductService {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("ecommerce");

        ProductService productService = new ProductService(database);

        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product.");
        product.setPrice(9.99);
        product.setCategory("Test Category");

        productService.addProduct(product);

        List<Product> products = productService.listProducts();
        for (Product p : products) {
            System.out.println("Product Name: " + p.getName());
        }

        mongoClient.close();
    }
}
