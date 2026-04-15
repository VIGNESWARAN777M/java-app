package com.demo;

public class App {

    public static double cancelTicket(int ticketPrice, int hoursBefore) {

        if (ticketPrice <= 0 || hoursBefore < 0) {
            return -1;
        }

        if (hoursBefore >= 24) {
            return ticketPrice;
        } else if (hoursBefore >= 12) {
            return ticketPrice * 0.5;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("=== Ticket Cancellation Service Started ===");

        int[][] tickets = {
            {1000, 30},
            {1000, 15},
            {1000, 5},
            {-100, 10},
            {500, -2}
        };

        int i = 0;

        while (true) {   // ✅ IMPORTANT FIX (keeps pod alive)

            int price = tickets[i % tickets.length][0];
            int hours = tickets[i % tickets.length][1];

            double refund = cancelTicket(price, hours);

            if (refund == -1) {
                System.out.println("❌ Invalid Ticket Data");
            } else if (refund == price) {
                System.out.println("✅ Full Refund: ₹" + refund);
            } else if (refund > 0) {
                System.out.println("⚠️ Partial Refund: ₹" + refund);
            } else {
                System.out.println("❌ No Refund");
            }

            Thread.sleep(3000); // wait 3 sec
            i++;
        }
    }
}