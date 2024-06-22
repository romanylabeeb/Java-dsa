package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

public class MaxDepthTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }
}
