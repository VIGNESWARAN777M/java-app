package com.demo;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    // ✅ Login validation logic
    public static boolean validateLogin(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String response = "Login Service Running...";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started at http://localhost:8080");

        // ✅ Console output for testing (important for exam)
        System.out.println("\n--- Login Test Output ---");

        String[][] users = {
            {"admin", "admin123"},
            {"admin", "wrong"},
            {"user", "admin123"},
            {"", "admin123"},
            {"admin", ""},
            {null, "admin123"}
        };

        for (String[] user : users) {
            boolean result = validateLogin(user[0], user[1]);

            if (result) {
                System.out.println("✅ Login Success: " + user[0]);
            } else {
                System.out.println("❌ Login Failed: " + user[0]);
            }
        }
    }
}