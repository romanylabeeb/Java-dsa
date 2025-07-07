package leetcode.arrays;

public class FirstCompeletePainted2661 {
//https://leetcode.com/problems/first-completely-painted-row-or-column/description/
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int n1 = arr.length;
        int n = mat.length;
        int m = mat[0].length;
        int[] flat = new int[n1 + 1];
        int[] rows = new int[n];
        int[] cols = new int[m];
        int ind = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                flat[mat[i][j]] = (ind++);
            }
        }
        int steps = 0;
        for (int v : arr) {
            int xy = flat[v];
            steps++;
            int row = xy / m;
            int col = xy % m;
            ++rows[row];
            ++cols[col];
            if (rows[row] == m || cols[col] == n) break;
        }
        return steps - 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8, 2, 4, 9, 3, 5, 7, 10, 1, 6};
        int[][] mat = {
                {8, 2, 9, 10, 4},
                {1, 7, 6, 3, 5}
        };
        int res = firstCompleteIndex(a, mat);
        System.out.println(res);
    }
}
