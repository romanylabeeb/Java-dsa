package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumTimeDiff {
    public static int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int max = 0;
        int count = 0;
        int n = s.length();
        int lp = 0;
        int len = Math.min(n, k);
        for (int i = 0; i < len; ++i) {
            if (vowels.indexOf(s.charAt(i)) > -1) {
                ++count;
            }
        }
        max = count;
        for (int i = len; i < n; ++i) {
            if (vowels.indexOf(s.charAt(lp++)) > -1) {
                count--;
            }
            if (vowels.indexOf(s.charAt(i)) > -1) {
                ++count;
                max = Math.max(max, count);
            }
        }
        return Math.max(max, count);
    }

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> minutes = timePoints.stream().map(t -> {
            String[] cur = t.split(":");
            return ((Integer.valueOf(cur[0]) * 60) + Integer.valueOf(cur[1]));
        }).sorted().collect(Collectors.toList());

        minutes.add(minutes.get(0) + 1440);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.size(); ++i) {
            min = Math.min(min, Math.abs(minutes.get(i - 1) - minutes.get(i)));
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "weallloveyou";

        System.out.println(maxVowels(s, 7));
    }

}
