package leetcode.bitOperations;

/**
 * 
 */
public class SumXOR {
    public static void main(String[] args) {
        int[] a = new int[]{5, 1, 6};
        System.out.println(subsetXORSum(a));
    }

    public static int subsetXORSum(int[] nums) {
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; ++i) {
            int v0 = nums[i];
            int subXor = 0;
            for (int j = i + 1; j < n; ++j) {
                int val = nums[j];
                subXor += (subXor ^ val) + (v0 ^ val);
            }
            res += v0 + subXor;
        }
        return res;
    }
}
