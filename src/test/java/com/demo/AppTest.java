package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // ✅ Full refund
    @Test
    void testFullRefund() {
        assertEquals(1000, App.cancelTicket(1000, 30));
    }

    // ✅ Partial refund
    @Test
    void testPartialRefund() {
        assertEquals(500, App.cancelTicket(1000, 15));
    }

    // ❌ No refund
    @Test
    void testNoRefund() {
        assertEquals(0, App.cancelTicket(1000, 5));
    }

    // ❌ Invalid ticket price
    @Test
    void testInvalidPrice() {
        assertEquals(-1, App.cancelTicket(-100, 10));
    }

    // ❌ Invalid hours
    @Test
    void testInvalidHours() {
        assertEquals(-1, App.cancelTicket(500, -2));
    }
}