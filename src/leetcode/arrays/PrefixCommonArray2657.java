package leetcode.arrays;

public class PrefixCommonArray2657 {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = B.length;
        int[] common = new int[n + 1];
        int[] res = new int[n];
        int prev = 0;
        for (int i = 0; i < n; ++i) {

            if (A[i] == B[i]) {
                ++prev;
            }
            prev += common[B[i]] + common[A[i]];
            common[A[i]] = 1;
            common[B[i]] = 1;
            res[i] = prev;

        }
        return res;
    }



    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4};
        int[] b = {3, 1, 2, 4};
        System.out.println(findThePrefixCommonArray(a, b));
    }
}
