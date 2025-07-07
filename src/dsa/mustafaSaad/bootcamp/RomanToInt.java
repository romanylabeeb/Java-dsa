package dsa.mustafaSaad.bootcamp;

import java.util.*;

public class RomanToInt {
    /**
     * https://leetcode.com/problems/roman-to-integer/
     */

    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int prevVal = 0;
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int current = romanMap.get(c);

            if (current < prevVal) {
                total -= current;
            } else {
                total += current;
            }
            prevVal = current;
        }
        return total;
    }

    public int romanToInt2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0;
        int prevValue = 0;

        for (char c : s.toCharArray()) {
            int currentValue = romanMap.get(c);

            if (prevValue != 0 && currentValue > prevValue) {
                total += currentValue - 2 * prevValue;
            } else {
                total += currentValue;
            }

            prevValue = currentValue;
        }
        return total;
    }
}

interface x {

}

interface y {

}

interface z extends x, y {

}