package de.jgroeneveld.katas.supermarket;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class PricingRulesTest {
    @Test
    public void testPricingRules() throws Exception {
        PricingRules pricingRules = new PricingRules();
        pricingRules.addRule("Apple", new BundlePricingRule(50, 3, 130));
        pricingRules.addRule("Data Stick", new SinglePricingRule(15));

        assertThat(pricingRules.calculatePrice("Apple", 2), IsEqual.equalTo(100));
        assertThat(pricingRules.calculatePrice("Apple", 3), IsEqual.equalTo(130));
        assertThat(pricingRules.calculatePrice("Data Stick", 5), IsEqual.equalTo(75));
    }
}