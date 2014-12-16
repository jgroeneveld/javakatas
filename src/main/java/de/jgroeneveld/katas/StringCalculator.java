package de.jgroeneveld.katas;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jgroeneveld on 14.12.14.
 */
public class StringCalculator {
    public static int Add(String numbers) {
        int sum = 0;
        String customDelimiter = "";

        if (numbers.startsWith("//")) {
            String firstLine = numbers.split("\n")[0];
            customDelimiter = firstLine.replaceAll("//", "");
            numbers = numbers.replaceFirst("//.?\n", "");
        }

        String[] numberParts = numbers.split("[,\n" + customDelimiter + "]");
        List<Integer> negatives = new ArrayList<Integer>();
        for (String n : numberParts) {
            if (numbers.length() > 0) {
                int val = Integer.parseInt(n);
                if (val < 0) {
                    negatives.add(val);
                }
                sum += val;
            }
        }

        if (negatives.size() > 0) {
            throw new InvalidParameterException("negatives not allowed: " + negatives);
        }

        return sum;
    }
}
