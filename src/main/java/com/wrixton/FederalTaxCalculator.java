package com.wrixton;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

import java.util.HashMap;
import java.util.Map;

public class FederalTaxCalculator {

    //SINGLE:
    //#1: 0 - 9,325 -> 10%
    //#2: 9,325 - 37,950 -> $932.50 plus 15% of the excess over $9,325
    //#3: 37,950 - $91,900 -> $5,226.25 plus 25% of the excess over $37,950
    //#4: 91,900 - 191,650 -> $18,713.75 plus 28% of the excess over $91,900
    //#5: 191,650 - 416,700 -> $46,643.75 plus 33% of the excess over $191,650
    //#6: 416,700 - 418,400 -> $120,910.25 plus 35% of the excess over $416,700
    //#7: $418,400 ++++ -> $121,505.25 plus 39.6% of the excess over $418,400

    //Medicare -> 1.45%
    //Social Security -> 6.20%
    //Roth 401k - X%
    //Traditional 401k - X%
    //Other pretax deductions (Like transportation)

    private Map<Integer, TaxInfo> taxBrackets;

    public FederalTaxCalculator() {
        taxBrackets = new HashMap<Integer, TaxInfo>();
        taxBrackets.put(1, new TaxInfo(.10, Range.range(0.0, BoundType.CLOSED, 9325.0, BoundType.CLOSED)));
        taxBrackets.put(2, new TaxInfo(.15, Range.range(9325.0, BoundType.OPEN, 37950.0, BoundType.CLOSED)));
        taxBrackets.put(3, new TaxInfo(.25, Range.range(37950.0, BoundType.OPEN, 91900.0, BoundType.CLOSED)));
        taxBrackets.put(4, new TaxInfo(.28, Range.range(91900.0, BoundType.OPEN, 191650.0, BoundType.CLOSED)));
        taxBrackets.put(5, new TaxInfo(.33, Range.range(191650.0, BoundType.OPEN, 416700.0, BoundType.CLOSED)));
        taxBrackets.put(6, new TaxInfo(.35, Range.range(416700.0, BoundType.OPEN, 418400.0, BoundType.CLOSED)));
        taxBrackets.put(7, new TaxInfo(.396, Range.range(418400.0, BoundType.OPEN, Double.POSITIVE_INFINITY, BoundType.OPEN)));
    }

    public Map<Integer, TaxInfo> getTaxBrackets() {
        return taxBrackets;
    }

    public double calculate(double income){
        double result = 0;

        for(int i = 1; i < taxBrackets.keySet().size(); i++){
            TaxInfo info = taxBrackets.get(i);
            if(info.getTaxRange().contains(income)){
                result += info.getPercentage() * (income - info.getTaxRange().lowerEndpoint());
                break;
            } else {
                result += info.getPercentage() * (info.getTaxRange().upperEndpoint() - info.getTaxRange().lowerEndpoint());
            }
        }

        return result;
    }

    //MARRIED:
    //#1: 0 - 9,325 -> 10%
    //#2: 9,325 - 37,950 -> $932.50 plus 15% of the excess over $9,325
    //#3: 37,950 - $91,900 -> $5,226.25 plus 25% of the excess over $37,950
    //#4: 91,900 - 191,650 -> $18,713.75 plus 28% of the excess over $91,900
    //#5: 191,650 - 416,700 -> $46,643.75 plus 33% of the excess over $191,650
    //#6: 416,700 - 418,400 -> $120,910.25 plus 35% of the excess over $416,700
    //#7: $418,400 ++++ -> $121,505.25 plus 39.6% of the excess over $418,400


}
