package leetcode.arrays;

public class TrappingRainWater {

    public static long maximumTripletValueOptimal(int[] height) {
        int lp = 0, rp = height.length - 1, total = 0, maxLeft = 0, maxRight = 0;
        while (lp < rp) {
            // check left
            if (height[lp] <= height[rp]) {
                if (height[lp] >= maxLeft) {
                    maxLeft = height[lp];
                } else {
                    total += maxLeft - height[lp];
                }
                lp++;
            } else {
                if (height[rp] >= maxRight) {
                    maxRight = height[rp];
                } else {
                    total += maxRight - height[rp];
                }
                rp--;
            }
        }
        return total;
    }

    public static int trap(int[] height) {
        int lMax = 0;
        int sum = 0;
        int[] rMaxArr = getMaxRight(height);

        for (int i = 0; i < height.length; i++) {
            int cH = height[i];
            if (cH > lMax) {
                lMax = cH;
                continue;
            }
            int rmax = rMaxArr[i];
            if (rmax > cH)
                sum += Math.min(lMax, rmax) - cH;

        }
        return sum;
    }

    static int[] getMaxRight(int[] a) {
        int[] rMax = new int[a.length];
        for (int i = a.length - 2; i > -1; i--) {
            int prevMax = Math.max(rMax[i + 1], a[i + 1]);
            if (a[i] < prevMax) {
                rMax[i] = prevMax;
            }
        }
        return rMax;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 0, 3, 2, 5};
        System.out.println(trap(a));
        a = new int[]{4, 2, 3};
        System.out.println(trap(a));
        a = new int[]{5, 8, 1};
        System.out.println(trap(a));
    }
}
