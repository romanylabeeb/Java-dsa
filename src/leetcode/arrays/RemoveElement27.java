package leetcode.arrays;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement27 {
    public static int removeElement(int[] nums, int val) {
        // two pointers
        // swap keep val to be at the end of the array

        int lp = 0;
        int rp = nums.length - 1;
        int count = 0;
        while (lp < rp) {
            if (nums[lp] == val) {
                if (nums[rp] != val) {
                    count++;
                    nums[lp++] = nums[rp];
                    nums[rp] = val;
                }
                rp--;
            } else {
                lp++;
                count++;
            }
        }
        if (nums[lp] != val) {
            count++;
        }
        return count;
    }

    public int removeElement2(int[] nums, int val) {
        int pointer=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[pointer++]=nums[i];
            }
        }
        return pointer;
    }
    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        System.out.println(removeElement(a, 3));
    }
}
