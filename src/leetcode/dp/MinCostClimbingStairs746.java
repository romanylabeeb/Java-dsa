package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs746 {
    public static int minCostClimbingStairs(int[] cost) {
        int[] lookup = new int[cost.length];
        return Math.min(getMin(cost, 0, lookup), getMin(cost, 1, lookup));
    }

    private static int getMin(int[] cost, int i, int[] lookup) {
        if (i >= cost.length) return 0;
        if (lookup[i] > 0) return lookup[i];
        int cCost = cost[i] + Math.min(getMin(cost, i + 1, lookup), getMin(cost, i + 2, lookup));
        lookup[i] = cCost;
        return cCost;
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
