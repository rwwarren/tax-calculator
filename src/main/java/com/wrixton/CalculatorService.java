package com.wrixton;

public class CalculatorService {

    public static void main(String[] args){

        PayAndTaxCalculator calculator = new PayAndTaxCalculator(80000.00);
        TaxResult result = calculator.calculate();
        System.out.println(result);
    }


}
