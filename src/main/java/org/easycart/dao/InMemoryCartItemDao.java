package main.java.org.easycart.dao;

import main.java.org.easycart.dm.CartItem;
import java.util.*;

public class InMemoryCartItemDao implements CartItemDao {
    private final Map<String, CartItem> cartItems = new HashMap<>();

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItems.put(cartItem.getId(), cartItem);
    }

    @Override
    public CartItem getCartItemById(String id) {
        return cartItems.get(id);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return new ArrayList<>(cartItems.values());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItems.put(cartItem.getId(), cartItem);
    }

    @Override
    public void deleteCartItem(String id) {
        cartItems.remove(id);
    }
}
