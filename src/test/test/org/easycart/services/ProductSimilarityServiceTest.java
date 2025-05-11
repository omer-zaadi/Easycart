package test.org.easycart.services;

import LCSalgo.LCSDynamicProgramming;
import LCSalgo.IAlgoLCS;
import main.java.org.easycart.dm.Product;
import main.java.org.easycart.services.ProductSimilarityService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSimilarityServiceTest {

    @Test
    public void testFindSimilarProducts() {
        List<Product> productList = List.of(
                new Product("1", "Milk", "Dairy", 6.0, 20),
                new Product("2", "Malk", "Dairy", 5.5, 30),
                new Product("3", "Bread", "Bakery", 4.0, 15)
        );

        IAlgoLCS algorithm = new LCSDynamicProgramming();
        ProductSimilarityService service = new ProductSimilarityService(productList, algorithm);

        List<Product> result = service.findSimilarProducts("mlk", 2);

        assertEquals(2, result.size());
        assertTrue(result.get(0).getName().equalsIgnoreCase("Milk")
                || result.get(0).getName().equalsIgnoreCase("Malk"));
    }
}
