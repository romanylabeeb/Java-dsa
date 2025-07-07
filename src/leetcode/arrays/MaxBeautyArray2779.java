package leetcode.arrays;

import java.util.Arrays;
import java.util.Map;

public class MaxBeautyArray2779 {
    //https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/?envType=daily-question&envId=2024-12-11
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int count = 1;
        int k2 = 2 * k;
        for (int i = 1; i < n; ++i) {
            int val = nums[i];
            if (val - nums[l] > k2) {
                count = Math.max(count, i - l); // res;
                int j = l + 1;
                while (j < i && val - nums[j] > k2) {
                    j++;
                }
                l = j;
            }
        }
        count = Math.max(count, n - l); // res;

        return count;
    }


    public static void main(String[] args) {
        int[] a = {4, 6, 1, 2};
        int r = maximumBeauty(a, 2);
        System.out.println(r);
    }
}
