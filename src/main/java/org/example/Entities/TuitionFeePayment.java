package org.example.Entities;

public class TuitionFeePayment {
    private double totalTuition;
    private double balance;

    public void setTuition(double totalTuition) {
        this.totalTuition = totalTuition;
        this.balance = totalTuition;
    }

    public double getBalance() {
        return balance;
    }

    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }

    public boolean isFullyPaid() {
        return balance <= 0;
    }
}