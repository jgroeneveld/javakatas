package de.jgroeneveld.katas.supermarket;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class BundlePricingRule implements PricingRule {
    private int unitPrice;
    private final int bundleAmount;
    private final int bundlePrice;

    public BundlePricingRule(int unitPrice, int bundleAmount, int bundlePrice) {
        this.unitPrice = unitPrice;
        this.bundleAmount = bundleAmount;
        this.bundlePrice = bundlePrice;
    }


    @Override
    public int calculatePrice(int amount) {
        int bundles = amount/bundleAmount;
        int singleUnits = amount%bundleAmount;
        return bundles * bundlePrice + singleUnits * unitPrice;
    }
}
