package leetcode.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxPath {
    //https://leetcode.com/problems/unique-paths-ii/

    // using tabulation
    static int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check if the start or end cells are blocked
        if (grid[0][0] != 0 || grid[rows - 1][cols - 1] != 0) {
            return 0;
        }

        // Dynamic programming array to store number of ways to reach each cell
        int[] dp = new int[cols];

        // Initialize the first cell, as it's the starting point
        dp[0] = 1;

        // Fill the first row of the dp array
        for (int col = 1; col < cols; col++) {
            if (grid[0][col] == 1 || dp[col - 1] == 0) {
                dp[col] = 0; // Blocked or unreachable cells get a value of 0
            } else {
                dp[col] = 1;
            }
        }

        // Process the rest of the grid
        for (int row = 1; row < rows; row++) {
            // If the first column in the current row is blocked, set dp[0] to 0
            if (grid[row][0] == 1) {
                dp[0] = 0;
            }

            // Update the dp array for the current row
            for (int col = 1; col < cols; col++) {
                if (grid[row][col] == 1) {
                    dp[col] = 0; // Blocked cells are set to 0
                } else {
                    dp[col] += dp[col - 1]; // Sum paths from left and top cells
                }
            }
        }

        // Return the number of ways to reach the bottom-right corner
        return dp[cols - 1];
    }

    static int uniquePathsWithObstaclesRecursive(int[][] grid, int i, int j, Map<String, Integer> lookup) {
        if (grid.length < i || grid[0].length < j) return 0;
        String key = i + "," + j;
        if (lookup.containsKey(key)) return lookup.get(key);
        /// recunslation

        int res = 0;
        if (grid[i][j] == 1) {
            res = 0;
        } else if (i == grid.length - 1 && j == grid[0].length - 1)
            res = 1;
        else if (i == grid.length - 1) {
            res = uniquePathsWithObstaclesRecursive(grid, i, j + 1, lookup);
        } else if (j == grid[0].length - 1) {
            res = uniquePathsWithObstaclesRecursive(grid, i + 1, j, lookup);
        } else {
            res = uniquePathsWithObstaclesRecursive(grid, i, j + 1, lookup) + uniquePathsWithObstaclesRecursive(grid, i + 1, j, lookup);
        }
        lookup.put(key,res);
        return res;
    }

    public static void main(String[] args) {
        Set<Character> vowels=Set.of('e','o','i');

        int[][] g = {
                {0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0}
        };
        Map<String ,Integer>lookup=new HashMap<>();
       int y= uniquePathsWithObstaclesRecursive(g,0,0,lookup);
        System.out.println(y);
//        System.out.println(uniquePathsWithObstacles(g));
    }
}
