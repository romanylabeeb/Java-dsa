package dsa.mustafaSaad.bootcamp;

public class ClimbingStairs {
    /**
     * https://leetcode.com/problems/climbing-stairs/description/
     * You are climbing a staircase. It takes n steps to reach the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++) {
            int fi = f1 + f2;
            f1 = f2;
            f2 = fi;
        }
        return f2;
    }
}
