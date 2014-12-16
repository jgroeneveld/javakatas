package de.jgroeneveld.katas;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jgroeneveld on 15.12.14.
 */
public class CharCounter {
    public static Map<Character, Integer> count(String input) {
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();

        for (int i = 0; i < input.length(); i++) {
            char keyChar = input.charAt(i);
            Integer count = result.get(keyChar);
            if (count == null) {
                count = 0;
            }
            result.put(keyChar, count + 1);
        }

        return result;
    }

    public static Map<Character, Integer> countIgnoringCase(String input) {
        input = input.toLowerCase();
        return count(input);
    }
}
