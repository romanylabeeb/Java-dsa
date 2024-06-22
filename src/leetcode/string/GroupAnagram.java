package leetcode.string;

import leetcode.tree.InvertBST;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    char c = (char) (i + 'a');
                    key.append(c).append(":").append(count[i]);
                }
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);
        }
        return map.values().stream().collect(Collectors.toList());
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            int hash=getHashCodeUsingCharFrequency(s);
            map.computeIfAbsent(hash,k->new ArrayList<>()).add(s);
        }
        return map.values().stream().collect(Collectors.toList());
    }
    public  int getHashCodeUsingCharFrequency(String s) {
        int[] charCount = new int[26]; // Assuming the string contains only lowercase letters a-z
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Combine the frequencies into a single hash code
        int hash = 0;
        for (int count : charCount) {
            hash = 31 * hash + count; // A prime number (31) is used to generate the hash
        }

        return hash;
    }
}
