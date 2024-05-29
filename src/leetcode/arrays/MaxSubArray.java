package leetcode.arrays;

/**
 * Given an integer array nums, find the
 * subarray
 *  with the largest sum, and return its sum.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int prefixSum = 0;
        for (int v : nums) {
            prefixSum += v;
            if (prefixSum < 0) {
                prefixSum = 0;
            }
            maxSum = Math.max(maxSum, prefixSum);

        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, -1, 7, 8};
        maxSubArray(a);
    }
}
