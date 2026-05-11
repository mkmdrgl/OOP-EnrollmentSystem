package org.example.Implementations;

import org.example.Exceptions.InvalidPaymentExcep;
import org.example.Interfaces.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {
    private final double PRICE_PER_UNIT = 1000.00;

    public double calculateFee(int units, double discountRate) {
        double total = units * PRICE_PER_UNIT;

        if (discountRate > 0) {
            total = total - (total * discountRate);
        }
        return total;
    }

    public double makePayment(double currentBalance, double amountPaid) throws InvalidPaymentExcep {
        if (amountPaid <= 0) {
            throw new InvalidPaymentExcep("Payment amount must be greater than zero.");
        }
        if (amountPaid > currentBalance) {
            throw new InvalidPaymentExcep("Payment cannot exceed the remaining balance of " + currentBalance);
        }
        return currentBalance - amountPaid;
    }

    public double getRemainingBalance(double totalTuition, double totalPaid) {
        return totalTuition - totalPaid;
    }
}