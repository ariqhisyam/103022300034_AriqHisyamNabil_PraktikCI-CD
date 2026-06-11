package com.example;

/**
 * CalculatorService
 * Service untuk operasi matematika dasar
 */
public class CalculatorService {

    /**
     * Menjumlahkan dua bilangan
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Mengurangi dua bilangan
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Mengalikan dua bilangan
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Membagi dua bilangan
     * @throws IllegalArgumentException jika pembagi adalah nol
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Pembagi tidak boleh nol");
        }
        return (double) a / b;
    }
}
