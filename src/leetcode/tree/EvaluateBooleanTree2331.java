package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;
//https://leetcode.com/problems/evaluate-boolean-binary-tree/
public class EvaluateBooleanTree2331 {

    public boolean evaluateTree(TreeNode root) {
        return dfs(root);
    }

    boolean dfs(TreeNode node) {

        if (isLeaf(node)) {
            return node.val == 1;
        }
        boolean left = dfs(node.left);
        boolean isOR = node.val == 2;
        if (!isOR && !left) //and case
            return false;
        return (isOR && left) ||  dfs(node.right);
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
