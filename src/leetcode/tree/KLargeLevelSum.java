package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.*;

public class KLargeLevelSum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        // List<Long> list = new ArrayList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = q.poll();
                sum += cur.val;
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            pq.offer(sum);
        }
        if (pq.size() < k)
            return -1l;
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}
