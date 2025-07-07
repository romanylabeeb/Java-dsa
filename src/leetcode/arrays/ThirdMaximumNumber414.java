package leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThirdMaximumNumber414 {
    public static int thirdMax(int[] nums) {
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for (int num : nums) {
            if (num>max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(max1>num&&num>max2){
                max3 = max2;
                max2 = num;
            }
            else if(max2>num && num>max3){
                max3=num;
            }
        }

        return  max3 != Long.MIN_VALUE ? (int) max3 : (int) max1;
    }

    public static void main(String[] args) {
        int []a={2,2,3,1};
        System.out.println(thirdMax(a));
    }

    /**
     * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res=new ArrayList();
        for(int i=0;i<nums.length;i++){
            int n=Math.abs(nums[i])-1;
            if(nums[n]>0){
                nums[n]=-nums[n];
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res.add(i+1);
            }
        }
        return res;
    }
}