package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBST {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        TreeNode lTmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(lTmp);

        return root;
    }

    public TreeNode invertTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode parent = queue.poll();
                TreeNode tmp = parent.left;
                parent.left = parent.right;
                parent.right = tmp;
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
            }
        }
        return root;
    }
}
