package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MirrorScoreOfString {
    public static long calculateScore(String s) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] chars = new char[26];
        //{'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g','e', 'd', 'c', 'b', 'a'};
        // Fill the array with letters from z to a
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) ('z' - i);
        }

        long score = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            ArrayList<Integer> indecs = map.get(c);
            if (indecs != null&&!indecs.isEmpty()) {
                int j = indecs.get(indecs.size() - 1);
                score += i - j;
                indecs.remove(indecs.size() - 1);
            }
            char mir = chars[c-'a'];
            ArrayList<Integer> mirrorIndecs = map.get(mir);
            if (mirrorIndecs == null) {
                map.put(mir, new ArrayList<>());
            }
            map.get(mir).add(i);
        }
        return score;
    }

    static char mirror(char c) {
        return (char) ('a' + (26 - (c - 'a')) % 26);
    }

    public static void main(String[] args) {
        System.out.println(calculateScore("eockppxdqclkhjgvnw"));
        //eockppxdqclkhjgvnw
        //vlxpkkcwjxopsqtemd
    }
}
