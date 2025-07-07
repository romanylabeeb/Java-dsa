package leetcode.arrays;

public class KSymbolGrammar779 {
    public static int kthGrammar(int n, int k) {
        // Base case: the first row is just 0
        if (n == 1 && k == 1) return 0;

        // Find the length of the previous row
        int lengthOfPrevRow = (int) Math.pow(2, n - 1);

        // Determine the parent position in the previous row
        int mid = lengthOfPrevRow / 2;

        if (k <= mid) {
            // If k is in the first half, it's the same as the k-th symbol in the previous row
            return kthGrammar(n - 1, k);
        }
        // If k is in the second half, it's the complement of the (k - mid)-th symbol in the previous row
        return kthGrammar(n - 1, k - mid) ^ 1;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(6,5));
    }
}
