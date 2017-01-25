package com.wrixton;

public class PayAndTaxCalculator {

    private double income;

    public PayAndTaxCalculator(double income) {
        this.income = income;
    }

    public TaxResult calculate(){
        double federalIncomeTax = new FederalTaxCalculator().calculate(income);
        double postTaxIncome = income - federalIncomeTax;
        return new TaxResult(postTaxIncome, federalIncomeTax);
    }
}
