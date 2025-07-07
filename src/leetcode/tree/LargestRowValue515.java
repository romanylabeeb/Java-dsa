package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/?envType=daily-question&envId=2024-12-25
public class LargestRowValue515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    void dfs(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        if (res.size() <= level) {
            res.add(node.val);
        } else if (res.get(level) < node.val) {
            res.set(level, node.val);
        }
        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }
}
