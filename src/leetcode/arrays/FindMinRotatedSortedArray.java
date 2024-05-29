package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinRotatedSortedArray {
    /**
     * problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * sol: https://www.youtube.com/watch?v=nIVW4P8b1VA&ab_channel=NeetCode
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;

        while (l <= r) {
            // if nums is sorted from L to R
            if (nums[l] <= nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            }
            int mid = (l + r) / 2;
            min = Math.min(min, nums[mid]);
            // check if left portion is sorted then search in right subarray
            if (nums[mid] >= nums[l]) {  // is equal to if nums[mid]>= nums[r] -->right is unsorted
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return min;
    }


    /**
     * problem: https://leetcode.com/problems/search-in-rotated-sorted-array/
     * sol: https://www.youtube.com/watch?v=U8XENwh8Oy8&ab_channel=NeetCode
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        //Input: nums = [4,5,6,7,0,1,2],
        // target = 0
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;
            // if left is sorted search on it
            if (nums[l] <= nums[mid]) {
                // target doesn't exist in the left portion  THEN move to right
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else { //  nums[l] <= target <= nums[mid]  change right point
                    r = mid - 1;
                }
            }

            // if right is sorted
            else {
                // nums[mid] <= target <= nums[r]
                if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                } else l = mid + 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        int r = nums.length - 1;
        while (i < r - 1 && nums[i] < 0) {
            int l = i + 1;
            int v = nums[i++];
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (r > l && nums[r] == nums[r - 1]) {
                r--;
            }
            while (l < r) {
                int sum = v + nums[l] + nums[r];
                if (sum == 0) {
                    Integer[] a = {v, nums[l], nums[r]};
                    res.add(Arrays.asList(a));
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}
