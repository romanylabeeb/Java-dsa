package leetcode.arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes283 {
    public static void moveZeroes(int[] nums) {
        int p = 0,n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[p++] = nums[i];
            }
        }
        for(int i=p;i<n;i++){
            nums[i]=0;
        }
        System.out.println("d");
    }

    public static void main(String[] args) {
int[]a={1,0,0,2,3,0,1};
        moveZeroes(a);
    }
}
