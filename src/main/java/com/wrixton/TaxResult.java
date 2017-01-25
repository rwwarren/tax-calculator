package com.wrixton;

public class TaxResult {

    double postTaxIncome;
    double federalTaxPaid;

    public TaxResult(double postTaxIncome, double federalTaxPaid) {
        this.postTaxIncome = postTaxIncome;
        this.federalTaxPaid = federalTaxPaid;
    }

    @Override
    public String toString() {
        return "TaxResult{" +
                "postTaxIncome=" + postTaxIncome +
                ", federalTaxPaid=" + federalTaxPaid +
                '}';
    }
}
