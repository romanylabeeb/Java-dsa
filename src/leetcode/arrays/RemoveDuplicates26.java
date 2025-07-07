package leetcode.arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates26 {
    public  static int removeDuplicates(int[] nums) {
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p - 1] != nums[i]) {
                nums[p++] = nums[i];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[]a={0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(a));
    }
}
