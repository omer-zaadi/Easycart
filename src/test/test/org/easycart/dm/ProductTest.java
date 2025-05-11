package test.org.easycart.dm;

import main.java.org.easycart.dm.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductCreation() {
        Product p = new Product("101", "Milk", "Dairy  products", 6.5, 30);

        assertEquals("101", p.getId());
        assertEquals("Milk", p.getName());
        assertEquals("Dairy", p.getCategory());
        assertEquals(6.5, p.getPrice());
        assertEquals(30, p.getStock());

    }

    @Test
    public void testUpdateStockAndPrice() {
        Product p = new Product("102", "Bread", "Bakery", 4.0, 20);

        p.setStock(15);
        p.setPrice(3.5);

        assertEquals(15, p.getStock());
        assertEquals(3.5, p.getPrice());
    }
}
