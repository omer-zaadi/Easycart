package main.java.org.easycart.services;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.dao.ProductDao;
import java.util.List;

public class ProductService {
    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    public Product getProductById(String id) {
        return productDao.getProductById(id);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    public void deleteProduct(String id) {
        productDao.deleteProduct(id);
    }
}
