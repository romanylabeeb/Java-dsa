package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.*;

public class MinOperationToSortTree {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] levelData = new int[size];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                levelData[i] = node.val;
                map.put(node.val, i);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            count += countSwapNo(levelData, map);
        }

        return count;
    }

    private int countSwapNo(int[] levelData, Map<Integer, Integer> map) {
        int[] sorted = Arrays.copyOf(levelData, levelData.length);
        Arrays.sort(sorted);
        int count = 0;
        for (int i = 0; i < levelData.length; ++i) {
            if (levelData[i] != sorted[i]) {
                count++;

                int j = map.get(sorted[i]);
                map.put(levelData[i], j);

                levelData[j]=levelData[i];
            }
        }
        return count;
    }


}
