package org.example.Interfaces;

public class ITuitionService {
    private final double PRICE_PER_UNIT = 1000.00;

    public double calculateFee(int units, double discountRate) {
        double total = units * PRICE_PER_UNIT;

        if (discountRate > 0) {
            total = total - (total * discountRate);
        }
        return total;
    }
}