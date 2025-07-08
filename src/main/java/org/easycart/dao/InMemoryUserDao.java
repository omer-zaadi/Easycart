package main.java.org.easycart.dao;

import main.java.org.easycart.dm.User;
import java.util.*;

public class InMemoryUserDao implements UserDao {
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUserById(String id) {
        return users.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public void deleteUser(String id) {
        users.remove(id);
    }
}
