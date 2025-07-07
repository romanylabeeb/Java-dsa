package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;
//https://leetcode.com/problems/diameter-of-binary-tree/description/
public class MaxDiameter {
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    // height
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        res = Math.max(res, (leftHeight + rightHeight));
        return 1 + Math.max(leftHeight, rightHeight);
    }


}
