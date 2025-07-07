package leetcode.dp;

public class EditDistance {
    public static int getMinDist(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        int rows = s1.length();
        int cols = s2.length();
        int[][] dp = new int[rows+1][cols+1];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dp[i][j]=-1;
            }
        }

        return getMinMemoization(s1, s2, 0, 0, dp);
    }

    private static int getMinMemoization(String s1, String s2, int i, int j, int[][] dp) {
        int rows = s1.length();
        int cols = s2.length();
        // If one string is exhausted, return the length of the remaining substring of the other string
        if (i >= rows) {
            return cols - j;
        }
        if (j >= cols) {
            return rows - i;
        }

        // If already computed, return the stored value
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // If characters match, no operation needed, move to the next characters
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = getMinMemoization(s1, s2, i + 1, j + 1, dp);
        } else {
            dp[i][j] = 1 + Math.min(
                    getMinMemoization(s1, s2, i + 1, j, dp),  // Deletion
                    Math.min(
                            getMinMemoization(s1, s2, i, j + 1, dp),  // Insertion
                            getMinMemoization(s1, s2, i + 1, j + 1, dp)  // Substitution
                    )
            );
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        String s1 = "park";
        String s2 = "spake";
        System.out.println(getMinDist(s1, s2)); // Expected output: 3
   }
}
/**
 * if (i >= rows) {
 *             return (cols - j );
 *         }
 *         if (j >= cols) {
 *             return (rows - i );
 *         }
 *         if(dp[i][j]>0) {
 *             return dp[i][j];
 *         }
 *         if (s1.charAt(i) == s2.charAt(j)) {
 *             dp[i][j] = getMinMemoization(s1, s2, i + 1, j + 1, dp);
 *             return dp[i][j];
 *         }
 *         dp[i][j] = 1 + Math.min(
 *                 getMinMemoization(s1, s2, i + 1, j, dp), //delete
 *                 Math.min(getMinMemoization(s1,s2,i+1,j+1,dp),  //replace
 *                 getMinMemoization(s1, s2, i + 1, j + 1, dp)));// insert;
 *         return dp[i][j];
 */