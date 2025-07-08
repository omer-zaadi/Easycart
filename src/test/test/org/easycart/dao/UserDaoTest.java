package test.org.easycart.dao;

import main.java.org.easycart.dm.User;
import main.java.org.easycart.dao.InMemoryUserDao;
import main.java.org.easycart.dao.UserDao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    @Test
    public void testAddAndGetUser() {
        UserDao dao = new InMemoryUserDao();
        User user = new User("1", "Ron", "ron@email.com", "admin");
        dao.addUser(user);

        User found = dao.getUserById("1");
        assertNotNull(found);
        assertEquals("Ron", found.getName());
    }

    @Test
    public void testUpdateUser() {
        UserDao dao = new InMemoryUserDao();
        User user = new User("1", "Ron", "ron@email.com", "admin");
        dao.addUser(user);

        User updated = new User("1", "Ronny", "ronny@email.com", "customer");
        dao.updateUser(updated);

        User found = dao.getUserById("1");
        assertEquals("Ronny", found.getName());
        assertEquals("ronny@email.com", found.getEmail());
    }

    @Test
    public void testDeleteUser() {
        UserDao dao = new InMemoryUserDao();
        User user = new User("1", "Ron", "ron@email.com", "admin");
        dao.addUser(user);

        dao.deleteUser("1");
        assertNull(dao.getUserById("1"));
    }

    @Test
    public void testGetAllUsers() {
        UserDao dao = new InMemoryUserDao();
        dao.addUser(new User("1", "Ron", "ron@email.com", "admin"));
        dao.addUser(new User("2", "Gal", "gal@email.com", "customer"));

        List<User> users = dao.getAllUsers();
        assertEquals(2, users.size());
    }
}
