package com.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    // ✅ Valid login
    @Test
    void testValidLogin() {
        assertTrue(App.validateLogin("admin", "admin123"));
    }

    // ❌ Wrong password
    @Test
    void testInvalidPassword() {
        assertFalse(App.validateLogin("admin", "wrong123"));
    }

    // ❌ Wrong username
    @Test
    void testInvalidUsername() {
        assertFalse(App.validateLogin("user", "admin123"));
    }

    // ❌ Both wrong
    @Test
    void testInvalidCredentials() {
        assertFalse(App.validateLogin("user", "pass"));
    }

    // ⚠️ Empty username
    @Test
    void testEmptyUsername() {
        assertFalse(App.validateLogin("", "admin123"));
    }

    // ⚠️ Empty password
    @Test
    void testEmptyPassword() {
        assertFalse(App.validateLogin("admin", ""));
    }

    // ⚠️ Null username
    @Test
    void testNullUsername() {
        assertFalse(App.validateLogin(null, "admin123"));
    }

    // ⚠️ Null password
    @Test
    void testNullPassword() {
        assertFalse(App.validateLogin("admin", null));
    }
}