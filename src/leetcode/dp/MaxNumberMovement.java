package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberMovement {

    public static int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[rows];
        int max = 0;
        for (int i = 0; i < rows; ++i) {
            dp[i] = 1;
        }
        boolean found = false;
        for (int j = 1; j < cols; j++) {

            for (int i = 0; i < rows; ++i) {
                int cur = -1;
                int val = grid[i][j];
                int nxtTopLeft = dp[i];
                //topleft
                if (i > 0 && val > grid[i - 1][j - 1]) {
                    cur = Math.max(cur, dp[i - 1] + 1);
                }
                // current
                if (val > grid[i][j - 1]) {
                    cur = Math.max(cur, dp[i] + 1);
                }
                // down
                if (i + 1 < rows && val > grid[i + 1][j-1]) {
                    cur = Math.max(cur, dp[i + 1]);
                }
                dp[i] = cur;
                found = found || cur > 0;
            }
            if (!found) break;
            max = j;
        }

        return max;
    }

    public static int maxMoves2(int[][] grid) {
        Map<String, Integer> lookup = new HashMap<>();
        int max = 0;
        int rows = grid.length;
        for (int i = 0; i < rows; ++i) {
            max = Math.max(max, calcMaxForNode(grid, i, 0, lookup));
        }
        return max;
    }

    private static int calcMaxForNode(int[][] grid, int row, int col, Map<String, Integer> lookup) {
        int cols = grid[0].length;
        int rows = grid.length;
        if (row >= rows || col >= cols || col + 1 == cols) return 0;
        String key = row + "," + col;
        if (lookup.containsKey(key)) {
            return lookup.get(key);
        }
        int val = grid[row][col];
        int topMax = 0;
        int curMax = 0;
        int downMax = 0;
        // top right
        if (row > 0 && col + 1 < cols && val < grid[row - 1][col + 1]) {
            topMax = 1 + calcMaxForNode(grid, row - 1, col + 1, lookup);
        }
        // current right
        if (col + 1 < cols && val < grid[row][col + 1]) {
            curMax = 1 + calcMaxForNode(grid, row, col + 1, lookup);
        }
        // down right
        if (row + 1 < rows && col + 1 < cols && val < grid[row + 1][col + 1]) {
            downMax = 1 + calcMaxForNode(grid, row + 1, col + 1, lookup);
        }
        int max = Math.max(topMax, Math.max(curMax, downMax));
        lookup.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}
        };
        System.out.println(maxMoves(a));
    }
}
