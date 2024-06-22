package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class kthSmallestBST {
    public int kthSmallest2(TreeNode root, int k) {
        //using inorder traverse
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        int count = 0;
        while (current != null || !stack.isEmpty()) {
            // push left childs
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // pop last child
            current = stack.pop();
            count += 1;
            if (count == k) {
                return current.val;
            }
            // current.right
            current = current.right;
        }
        return -1;
    }

    /**
     * using recursive
     *
     * @param root
     * @param k
     * @return
     */
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        return inorderTraverse(root,k);
    }


    public int inorderTraverse(TreeNode n, int k) {
        if (n == null || count > k) return -1;
        int leftRes = inorderTraverse(n.left, k);
        if (leftRes != -1) {
            return leftRes;
        }
        count += 1;
        if (count == k) {
            return n.val;
        }
        return inorderTraverse(n.right, k);
    }
}
