package leetcode.arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] nums) {
        int lp=0;
        int rp=nums.length-1;
        while(lp<rp){
            while(lp<rp&&nums[lp]%2==0){
                lp++;
            }
            if(nums[lp]%2!=0){
                while(rp>lp&&nums[rp]%2!=0) rp--;
                int tmp=nums[rp];
                nums[rp--]=nums[lp];
                nums[lp++]=tmp;
            }
        }
        return nums;
    }
}
