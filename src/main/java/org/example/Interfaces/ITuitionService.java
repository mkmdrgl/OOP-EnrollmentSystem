package org.example.Interfaces;

public interface ITuitionService {
    double calculateFee(int units, double discountRate);
    double makePayment(double totalTuition, double amountPaid);
    double getRemainingBalance(double totalTuition, double totalPaid);
}