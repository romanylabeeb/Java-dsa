package dsa.mustafaSaad.dp;

import java.util.HashMap;
import java.util.Map;

public class PathInMatrix {

    public static int getPath(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[] prevDp = new int[cols];
        int[] dp = new int[cols];
        prevDp[0] = m[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < rows; i++) {
            // first cell
            dp[0] = m[i][0] == 0 ? prevDp[0] : 0;
            for (int j = 1; j < cols; j++) {
                dp[j] = m[i][j] == 0 ? (prevDp[j] + dp[j - 1]) : 0;
            }
            prevDp = dp;
            dp = new int[cols];
        }
        return prevDp[cols - 1];
    }

    public static int getPathRecursive(int[][] m) {

        Map<String, Integer> lookup = new HashMap<>();
        return getPathMemoization(m, 0, 0, lookup);
    }

    private static int getPathMemoization(int[][] m, int row, int col, Map<String, Integer> lookup) {
        int rows = m.length - 1;
        int cols = m[0].length - 1;
        // validate limits
        if (row > rows || col > cols || m[row][col] == 1) return 0;
        //base case destination
        if (row == rows && col == cols) return 1;
        String key = row + "," + col;
        // go left on same row [row,col+1] or go bottom [row,col+1]
        int value = getPathMemoization(m, row, col + 1, lookup) + getPathMemoization(m, row + 1, col, lookup);
        lookup.put(key, value);
        return value;
    }

    public static void main(String[] args) {
        /**
         *  [0, 0, 1, 0, 1],
         *     [0, 0, 0, 0, 1],
         *     [0, 0, 1, 0, 0],
         *     [1, 0, 0, 0, 0]
         */
        int[][] m = new int[][]{
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}};
        System.out.println(getPath(m));
        System.out.println(getPathRecursive(m));
    }
}
