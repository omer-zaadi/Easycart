package test.org.easycart.services;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dao.ProductDao;
import main.java.org.easycart.dao.InMemoryProductDao;
import main.java.org.easycart.services.ProductService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    public void testAddProduct() {
        ProductDao dao = new InMemoryProductDao();
        ProductService service = new ProductService(dao);

        Product milk = new Product("1", "Milk", "Dairy", 6.0, 20);
        service.addProduct(milk);

        List<Product> products = service.getAllProducts();
        assertEquals(1, products.size());
        assertEquals("Milk", products.get(0).getName());
    }

    @Test
    public void testGetProductById() {
        ProductDao dao = new InMemoryProductDao();
        ProductService service = new ProductService(dao);

        Product bread = new Product("2", "Bread", "Bakery", 4.0, 15);
        service.addProduct(bread);

        Product p = service.getProductById("2");
        assertNotNull(p);
        assertEquals("Bread", p.getName());
        assertEquals("Bakery", p.getCategory());
    }

    @Test
    public void testDeleteProduct() {
        ProductDao dao = new InMemoryProductDao();
        ProductService service = new ProductService(dao);

        Product eggs = new Product("3", "Eggs", "Dairy", 10.0, 12);
        service.addProduct(eggs);
        assertEquals(1, service.getAllProducts().size());

        service.deleteProduct("3");
        assertEquals(0, service.getAllProducts().size());
    }
    @Test
    public void testUpdateProduct() {
        ProductDao dao = new InMemoryProductDao();
        ProductService service = new ProductService(dao);

        Product milk = new Product("1", "Milk", "Dairy", 6.0, 20);
        service.addProduct(milk);

        // עדכון מחיר ומלאי
        Product updatedMilk = new Product("1", "Milk", "Dairy", 8.5, 30);
        service.updateProduct(updatedMilk);

        Product fromDb = service.getProductById("1");
        assertNotNull(fromDb);
        assertEquals(8.5, fromDb.getPrice());
        assertEquals(30, fromDb.getStock());
    }
}
