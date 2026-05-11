package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup() {

    }

    @Test
    void shouldMakeAPayment() {
        tuitionFeePayment.calculateTuitionFee(3,0.10);

        // Act
        tuitionFeePayment.makePayment(1000);

        // Assert
        assertEquals(1700, tuitionFeePayment.getRemainingBalance());
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
        tuitionFeePayment.calculateTuitionFee(3, 0.10);

        // Act
        tuitionFeePayment.makePayment(1000);

        // Assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsFullyPaid() {
        tuitionFeePayment.calculateTuitionFee(3, 0.10);

        // Act
        tuitionFeePayment.makePayment();
    }

}