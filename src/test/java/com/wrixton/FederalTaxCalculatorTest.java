package com.wrixton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FederalTaxCalculatorTest {

    @Test
    void calculate1() {
        FederalTaxCalculator calculator = new FederalTaxCalculator();
        double taxPaid = calculator.calculate(9325.0);
        assertEquals(932.50, taxPaid);
    }

    @Test
    void calculate2() {
        FederalTaxCalculator calculator = new FederalTaxCalculator();
        double taxPaid = calculator.calculate(9326.0);
        assertEquals(932.65, taxPaid);
    }

}