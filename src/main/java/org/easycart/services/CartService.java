package main.java.org.easycart.services;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dm.Product;

import java.util.*;

public class CartService {
    private final Map<String, CartItem> cartItems;

    public CartService() {
        this.cartItems = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) {
        String id = product.getId();
        if (cartItems.containsKey(id)) {
            CartItem existing = cartItems.get(id);
            existing.setQuantity(existing.getQuantity() + quantity);
        } else {
            cartItems.put(id, new CartItem(product, quantity));
        }
    }

    public void removeFromCart(String productId) {
        cartItems.remove(productId);
    }

    public List<CartItem> getAllItems() {
        return new ArrayList<>(cartItems.values());
    }

    public double calculateTotal() {
        return cartItems.values().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
