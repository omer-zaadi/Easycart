package main.java.org.easycart.dao;

import main.java.org.easycart.dm.Product;
import java.util.*;

public class InMemoryProductDao implements ProductDao {
    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        return products.get(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void updateProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(String id) {
        products.remove(id);
    }
}

