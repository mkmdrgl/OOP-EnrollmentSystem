package org.example.Implementations;

import org.example.Exceptions.InvalidPaymentExcep;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionServiceImplTest {

    private TuitionServiceImpl tuitionService;

    @BeforeEach
    void setUp() {
        tuitionService = new TuitionServiceImpl();
    }

    @Test
    void testCalculateFeeLogic() {
        assertEquals(3000.00, tuitionService.calculateFee(3, 0), 0.001);

        assertEquals(9000.00, tuitionService.calculateFee(10, 0.10), 0.001);
    }

    @Test
    void testMakePayment_Success() throws InvalidPaymentExcep {
        double currentBalance = 5000.00;
        double payment = 2000.00;

        double newBalance = tuitionService.makePayment(currentBalance, payment);

        assertEquals(3000.00, newBalance, 0.001);
    }

    @Test
    void testMakePayment_InvalidAmount() {
        assertThrows(InvalidPaymentExcep.class, () -> {
            tuitionService.makePayment(1000.00, 0);
        }, "Should reject zero payment");

        assertThrows(InvalidPaymentExcep.class, () -> {
            tuitionService.makePayment(1000.00, -50);
        }, "Should reject negative payment");
    }

    @Test
    void testMakePayment_ExceedingBalance() {
        double balance = 1000.00;
        double overpayment = 1001.00;

        InvalidPaymentExcep exception = assertThrows(InvalidPaymentExcep.class, () -> {
            tuitionService.makePayment(balance, overpayment);
        });

        assertTrue(exception.getMessage().contains("cannot exceed"));
    }

    @Test
    void testGetRemainingBalance() {
        double totalTuition = 10000.00;
        double totalPaid = 4500.00;

        double balance = tuitionService.getRemainingBalance(totalTuition, totalPaid);

        assertEquals(5500.00, balance, 0.001);
    }
}