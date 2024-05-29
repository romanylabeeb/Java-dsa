package leetcode.arrays;

public class MaxProduct {
    /**
     * problem: https://leetcode.com/problems/maximum-product-subarray/
     * solution: https://www.youtube.com/watch?v=lXVy6YWFcRM&ab_channel=NeetCode
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int min = 1, max = 1;
        for (int v : nums) {
            int prevMax=max;
            max = Math.max(v, Math.max(v * max, v * min));
            min=Math.min(v, Math.min(v * prevMax, v * min));
            res=Math.max(res,max);
        }
        return res;
    }
}
