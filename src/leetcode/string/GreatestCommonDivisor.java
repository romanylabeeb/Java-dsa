package leetcode.string;

import java.lang.reflect.Array;
import java.util.*;

public class GreatestCommonDivisor {
    //https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int ind = gcd(str1.length(), str2.length());
        return str2.substring(0, ind);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> uSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            uSet.add(c); // Add each char to the set
        }
        int count=0;
        for(String word: words){
            count+=countConsistWord(word,uSet);
        }
        return count;
    }

    int countConsistWord(String word, Set<Character> uSet) {
        for (char c : word.toCharArray()) {
            if (!uSet.contains(c)) {
                return 0;
            }
        }
        return 1;
    }
    static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for (int v : candies) {
            res.add((v + extraCandies) > max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }

    public String reverseWords(String s) {
        String[] list = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            String ts = list[i].trim();
            if (!ts.isBlank()) {
                if (!sb.isEmpty()) {
                    sb.append(" ");
                }
                sb.append(ts);
            }
        }
        return sb.toString();
    }

    public String reverseVowels(String s) {
        int lp = 0;
        int rp = s.length() - 1;
        Set<Character> vowels = Set.of
                ('a', 'o', 'e', 'i', 'u',
                        'A', 'O', 'E', 'I', 'U');
        char[] chars = s.toCharArray();
        while (lp < rp) {
            while (lp < rp && !vowels.contains(s.charAt(lp))) {
                lp++;
            }
            while (lp < rp && !vowels.contains(s.charAt(rp))) {
                rp--;
            }
            if (lp != rp) {
                char t = s.charAt(lp);
                chars[lp++] = chars[rp];
                chars[rp--] = t;
            }
        }
        return String.valueOf(chars);
    }
}
