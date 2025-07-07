package dsa.mustafaSaad.bootcamp;

/**
 * https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxSubArray {

    /**
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int slideSum = 0;
        int maxSlideSum = Integer.MIN_VALUE;
        for (int val : nums) {
            slideSum = Math.max(slideSum, 0) + val;
            maxSlideSum = Math.max(maxSlideSum, slideSum);
        }
        return maxSlideSum;
    }

}