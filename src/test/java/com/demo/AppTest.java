package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    void testValidEnergy() {
        assertTrue(App.isValidEnergy(100));
    }

    @Test
    void testInvalidEnergyNegative() {
        assertFalse(App.isValidEnergy(-10));
    }

    @Test
    void testInvalidEnergyHigh() {
        assertFalse(App.isValidEnergy(250));
    }
}