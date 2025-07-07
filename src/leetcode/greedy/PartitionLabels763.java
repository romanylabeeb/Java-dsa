package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartitionLabels763 {

    public static List<Integer> partitionLabels(String s) {
        int[] chars = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            //last index
            chars[s.charAt(i) - 'a'] = i;

        }
        int lp = 0;
        while (lp < s.length()) {
            int rp = chars[s.charAt(lp) - 'a'];
            for (int j = lp + 1; j < rp; ++j) {
                int cur = chars[s.charAt(j) - 'a'];
                if (cur > rp) {
                    rp = cur;
                }
            }
            res.add(rp-lp+1);
            lp = rp+1;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}


