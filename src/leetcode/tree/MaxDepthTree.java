package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
public class MaxDepthTree {
    // use dfs
    public int maxDepthDFS(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));

    }

    // use bfs

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return depth;

    }
}
