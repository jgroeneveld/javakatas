package de.jgroeneveld.katas.supermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class Checkout {
    private PricingRules pricingRules;
    private List<ScannedItem> scannedItems = new ArrayList<ScannedItem>();

    public Checkout(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(String item) {
        ScannedItem scannedItem = findAlreadyScannedItem(item);

        if (scannedItem == null) {
            scannedItem = new ScannedItem(item);
            this.scannedItems.add(scannedItem);
        }

        scannedItem.amount += 1;
    }

    private ScannedItem findAlreadyScannedItem(String item) {
        for (ScannedItem i : this.scannedItems) {
            if (i.item.equals(item)) {
                return i;
            }
        }

        return null;
    }

    public int getTotal() {
        int total = 0;

        for (ScannedItem scannedItem : scannedItems) {
            total += pricingRules.calculatePrice(scannedItem.item, scannedItem.amount);
        }

        return total;
    }

    private static class ScannedItem {
        public int amount = 0;
        public String item;

        public ScannedItem(String item) {
            this.item = item;
        }
    }
}
