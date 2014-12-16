package de.jgroeneveld.katas.supermarket;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglePricingRuleTest {

    @Test
    public void testCalculatePrice() throws Exception {
        PricingRule strategy = new SinglePricingRule(12);

        assertThat(strategy.calculatePrice(2), IsEqual.equalTo(24));
    }
}