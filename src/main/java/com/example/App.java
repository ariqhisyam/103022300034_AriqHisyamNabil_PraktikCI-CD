package com.example;

/**
 * Main Application Entry Point
 * Simple Java App untuk demonstrasi CI/CD Pipeline
 */
public class App {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("  Simple Java App - v1.0.0");
        System.out.println("=================================");

        CalculatorService calculator = new CalculatorService();

        System.out.println("Demo Kalkulator:");
        System.out.println("  10 + 5 = " + calculator.add(10, 5));
        System.out.println("  10 - 5 = " + calculator.subtract(10, 5));
        System.out.println("  10 * 5 = " + calculator.multiply(10, 5));
        System.out.println("  10 / 5 = " + calculator.divide(10, 5));

        GreetingService greeting = new GreetingService();
        System.out.println("\n" + greeting.greet("World"));
        System.out.println("=================================");
    }
}
