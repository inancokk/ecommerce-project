import java.util.ArrayList;
import java.util.List;

public class CartService {

    public List<CartItem> getCartItems(String userId) {
        List<CartItem> cartItems = new ArrayList<>();

        return cartItems;
    }

    public void addToCart(String userId, String productId, int quantity) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        List<CartItem> items = new ArrayList<>();

        CartItem item = new CartItem();
        item.setProductId(productId);
        item.setQuantity(quantity);
        items.add(item);

        cart.setItems(items);
    }
}
