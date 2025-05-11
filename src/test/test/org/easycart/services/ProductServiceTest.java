package test.org.easycart.services;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dm.User;
import main.java.org.easycart.services.ProductService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testAddProductAsAdmin() {
        List<Product> productList = new ArrayList<>();
        ProductService service = new ProductService(productList);
        User admin = new User("1", "Admin", "admin@mail.com", "admin");

        Product milk = new Product("1", "Milk", "Dairy", 6.0, 20);
        service.addProduct(milk, admin);

        assertEquals(1, service.getAllProducts().size());
        assertEquals("Milk", service.getAllProducts().get(0).getName());
    }

    @Test
    public void testAddProductAsCustomerShouldFail() {
        List<Product> productList = new ArrayList<>();
        ProductService service = new ProductService(productList);
        User customer = new User("2", "User", "user@mail.com", "customer");

        Product bread = new Product("2", "Bread", "Bakery", 4.0, 15);
        assertThrows(SecurityException.class, () -> service.addProduct(bread, customer));
    }
}
