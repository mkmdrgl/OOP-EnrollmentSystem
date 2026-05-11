package org.example.Interfaces;

import org.example.Exceptions.InvalidPaymentExcep;

public interface ITuitionService {
    double calculateFee(int units, double discountRate);
    double makePayment(double totalTuition, double amountPaid) throws InvalidPaymentExcep;
    double getRemainingBalance(double totalTuition, double totalPaid);
}