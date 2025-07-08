package main.java.org.easycart.dao;

import main.java.org.easycart.dm.CartItem;
import java.util.List;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);
    CartItem getCartItemById(String id);
    List<CartItem> getAllCartItems();
    void updateCartItem(CartItem cartItem);
    void deleteCartItem(String id);
}
