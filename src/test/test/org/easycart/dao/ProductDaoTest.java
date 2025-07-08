package test.org.easycart.dao;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dao.InMemoryProductDao;
import main.java.org.easycart.dao.ProductDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductDaoTest {

    @Test
    public void testAddAndGetProduct() {
        ProductDao dao = new InMemoryProductDao();
        Product p = new Product("1", "Milk", "Dairy", 6.0, 10);
        dao.addProduct(p);

        Product found = dao.getProductById("1");
        assertNotNull(found);
        assertEquals("Milk", found.getName());
    }

    @Test
    public void testUpdateProduct() {
        ProductDao dao = new InMemoryProductDao();
        Product p = new Product("1", "Milk", "Dairy", 6.0, 10);
        dao.addProduct(p);

        Product updated = new Product("1", "Milk", "Dairy", 7.5, 20);
        dao.updateProduct(updated);

        Product found = dao.getProductById("1");
        assertEquals(7.5, found.getPrice());
        assertEquals(20, found.getStock());
    }

    @Test
    public void testDeleteProduct() {
        ProductDao dao = new InMemoryProductDao();
        Product p = new Product("1", "Milk", "Dairy", 6.0, 10);
        dao.addProduct(p);

        dao.deleteProduct("1");
        assertNull(dao.getProductById("1"));
    }

    @Test
    public void testGetAllProducts() {
        ProductDao dao = new InMemoryProductDao();
        dao.addProduct(new Product("1", "Milk", "Dairy", 6.0, 10));
        dao.addProduct(new Product("2", "Bread", "Bakery", 4.0, 5));

        List<Product> products = dao.getAllProducts();
        assertEquals(2, products.size());
    }
}
