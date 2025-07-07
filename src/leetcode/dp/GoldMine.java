package leetcode.dp;

public class GoldMine {
    public static int getMaxMine(int[][] mat) {
        int rows = mat.length - 1;
        int cols = mat[0].length - 1;
        int[][] lookup = new int[rows + 1][cols + 1];
        int res = 0;
        for (int j = 0; j <= cols; j++) {
            int current = getMaxMineMemoization(mat, 0, j, lookup);
            res = Math.max(res, current);
        }
        return res;
    }

    private static int getMaxMineMemoization(int[][] mat, int i, int j, int[][] lookup) {
        int rows = mat.length - 1;
        int cols = mat[0].length - 1;
        // limit validation
        if (i < 0 || j > cols || j < 0) return 0;
        //base case last row exist
        if (i == rows) {
            lookup[i][j] = mat[i][j];
            return lookup[i][j];
        }
        lookup[i][j] = mat[i][j] +
                Math.max(Math.max(getMaxMineMemoization(mat, i + 1, j, lookup),
                        getMaxMineMemoization(mat, i + 1, j - 1, lookup)), getMaxMineMemoization(mat, i + 1, j + 1, lookup));
        return lookup[i][j];
    }

    public static int getMaxMineTabulation(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] dp = new int[cols];
        // init dp first row
        for (int j = 0; j < cols; j++) {
            dp[j] = mat[0][j];
        }
        int[] nxtDp = new int[cols];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxPrev = dp[j];
                if (j < cols - 1) {
                    maxPrev = Math.max(maxPrev, dp[j + 1]);
                }
                if (j > 0) {
                    maxPrev = Math.max(maxPrev, dp[j - 1]);
                }
                nxtDp[j] = mat[i][j] + maxPrev;
            }
            dp = nxtDp;
            nxtDp = new int[cols];
        }
        int maxVal = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]
                {
                        {3, 2, 12, 15, 10},
                        {6, 19, 7, 11, 17},
                        {8, 5, 12, 32, 21},
                        {3, 20, 2, 9, 7}
                };
        int max = getMaxMine(a);
        System.out.println(max);
        System.out.println(getMaxMineTabulation(a));
    }
}
