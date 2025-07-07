package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/?envType=problem-list-v2&envId=mq9zsunr
 */
public class DiameterBinaryTree543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(!queue.isEmpty()){
                level++;
            }
        }
        return level;
    }
}
