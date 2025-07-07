package leetcode.arrays;


public class MaxTriplet {

    public static long maximumTripletValue(int[] nums) {
        if (nums.length < 3) return 0;
        int lp = 0, rp = 1;
        int lMinIndex = 1;
        long maxSub = nums[lp]-nums[rp];
        while (rp < nums.length - 2) {
            int sub = nums[lp] - nums[rp];
            if (sub > 0) {
                if (sub > maxSub) {
                    maxSub = sub;
                    lMinIndex = rp;
                }
                rp++;
            } else {
                lp = rp;
                rp++;
            }
        }
        if (maxSub<=0) return 0;
        long maxMuliply = 0;
        for (int j = lMinIndex + 1; j < nums.length; j++) {
            if (nums[j] > maxMuliply) {
                maxMuliply = nums[j];
            }
        }
        return maxSub * maxMuliply;
    }

    public static void main(String[] args) {
        int[] a = {1000000,1,1000000};
        System.out.println(maximumTripletValue(a));
        a = new int[]{12, 6, 1, 2, 7};
        System.out.println(maximumTripletValue(a));
    }
}
