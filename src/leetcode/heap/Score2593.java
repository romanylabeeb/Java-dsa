package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Score2593 {
    public static long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        int[][] customSort = new int[n][2];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            customSort[i][0] = nums[i];
            customSort[i][1] = i;
        }
        Arrays.sort(customSort, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; ++i) {
            int val = customSort[i][0];
            int ind = customSort[i][1];
            if (!visited[ind]) {
                visited[ind] = true;
                score += val;
                if (ind > 0) visited[ind - 1] = true;
                if (ind < n - 1) visited[ind + 1] = true;
            }
        }
        return score;
    }

    public static long findScore1(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        long score = 0;
        Comparator<int[]> cm = (x, y) -> {
            int valCom = Integer.compare(x[0], y[0]);
            if (valCom == 0) {
                return Integer.compare(x[1], y[1]);
            }
            return valCom;
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(cm);
        for (int i = 0; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
        }

        while (!pq.isEmpty()) {
            int[] el = pq.poll();
            int indx = el[1];
            int val = el[0];
            if (visited[indx]) continue;
            score += val;
            visited[indx] = true;
            if (indx > 0) visited[indx - 1] = true;
            if (indx < n - 1) visited[indx + 1] = true;
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3, 2};
        long sc = findScore(nums);
        System.out.println(sc);
    }
}