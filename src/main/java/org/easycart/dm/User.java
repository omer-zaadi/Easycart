package main.java.org.easycart.dm;

public class User {
    private String id;
    private String name;
    private String email;
    private String role; // "admin" או "customer"

    public User(String id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public boolean isAdmin() {
        return "admin".equalsIgnoreCase(role);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
}
