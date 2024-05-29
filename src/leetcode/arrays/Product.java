package leetcode.arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Product {
    /**
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * <p>
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     * <p>
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int prefix=1;
        res[0]=1;
        // calc prefix
        for(int i=0;i<n-1;i++){
            prefix*=nums[i];
            res[i+1]=prefix;
        }
        int suffix=1;
        for(int i=n-1;i>0;i--){
            suffix*=nums[i];
            res[i-1]=res[i-1]*suffix;
        }
        return res;
    }

    public static void main(String[] args) {
        int []a={1,2,3,4};
        int[]r=productExceptSelf(a);
    }
    public int[] productExceptSelf1(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        int countZero = 0;
        for (int v : nums) {
            // don't multiply zeros skip any zero
            prod *= v == 0 ? 1 : v;
            if (v == 0)
                countZero++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (countZero > 1) {
                res[i] = 0;
            } else if (countZero == 1) {
                res[i] = nums[i] == 0 ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }
}
