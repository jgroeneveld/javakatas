package de.jgroeneveld.katas.supermarket;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.*;

public class BundlePricingRuleTest {

    @Test
    public void testCalculatePrice() throws Exception {
        PricingRule strategy = new BundlePricingRule(12, 3, 30);

        assertThat(strategy.calculatePrice(2), IsEqual.equalTo(24));
        assertThat(strategy.calculatePrice(3), IsEqual.equalTo(30));
        assertThat(strategy.calculatePrice(4), IsEqual.equalTo(42));
    }
}