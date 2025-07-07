package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;
//https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumBST {
    int l;
    int h;

    public int rangeSumBST(TreeNode root, int low, int high) {
        l = low;
        h = high;
        return dfs(root);
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum = isInRange(node.val) ? node.val : 0;
        if (node.val >= l) sum += dfs(node.left);
        if (node.val <= h) sum += dfs(node.right);
        return sum;
    }

    boolean isInRange(int val) {
        return val >= l && val <= h;
    }
}
