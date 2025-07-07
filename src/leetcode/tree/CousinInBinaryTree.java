package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

class CustomNode {
    public TreeNode node;
    public int decreasedVal;

    public CustomNode(TreeNode node, int totalDecrease) {
        this.node = node;
        this.decreasedVal = totalDecrease;
    }
}

public class CousinInBinaryTree {

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int prevSum = root.val;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            int sum = 0;

            for (int i = 0; i < levelSize; ++i) {
                TreeNode node = q.poll();
                node.val = prevSum - node.val;
                if (node.left != null) {
                    sum += node.left.val;
                    q.offer(node.left);
                }
                if (node.right != null) {
                    sum += node.right.val;
                    q.offer(node.right);
                }
                if (node.left != null && node.right != null) {
                    int x = node.left.val;
                    node.left.val += node.right.val;
                    node.right.val += x;
                }
            }
            prevSum = sum;
        }

        return root;
    }
}
