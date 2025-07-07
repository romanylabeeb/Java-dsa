package leetcode.arrays;

import java.util.Map;
import java.util.TreeMap;

public class LargestKthElementArray215 {
    public static int findKthLargest(int[] nums, int k) {

        Map<Integer, Integer> sorted = new TreeMap<>((a, b) -> a < b ? 1 : -1);
        for (int v : nums) {
            int count = sorted.getOrDefault(v, 0);
            sorted.put(v, count + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sorted.entrySet()) {
            count += entry.getValue();
            if (count >= k) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []a={3,2,1,5,6,4};
        System.out.println(findKthLargest(a,2));
    }
}
