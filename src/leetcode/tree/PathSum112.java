package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;
//https://leetcode.com/problems/path-sum/
public class PathSum112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (isLeaf(root)) {
            return root.val == targetSum;
        }
        int remain = targetSum - root.val;
        return hasPathSum(root.left, remain) || hasPathSum(root.right, remain);
    }


    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
