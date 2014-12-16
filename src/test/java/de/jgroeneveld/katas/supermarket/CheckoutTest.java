package de.jgroeneveld.katas.supermarket;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

//http://codekata.com/kata/kata09-back-to-the-checkout/
public class CheckoutTest {
    @Test
    public void testCheckoutConsidersBundlesRegardlessOfOrder() throws Exception {
        Checkout checkout = new Checkout(createPricingRules());

        assertThat(checkout.getTotal(), equalTo(0));
        checkout.scan("Apple");
        assertThat(checkout.getTotal(), equalTo(50));
        checkout.scan("Banana");
        assertThat(checkout.getTotal(), equalTo(80));
        checkout.scan("Apple");
        assertThat(checkout.getTotal(), equalTo(130));
        checkout.scan("Data Stick");
        assertThat(checkout.getTotal(), equalTo(145));
        checkout.scan("Apple");
        assertThat("Checkout does not consider BundlePricingRule", checkout.getTotal(), equalTo(175));
    }

    private PricingRules createPricingRules() {
        PricingRules pricingRules = new PricingRules();
        pricingRules.addRule("Apple", new BundlePricingRule(50, 3, 130));
        pricingRules.addRule("Banana", new BundlePricingRule(30, 2, 45));
        pricingRules.addRule("Cacao", new SinglePricingRule(20));
        pricingRules.addRule("Data Stick", new SinglePricingRule(15));
        return pricingRules;
    }
}