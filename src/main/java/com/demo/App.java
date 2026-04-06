package com.demo;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Random;

public class App {

    public static boolean isValidEnergy(int energy) {
        return energy >= 0 && energy <= 200;
    }

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String response = generateEnergyData();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server started at http://localhost:8080");
    }

    public static String generateEnergyData() {
        Random random = new Random();
        int energy = random.nextInt(250) - 50;

        if (energy < 0) {
            return "❌ Invalid Energy Reading: " + energy;
        } else if (energy > 200) {
            return "⚠️ High Energy Usage: " + energy + " kWh";
        } else {
            return "✅ Normal Energy: " + energy + " kWh";
        }
    }
}