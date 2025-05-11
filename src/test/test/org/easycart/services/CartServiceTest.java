package test.org.easycart.services;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dm.Product;
import main.java.org.easycart.services.CartService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartServiceTest {

    @Test
    public void testAddToCartAndTotal() {
        CartService cart = new CartService();
        Product milk = new Product("1", "Milk", "Dairy", 5.0, 100);
        Product bread = new Product("2", "Bread", "Bakery", 3.0, 50);

        cart.addToCart(milk, 2); // 10.0
        cart.addToCart(bread, 1); // 3.0

        List<CartItem> items = cart.getAllItems();
        assertEquals(2, items.size());

        double total = cart.calculateTotal();
        assertEquals(13.0, total, 0.001);
    }

    @Test
    public void testRemoveFromCart() {
        CartService cart = new CartService();
        Product juice = new Product("3", "Juice", "Drinks", 6.0, 30);

        cart.addToCart(juice, 1);
        cart.removeFromCart("3");

        assertTrue(cart.getAllItems().isEmpty());
    }
}
