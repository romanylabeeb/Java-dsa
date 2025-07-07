package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static int longestCommonUsMemoization(String s1, String s2) {
        int[][] lookup = new int[s1.length()][s2.length()];
        return longestCommonSubsequence_recursive(s1, s2, 0, 0, lookup);
    }

    public static int longestCommonSubsequence_recursive(String s1, String s2, int i, int j, int[][] lookup) {
        if (i == s1.length() || j == s2.length()) return 0;
        if (lookup[i][j] != 0)
            return lookup[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            lookup[i][j] = 1 + longestCommonSubsequence_recursive(s1, s2, i + 1, j + 1, lookup);
            return lookup[i][j];
        }
        lookup[i][j] = Math.max(longestCommonSubsequence_recursive(s1, s2, i + 1, j, lookup),
                longestCommonSubsequence_recursive(s1, s2, i, j + 1, lookup));
        return lookup[i][j];
    }

    public static void main(String[] args) {
        String s1 = "abcbdevbbbbbbbbbb";
        String s2 = "acbebbjkbbbbbb";
        System.out.println(longestCommonUsMemoization(s1, s2));
    }
}
