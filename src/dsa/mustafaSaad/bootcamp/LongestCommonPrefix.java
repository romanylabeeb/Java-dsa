package dsa.mustafaSaad.bootcamp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/submissions/1321152089/
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        if (s1.length() == 0 || s2.length() == 0) return "";
        int p = 0;
        StringBuilder sb = new StringBuilder();
        while (p < s1.length() && p < s2.length()) {
            if (s1.charAt(p) == s2.charAt(p)) {
                sb.append(s1.charAt(p++));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String []s={"ab", "a"};
        System.out.println(longestCommonPrefix(s));
    }
}
