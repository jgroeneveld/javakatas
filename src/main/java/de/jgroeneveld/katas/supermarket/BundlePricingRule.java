package de.jgroeneveld.katas.supermarket;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class BundlePricingRule implements PricingRule {
    private int unitPrice;
    private final int unitsPerBundle;
    private final int bundlePrice;

    public BundlePricingRule(int unitPrice, int unitsPerBundle, int bundlePrice) {
        this.unitPrice = unitPrice;
        this.unitsPerBundle = unitsPerBundle;
        this.bundlePrice = bundlePrice;
    }


    @Override
    public int calculatePrice(int amount) {
        int bundles = amount / unitsPerBundle;
        int singleUnits = amount % unitsPerBundle;
        return bundles * bundlePrice + singleUnits * unitPrice;
    }
}
