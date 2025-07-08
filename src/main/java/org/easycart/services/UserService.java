package main.java.org.easycart.services;

import main.java.org.easycart.dao.UserDao;
import main.java.org.easycart.dm.User;
import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public User getUserById(String id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }
}
