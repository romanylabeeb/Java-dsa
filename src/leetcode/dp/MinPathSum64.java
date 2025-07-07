package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinPathSum64 {
    //https://leetcode.com/problems/minimum-path-sum/
    public static int minPathSum(int[][] grid) {

        Map<String, Integer> lookup = new HashMap<>();
        return minPathUsingTopDownMemoization(grid, 0, 0, lookup);
    }

    static int minPathUsingTopDownMemoization(int[][] g, int i, int j, Map<String, Integer> lookup) {
        if (i >= g.length || j >= g[0].length) return 0;
        String key = i + "," + j;
        if (lookup.containsKey(key)) return lookup.get(key);
        int res = g[i][j];

        // last row go right change column
        if (i == g.length - 1 && j < g[0].length) {
            res += minPathUsingTopDownMemoization(g, i, j + 1, lookup);
        }
        // last column change the row number
        else if (j == g[0].length - 1 && i < g.length) {
            res += minPathUsingTopDownMemoization(g, i + 1, j, lookup);
        } else {
            res += Math.min(minPathUsingTopDownMemoization(g, i, j + 1, lookup), minPathUsingTopDownMemoization(g, i + 1, j, lookup));
        }
        lookup.put(key, res);
        return res;
    }

    static int minCostUseTabulation(int[][] g) {
        int m = g[0].length;
        int n = g.length;
        int[] dp = new int[m];
        // fill first row
        dp[0] = g[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = g[0][j] + dp[j - 1];
        }
        for (int i = 1; i < n; ++i) {
            dp[0] = g[i][0] + dp[0]; //update first column
            for (int j = 1; j < m; ++j) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + g[i][j];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[][] g = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] g2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minCostUseTabulation(g2));
    }
}
