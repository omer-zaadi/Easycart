package main.java.org.easycart.server;

public class ServerDriver {
    public static void main(String[] args) {
        Server server = new Server(34567); // port
        new Thread(server).start();
    }
}
