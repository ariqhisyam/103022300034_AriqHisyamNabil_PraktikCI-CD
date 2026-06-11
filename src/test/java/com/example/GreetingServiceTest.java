package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("GreetingService Tests")
class GreetingServiceTest {

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingService();
    }

    @Test
    @DisplayName("Sapaan normal dengan nama valid")
    void testGreet_validName() {
        String result = greetingService.greet("World");
        assertEquals("Halo, World! Selamat datang di Simple Java App.", result);
    }

    @Test
    @DisplayName("Sapaan dengan nama Indonesia")
    void testGreet_indonesianName() {
        String result = greetingService.greet("Ariq");
        assertTrue(result.contains("Ariq"));
        assertTrue(result.startsWith("Halo,"));
    }

    @Test
    @DisplayName("Sapaan dengan nama null harus throw exception")
    void testGreet_nullName_throwsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> greetingService.greet(null)
        );
        assertEquals("Nama tidak boleh kosong", exception.getMessage());
    }

    @Test
    @DisplayName("Sapaan dengan nama kosong harus throw exception")
    void testGreet_emptyName_throwsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> greetingService.greet("")
        );
    }

    @Test
    @DisplayName("Sapaan dengan nama spasi harus throw exception")
    void testGreet_blankName_throwsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> greetingService.greet("   ")
        );
    }

    @Test
    @DisplayName("Sapaan formal dengan title")
    void testGreetFormal_withTitle() {
        String result = greetingService.greetFormal("Budi", "Bapak");
        assertEquals("Selamat datang, Bapak Budi!", result);
    }

    @Test
    @DisplayName("Sapaan formal tanpa title")
    void testGreetFormal_withoutTitle() {
        String result = greetingService.greetFormal("Budi", null);
        assertEquals("Selamat datang, Budi!", result);
    }

    @Test
    @DisplayName("Sapaan formal dengan nama null harus throw exception")
    void testGreetFormal_nullName_throwsException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> greetingService.greetFormal(null, "Bapak")
        );
    }
}
