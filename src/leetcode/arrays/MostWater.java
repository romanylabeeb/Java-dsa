package leetcode.arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * <p>
 * use sliding windows
 */
public class MostWater {
    public int maxArea(int[] h) {
        int max = 0;
        int l = 0;
        int r = h.length - 1;
        while (l < r) {
            int minH = Math.min(h[l], h[r]);
            int area = (r - l) * minH;
            max = Math.max(max, area);
            if (h[l] == minH) {
               ++l;
            } else {
                --r;
            }
            // skip left area less than current area
            while (l < r && h[l] <= minH) l++;
            while (l < r && h[r] <= minH) r--;
        }
        return max;
    }

    public static void main(String[] args) {
        int[]a={4,7,7,6,5,4,3,3,6,7,8,5};
        MostWater m=new MostWater();
     int max=   m.maxArea(a);
    }
}
