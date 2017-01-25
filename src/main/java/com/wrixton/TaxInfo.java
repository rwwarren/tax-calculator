package com.wrixton;

import com.google.common.collect.Range;

public class TaxInfo {

    private Double percentage;
    private Range<Double> taxRange;

    public TaxInfo(double percentage, Range<Double> taxRange) {
        this.percentage = percentage;
        this.taxRange = taxRange;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Range<Double> getTaxRange() {
        return taxRange;
    }
}
