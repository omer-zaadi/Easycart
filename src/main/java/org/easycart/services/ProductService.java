package main.java.org.easycart.services;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dm.User;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, User user) {
        if (!user.isAdmin()) {
            throw new SecurityException("Only admins can add products");
        }
        products.add(product);
    }

    public Product getProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
