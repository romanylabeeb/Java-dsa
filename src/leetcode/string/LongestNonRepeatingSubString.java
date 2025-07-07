package leetcode.string;

import java.util.*;

public class LongestNonRepeatingSubString {

    public static int lengthOfLongestSubstring(String s) {
        int lp = 0;
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int prev = map.getOrDefault(c, -1);
            if (prev >= lp) {
                int len = i - lp;
                lp = prev + 1;
                max = Math.max(max, len);
            }
            map.put(c, i);
        }
        return Math.max(max, s.length() - lp);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        while (p1 < word1.length() && p2 < word2.length()) {
            sb.append(word1.charAt(p1++));
            sb.append(word2.charAt(p2++));
        }
        if (p1 < word1.length()) {
            sb.append(word1.substring(p1));
        }
        if (p2 < word2.length()) {
            sb.append(word2.substring(p2));
        }
        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        ////
        for (int i = 0; i < minLength; i++) {
            for (String s : strs) {
                if (s.charAt(i) != strs[0].charAt(i))
                    return s.substring(0, i);
            }
        }
        return strs[0];
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        StringBuilder sb;
        int lp =0;
        for(int i=1;i<nums.length;i++){
            int sub = nums[i] - nums[i - 1];
            if (sub != 1) {
                sb = new StringBuilder();
                sb.append(nums[lp]);
                if (i - lp > 1) {
                    sb.append("->").append(nums[i-1]);
                }
                lp = i;
                res.add(sb.toString());
            }
        }
        if(lp<nums.length){
            sb = new StringBuilder();
            sb.append(nums[lp]);
            if (nums.length-1 - lp > 1) {
                sb.append("->").append(nums[nums.length-1]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        int []a={0,2,3,4,6,8,9};
        System.out.println(summaryRanges(a));
    }
}
