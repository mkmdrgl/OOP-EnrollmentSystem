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
}