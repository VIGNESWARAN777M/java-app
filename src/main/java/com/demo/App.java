package com.demo;
import java.util.Random;

public class App {

    // Method used for testing
    public static boolean isValidEnergy(int energy) {
        return energy >= 0 && energy <= 200;
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Smart Energy Monitoring System Started...");

        Random random = new Random();

        while (true) {

            int energy = random.nextInt(250) - 50;

            if (energy < 0) {
                System.out.println("❌ Invalid Energy Reading: " + energy);
            } else if (energy > 200) {
                System.out.println("⚠️ High Energy Usage: " + energy + " kWh");
            } else {
                System.out.println("✅ Normal Energy: " + energy + " kWh");
            }

            Thread.sleep(3000);
        }
    }
}