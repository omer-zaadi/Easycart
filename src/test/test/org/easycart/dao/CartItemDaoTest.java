package test.org.easycart.dao;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dao.InMemoryCartItemDao;
import main.java.org.easycart.dao.CartItemDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartItemDaoTest {

    @Test
    public void testAddAndGetCartItem() {
        CartItemDao dao = new InMemoryCartItemDao();
        Product milk = new Product("1", "Milk", "Dairy", 6.0, 10);
        CartItem item = new CartItem("item1", milk, 2);
        dao.addCartItem(item);

        CartItem found = dao.getCartItemById("item1");
        assertNotNull(found);
        assertEquals("Milk", found.getProduct().getName());
        assertEquals(2, found.getQuantity());
    }

    @Test
    public void testUpdateCartItem() {
        CartItemDao dao = new InMemoryCartItemDao();
        Product milk = new Product("1", "Milk", "Dairy", 6.0, 10);
        CartItem item = new CartItem("item1", milk, 2);
        dao.addCartItem(item);

        CartItem updated = new CartItem("item1", milk, 5);
        dao.updateCartItem(updated);

        CartItem found = dao.getCartItemById("item1");
        assertEquals(5, found.getQuantity());
    }

    @Test
    public void testDeleteCartItem() {
        CartItemDao dao = new InMemoryCartItemDao();
        Product bread = new Product("2", "Bread", "Bakery", 4.0, 5);
        CartItem item = new CartItem("item2", bread, 1);
        dao.addCartItem(item);

        dao.deleteCartItem("item2");
        assertNull(dao.getCartItemById("item2"));
    }

    @Test
    public void testGetAllCartItems() {
        CartItemDao dao = new InMemoryCartItemDao();
        Product milk = new Product("1", "Milk", "Dairy", 6.0, 10);
        Product bread = new Product("2", "Bread", "Bakery", 4.0, 5);

        dao.addCartItem(new CartItem("item1", milk, 2));
        dao.addCartItem(new CartItem("item2", bread, 1));

        List<CartItem> items = dao.getAllCartItems();
        assertEquals(2, items.size());
    }
}
