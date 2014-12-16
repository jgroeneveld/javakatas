package de.jgroeneveld.katas.supermarket;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class PricingRules {
    private Map<String, PricingRule> pricingRules = new HashMap<String, PricingRule>();

    public void addRule(String item, PricingRule pricingRule) {
        pricingRules.put(item, pricingRule);
    }

    public int calculatePrice(String item, int amount) {
        PricingRule pricingRule = pricingRules.get(item);
        return pricingRule.calculatePrice(amount);
    }
}
