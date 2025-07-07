package leetcode.arrays;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 */
public class ReplaceGreatestElementRight1299 {

    public int[] replaceElements(int[] arr) {
        int rp = arr.length - 1;
        int rG = -1;
        for (int i = rp; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = rG;
            rG = Math.max(rG, tmp);
        }
        return arr;
    }
}
