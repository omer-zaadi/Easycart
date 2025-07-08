package test.org.easycart.services;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dao.CartItemDao;
import main.java.org.easycart.dao.InMemoryCartItemDao;
import main.java.org.easycart.services.CartService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    @Test
    public void testAddCartItemAndTotal() {
        CartItemDao cartDao = new InMemoryCartItemDao();
        CartService cartService = new CartService(cartDao);

        Product milk = new Product("1", "Milk", "Dairy", 5.0, 100);
        Product bread = new Product("2", "Bread", "Bakery", 3.0, 50);

        CartItem milkItem = new CartItem("1", milk, 2);
        CartItem breadItem = new CartItem("2", bread, 1);

        cartService.addCartItem(milkItem);
        cartService.addCartItem(breadItem);

        List<CartItem> items = cartService.getAllCartItems();
        assertEquals(2, items.size());

        double total = cartService.calculateTotal();
        assertEquals(13.0, total, 0.001);
    }

    @Test
    public void testUpdateCartItemQuantity() {
        CartItemDao cartDao = new InMemoryCartItemDao();
        CartService cartService = new CartService(cartDao);

        Product milk = new Product("1", "Milk", "Dairy", 5.0, 100);
        CartItem milkItem1 = new CartItem("1", milk, 2);

        cartService.addCartItem(milkItem1);

        // הוסף שוב אותו מוצר, הכמות צריכה להתעדכן ל-4
        CartItem milkItem2 = new CartItem("1", milk, 2);
        cartService.addCartItem(milkItem2);

        CartItem updated = cartService.getAllCartItems().stream()
                .filter(item -> item.getId().equals("1")).findFirst().orElse(null);

        assertNotNull(updated);
        assertEquals(4, updated.getQuantity());
    }

    @Test
    public void testDeleteCartItem() {
        CartItemDao cartDao = new InMemoryCartItemDao();
        CartService cartService = new CartService(cartDao);

        Product juice = new Product("3", "Juice", "Drinks", 6.0, 30);
        CartItem juiceItem = new CartItem("3", juice, 1);

        cartService.addCartItem(juiceItem);
        assertEquals(1, cartService.getAllCartItems().size());

        cartService.deleteCartItem("3");
        assertTrue(cartService.getAllCartItems().isEmpty());
    }

    @Test
    public void testClearCart() {
        CartItemDao cartDao = new InMemoryCartItemDao();
        CartService cartService = new CartService(cartDao);

        Product milk = new Product("1", "Milk", "Dairy", 5.0, 100);
        Product bread = new Product("2", "Bread", "Bakery", 3.0, 50);

        cartService.addCartItem(new CartItem("1", milk, 2));
        cartService.addCartItem(new CartItem("2", bread, 1));

        assertFalse(cartService.getAllCartItems().isEmpty());

        cartService.clearCart();
        assertTrue(cartService.getAllCartItems().isEmpty());
    }
}
