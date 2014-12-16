package de.jgroeneveld.katas;

import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

// https://app.box.com/s/mjj6jqdeblif53y8dzpq
public class CharCounterTest {

    @Test
    public void testCount_EmptyInput() throws Exception {
        String input = "";
        Map<Character, Integer> expected = new HashMap<Character, Integer>() {
        };

        assertThat(CharCounter.count(input), IsEqual.equalTo(expected));
    }

    @Test
    public void testCount_NotEmpty() throws Exception {
        String input = "This is not!";
        Map<Character, Integer> expected = new HashMap<Character, Integer>() {
        };
        expected.put('T', 1);
        expected.put('h', 1);
        expected.put('i', 2);
        expected.put('s', 2);
        expected.put(' ', 2);
        expected.put('n', 1);
        expected.put('o', 1);
        expected.put('t', 1);
        expected.put('!', 1);

        assertThat(CharCounter.count(input), IsEqual.equalTo(expected));
    }

    @Test
    public void testCount_IgnoreCase() throws Exception {
        String input = "This is not!";
        Map<Character, Integer> expected = new HashMap<Character, Integer>() {
        };
        expected.put('t', 2);
        expected.put('h', 1);
        expected.put('i', 2);
        expected.put('s', 2);
        expected.put(' ', 2);
        expected.put('n', 1);
        expected.put('o', 1);
        expected.put('!', 1);

        assertThat(CharCounter.countIgnoringCase(input), IsEqual.equalTo(expected));
    }
}