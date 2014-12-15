package de.jgroeneveld.katas;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.InvalidParameterException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAdd_empty() throws Exception {
        assertThat(StringCalculator.Add(""), equalTo(0));
    }

    @Test
    public void testAdd_one() throws Exception {
        assertThat(StringCalculator.Add("3"), equalTo(3));
    }

    @Test
    public void testAdd_two() throws Exception {
        assertThat(StringCalculator.Add("3,5"), equalTo(8));
    }

    @Test
    public void testAdd_unknownAmountOfNumbers() throws Exception {
        assertThat(StringCalculator.Add("3,5,1,2,5"), equalTo(16));
    }

    @Test
    public void testAdd_allowsNewlineAsDelimiter() throws Exception {
        assertThat(StringCalculator.Add("1\n2,3"), equalTo(6));
    }

    @Test
    public void testAdd_allowAdditionalCustomDelimiters() throws Exception {
        assertThat(StringCalculator.Add("//;\n1,2;3\n5"), equalTo(11));
    }

    @Test
    public void testAdd_negativesThrowException() throws Exception {
        expectedException.expect(InvalidParameterException.class);
        expectedException.expectMessage("negatives not allowed: [-2, -4]");

        StringCalculator.Add("1,-2,3,-4,5");
    }
}