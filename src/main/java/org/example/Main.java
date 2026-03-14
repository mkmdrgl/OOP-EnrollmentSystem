package org.example;
import org.example.service.TuitionFeePayment;

public class Main {
    public static void main(String[] args) {
        TuitionFeePayment tuitionFeePayment = new TuitionFeePayment();
        System.out.println(tuitionFeePayment.calculateTuitionFee(3, 0.10));

    }
}