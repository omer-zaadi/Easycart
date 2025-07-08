package main.java.org.easycart.services;

import main.java.org.easycart.dm.CartItem;
import main.java.org.easycart.dao.CartItemDao;
import java.util.List;

public class CartService {
    private final CartItemDao cartItemDao;

    public CartService(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    public void addCartItem(CartItem cartItem) {
        // אם כבר יש CartItem עם אותו id, עדכן את הכמות
        CartItem existing = cartItemDao.getCartItemById(cartItem.getId());
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + cartItem.getQuantity());
            cartItemDao.updateCartItem(existing);
        } else {
            cartItemDao.addCartItem(cartItem);
        }
    }

    public void deleteCartItem(String id) {
        cartItemDao.deleteCartItem(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemDao.getAllCartItems();
    }

    public double calculateTotal() {
        return cartItemDao.getAllCartItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public void clearCart() {
        for (CartItem item : cartItemDao.getAllCartItems()) {
            cartItemDao.deleteCartItem(item.getId());
        }
    }
}
