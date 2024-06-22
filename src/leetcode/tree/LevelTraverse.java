package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class LevelTraverse {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelValues = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(levelValues);
        }
        return result;
    }

    public List<List<Integer>> levelOrderUsingList(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        levelTraverseUseList(root, 0, result);
        return result;
    }

    public void levelTraverseUseList(TreeNode root, int level, List<List<Integer>> result) {
        //
        if (root == null) return;
        // check if result hasn't current level on it
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        // Add the current node's value to the list for the current level
        result.get(level).add(root.val);

        // Recursively traverse the left and right subtrees, increasing the level by 1
        levelTraverseUseList(root.left, level + 1, result);
        levelTraverseUseList(root.right, level + 1, result);
    }
}
