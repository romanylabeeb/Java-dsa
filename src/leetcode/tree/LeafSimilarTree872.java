package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/leaf-similar-trees/description/
public class LeafSimilarTree872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(root1, res);
        List<Integer> res2 = new ArrayList<>();
        dfs(root2, res2);
        if (res2.size() != res.size()) return false;

        return res.equals(res2);
    }

    void dfs(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
        }
        dfs(root.left, res);
        dfs(root.right, res);
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
