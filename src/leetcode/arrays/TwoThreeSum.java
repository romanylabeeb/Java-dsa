package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
//        -4, -1, -1, 0, 1,1, 2,3
        // get first element and solve it as two sum
        int n = nums.length - 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>0){break;} // stop
            // remove duplicates at first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            TwoSum(nums, i, res);
        }
        return res;
    }

    private static void TwoSum(int[] nums, int i, List<List<Integer>> res) {
        int l = i + 1;
        int r = nums.length - 1;
        int t = -nums[i];
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == t) {
                res.add(Arrays.asList(-1 * t, nums[l++], nums[r--]));
                //skip duplicates  left
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (sum > t) {
                r--;
            } else {
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> b = threeSum(a);

    }
}