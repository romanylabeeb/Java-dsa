package leetcode.arrays;


import java.util.*;

public class ClosestPointsOrigin973 {
    class Pair {
        int x;
        int y;
        long sqrt;

        public Pair(int x, int y, long sqrt) {
            this.x = x;
            this.y = y;
            this.sqrt = sqrt;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.sqrt, a.sqrt));
        for (int[] p : points) {
            Pair pair = createPair(p);
            maxHeap.offer(pair);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[k][2];
        int count = 0;
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            res[count++] = new int[]{p.x, p.y};
        }
        return res;
    }

    Pair createPair(int[] p) {
        long sqrt = (long) (p[0] * p[0]) + (long) (p[1] * p[1]);
        return new Pair(p[0], p[1], sqrt);
    }

    public int[][] kClosest2(int[][] points, int k) {
        Arrays.sort(points, (p1, p2) -> {
            long dis1 = (long) (p1[0] * p1[0]) + (long) (p1[1] * p1[1]);
            long dis2 = (long) (p2[0] * p2[0]) + (long) (p2[1] * p2[1]);
            return (int) (dis1 - dis2);
        });
        return Arrays.copyOfRange(points, 0, k);
    }
}
