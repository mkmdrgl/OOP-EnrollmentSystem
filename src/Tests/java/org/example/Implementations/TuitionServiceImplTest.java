package org.example.Implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {
    private TuitionServiceImpl tuitionService;

    @BeforeEach
    void setup() {
        tuitionService = new TuitionServiceImpl();
    }

    @Test
    void shouldMakeAPayment() {
        double totalTuition = tuitionService.calculateFee(3, 0.10);
        double remainingBalance = tuitionService.makePayment(totalTuition, 1000.0);
        assertEquals(1700.0, remainingBalance, "The remaining balance should be 1700 after paying 1000");
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsNotFullyPaid() {
        double totalTuition = tuitionService.calculateFee(3, 0.10);
        double remainingBalance = tuitionService.makePayment(totalTuition, 1000.0);
        assertTrue(remainingBalance > 0, "Fee should not be fully paid when balance is greater than 0");
    }

    @Test
    void shouldCheckIfTheTuitionFeeIsFullyPaid() {
        double totalTuition = tuitionService.calculateFee(3, 0.10);
        double remainingBalance = tuitionService.makePayment(totalTuition, 2700.0);
        assertEquals(0.0, remainingBalance, "Fee should be fully paid (0.0 balance)");
    }

    @Test
    void shouldCalculateRemainingBalanceCorrectly() {
        double totalTuition = 5000.0;
        double amountPaidSoFar = 2000.0;
        double result = tuitionService.getRemainingBalance(totalTuition, amountPaidSoFar);
        assertEquals(3000.0, result);
    }
}