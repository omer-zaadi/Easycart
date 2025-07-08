package test.org.easycart.dm;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dm.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemTest {

    @Test
    public void testCartItemInitialization() {
        Product product = new Product("1", "Milk", "Dairy", 5.9, 50);
        CartItem item = new CartItem("item1", product, 2);

        assertEquals("item1", item.getId());
        assertEquals("Milk", item.getProduct().getName());
        assertEquals("Dairy", item.getProduct().getCategory());
        assertEquals(5.9, item.getProduct().getPrice());
        assertEquals(50, item.getProduct().getStock());
        assertEquals(2, item.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Product product = new Product("2", "Bread", "Bakery", 4.0, 30);
        CartItem item = new CartItem("item2", product, 1);

        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }
}
