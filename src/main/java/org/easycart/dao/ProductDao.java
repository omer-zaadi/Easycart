package main.java.org.easycart.dao;

import java.util.List;
import main.java.org.easycart.dm.Product;

public interface ProductDao {
    void addProduct(Product product);
    Product getProductById(String id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    void deleteProduct(String id);
}
