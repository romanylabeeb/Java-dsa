package leetcode.arrays;

public class LongestSubOneAfterDeleteZero {
    public static int longestSubarray(int[] nums) {
        int lp = 0;
        int countZero = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                count++;
            } else {
                ++countZero;
                max=Math.max(max, count);
                if (countZero > 1) {
                    while (nums[lp] == 1) {
                        count--;
                        lp++;
                    }
                    countZero=1;
                    lp++;
                }
            }
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        System.out.println(longestSubarray(a));
    }
}
