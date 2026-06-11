package com.example;

/**
 * GreetingService
 * Service untuk membuat pesan sapaan
 */
public class GreetingService {

    /**
     * Membuat pesan sapaan untuk nama tertentu
     * @param name nama yang akan disapa
     * @return string pesan sapaan
     */
    public String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        return "Halo, " + name + "! Selamat datang di Simple Java App.";
    }

    /**
     * Membuat pesan sapaan formal
     */
    public String greetFormal(String name, String title) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        return "Selamat datang, " + (title != null ? title + " " : "") + name + "!";
    }
}
