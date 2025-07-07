package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

public class MergeSortdArrays {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int lp = 0, rp = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = Math.max(n1, n2);
        List<int[]> result = new ArrayList<>();
        while (lp < n1 && rp < n2) {
            int[] id1 = nums1[lp];
            int[] id2 = nums2[rp];
            if (id1[0] == id2[0]) {
                result.add(new int[]{id1[0], id1[1] + id2[1]});
                lp++;
                rp++;
            } else if (id1[0] < id2[0]) {
                result.add(id1);
                lp++;
            } else {
                result.add(id2);
                rp++;
            }
            // i++;
        }
        // lp remains
        while (lp < n1) {
            result.add(nums1[lp++]);
        }
        while (rp < n2) {
            result.add(nums2[rp++]);
        }
        return result.toArray(new int[0][]);
    }

    public static boolean checkPowersOfThree(int n) {
        return check(n, 16);
    }

    static boolean check(int n, int maxPower) {
        if (n == 0) return true;
        int power = 1;
        int countp = 0;
        while (n >= power*3) {
                power *= 3;
                countp++;
        }
        if (countp >= maxPower) {
            return false;
        }
        return check(n - power, countp);

    }

    public static void main(String[] args) {
//        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
//        int[][] nums2 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] re = mergeArrays(nums1, nums2);
        boolean v = checkPowersOfThree(12);
        System.out.println(v);
    }
}
