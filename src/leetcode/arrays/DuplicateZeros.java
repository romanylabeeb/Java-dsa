package leetcode.arrays;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = -1, k = 0;
        while (k < n) {
            ++i;
            k += arr[i] > 0 ? 1 : 2;
        }
        int j = n - 1;
        if (k == n + 1) {
            arr[j--] = 0;
            --i;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            if (arr[i] == 0) {
                arr[--j] = arr[i];
            }
            --i;
            --j;
        }
    }

    public static void main(String[] args) {
        int[] a = {8, 5, 0, 9, 0, 3, 4, 7};
        // 8 5 0 0 9 0 0 3
        duplicateZeros(a);
    }
}
