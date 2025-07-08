package main.java.org.easycart.Controller;

import main.java.org.easycart.dm.Product;
import main.java.org.easycart.services.ProductService;
import main.java.org.easycart.dao.InMemoryProductDao;
import main.java.org.easycart.server.Request;
import main.java.org.easycart.server.Response;

import java.util.Map;

public class Controller {
    private static final ProductService productService = new ProductService(new InMemoryProductDao());

    public static Response<?> handle(Request<Map<String, Object>> request) {
        String action = request.getHeaders().get("action");
        switch (action) {
            case "product/add":
                Map<String, Object> prodMap = request.getBody();
                Product product = mapToProduct(prodMap);
                productService.addProduct(product);
                return success("Product added", null);

            case "product/get":
                String prodId = (String) request.getBody().get("id");
                Product p = productService.getProductById(prodId);
                return success("Product found", p);

            case "product/getall":
                return success("All products", productService.getAllProducts());

            default:
                return fail("Unknown action");
        }
    }

    private static Product mapToProduct(Map<String, Object> map) {
        String id = (String) map.get("id");
        String name = (String) map.get("name");
        String category = (String) map.get("category");
        double price = ((Number) map.get("price")).doubleValue();
        int stock = ((Number) map.get("stock")).intValue();
        return new Product(id, name, category, price, stock);
    }

    private static Response<Object> success(String msg, Object data) {
        Response<Object> res = new Response<>();
        res.setSuccess(true);
        res.setMessage(msg);
        res.setData(data);
        return res;
    }
    private static Response<Object> fail(String msg) {
        Response<Object> res = new Response<>();
        res.setSuccess(false);
        res.setMessage(msg);
        return res;
    }
}
