package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestBusStringVowels {


    public static int findTheLongestSubstring(String s) {
        Map<Integer, Integer> maskToIndex = new HashMap<>();
        maskToIndex.put(0, -1);
        int mask = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (c) {
                case 'a':
                    mask ^= 1;
                    break;
                case 'e':
                    mask ^= 2;
                    break;
                case 'i':
                    mask ^= 4;
                    break;
                case 'o':
                    mask ^= 8;
                    break;
                case 'u':
                    mask ^= 16;
                    break;
            }
            if (maskToIndex.containsKey(mask)) {
                maxLen = Math.max(maxLen, i - maskToIndex.get(mask));
            } else {
                maskToIndex.put(mask, i);
            }
        }

        return maxLen;  // Return the longest valid substring length
    }

    public static void main(String[] args) {

        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
}
