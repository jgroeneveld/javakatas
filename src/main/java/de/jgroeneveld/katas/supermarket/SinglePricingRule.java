package de.jgroeneveld.katas.supermarket;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class SinglePricingRule implements PricingRule {
    private int unitPrice;

    public SinglePricingRule(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int calculatePrice(int amount) {
        return unitPrice * amount;
    }
}
