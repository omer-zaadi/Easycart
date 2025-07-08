package main.java.org.easycart.server;

import main.java.org.easycart.Controller.Controller;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class HandleRequest implements Runnable {
    private final Socket clientSocket;
    private final Gson gson = new Gson();

    public HandleRequest(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String jsonRequest = reader.readLine();
            Request<Map<String, Object>> request = gson.fromJson(jsonRequest, new TypeToken<Request<Map<String, Object>>>(){}.getType());
            Response<?> response = Controller.handle(request);
            writer.println(gson.toJson(response));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
