package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, false);
        }
        //////// all false;
        int max = 0;
        for (int v : nums) {
            int res = getMax(v, map);
            max = Math.max(max, res);
        }
        return max;
    }

    static int getMax(int v, Map<Integer, Boolean> map) {
        if (!map.containsKey(v) || map.get(v) == true) return 0;
        map.put(v, true);
        int count = 1;
        // get right values
        int rk = v + 1;
        while (map.containsKey(rk) && map.get(rk) == false) {
            map.put(rk++, true);
            count++;
        }
        int lk = v - 1;
        while (map.containsKey(lk) && map.get(lk) == false) {
            map.put(lk--, true);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(a));
    }
}
