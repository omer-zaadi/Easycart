package main.java.org.easycart.services;

import LCSalgo.IAlgoLCS;
import main.java.org.easycart.dm.Product;

import java.util.*;

public class ProductSimilarityService {

    private final List<Product> products;
    private final IAlgoLCS lcsAlgorithm;

    public ProductSimilarityService(List<Product> products, IAlgoLCS lcsAlgorithm) {
        this.products = products;
        this.lcsAlgorithm = lcsAlgorithm;
    }

    public List<Product> findSimilarProducts(String searchTerm, int maxResults) {
        Map<Product, Integer> scoreMap = new HashMap<>();

        for (Product product : products) {
            int score = lcsAlgorithm.computeLCS(searchTerm.toLowerCase(), product.getName().toLowerCase());
            scoreMap.put(product, score);
        }

        return scoreMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(maxResults)
                .map(Map.Entry::getKey)
                .toList();
    }
}
