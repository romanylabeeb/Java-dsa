package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        List<int[]> res = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] endInterval = intervals[i];
            if (currentInterval[1] >= endInterval[0]) {
                currentInterval[1] = Math.max(currentInterval[1], endInterval[1]);
            } else {// no overlapping add prev interval in res list and move it
                res.add(currentInterval);
                currentInterval = endInterval;
            }
        }
        res.add(currentInterval);
        return res.toArray(new int[res.size()][2]);
    }

    private static int mergeOverlapping(List<int[]> res, int lp, int[] currentInterval) {
        int[] prevInterval = res.get(lp);
        int x0 = currentInterval[0];
        int x1 = currentInterval[1];
        if (prevInterval[1] >= currentInterval[0]) {
            x0 = Math.min(x0, prevInterval[0]);
            x1 = Math.max(x1, prevInterval[1]);
            res.set(lp, new int[]{x0, x1});

        } else {
            ++lp;
            res.add(lp, new int[]{x0, x1});
        }
        return lp;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}};
        System.out.println(merge(intervals));
    }
}
