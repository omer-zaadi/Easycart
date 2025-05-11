package test.org.easycart.dm;

import main.java.org.easycart.dm.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testIsAdmin() {
        User admin = new User("1", "Ron", "ron@test.com", "admin");
        User customer = new User("2", "Dana", "omer@test.com", "customer");

        assertTrue(admin.isAdmin());
        assertFalse(customer.isAdmin());
    }

    @Test
    public void testUserFields() {
        User u = new User("3", "Lior", "lior@test.com", "customer");

        assertEquals("3", u.getId());
        assertEquals("Lior", u.getName());
        assertEquals("lior@test.com", u.getEmail());
        assertEquals("customer", u.getRole());
    }
}
