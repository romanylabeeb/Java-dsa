package dsa.mustafaSaad.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTImpl {
    TreeNode root;

    public boolean insert(int value) {
        TreeNode tmp = new TreeNode(value);
        if (root == null) {
            root = tmp;
            return true;
        }

        TreeNode p = root;
        TreeNode parent = root;
        while (p != null) {
            parent = p;
            p = value > p.value ? p.right : p.left;
        }
        if (value > parent.value) {
            parent.right = tmp;
        } else {
            parent.left = tmp;
        }
        return true;
    }

    /**
     * inorder  (Left >> Parent >> Right)
     * 1. Traverse the left subtree.
     * 2. Visit the parent node.
     * 3. Traverse the right subtree.
     * @param node
     */
    public void inOrderTraverseRecursive(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inOrderTraverseRecursive(node.left);

        // Visit the parent node
        System.out.print(node.value + " >> ");

        // Traverse the right subtree
        inOrderTraverseRecursive(node.right);
    }

    /**
     * Preorder    (Parent >> Left >> Right)
     * 1. Visit the parent node.
     * 2. Traverse the left subtree.
     * 3. Traverse the right subtree.
     * @param node
     */
    public void preOrderTraverseRecursive(TreeNode node) {
        if (node == null) return;
        // Visit the parent node
        System.out.print(node.value + " >> ");

        // Traverse the left subtree
        preOrderTraverseRecursive(node.left);

        // Traverse the right subtree
        preOrderTraverseRecursive(node.right);
    }

    /**
     * post order  (Left >> right >> Parent)
     * 1. Traverse the left subtree.
     * 2. Traverse the right subtree.
     * 3. Visit the parent node.
     * @param node
     */
    public void postOrderTraverseRecursive(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        postOrderTraverseRecursive(node.left);

        // Traverse the right subtree
        postOrderTraverseRecursive(node.right);

        // Visit the parent node
        System.out.print(node.value + " >> ");
    }

    public void inOrderTraverseUsingWhile(TreeNode r) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(r);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

        }
    }

    public static void main(String[] args) {
        BSTImpl bst = new BSTImpl();
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        bst.insert(2);
        bst.insert(5);
        bst.insert(6);
        bst.insert(9);
        System.out.println("Inorder traverse");
        bst.inOrderTraverseRecursive(bst.root);
        System.out.println("\nPre traverse");
        bst.preOrderTraverseRecursive(bst.root);
        System.out.println("\npostrder traverse");
        bst.postOrderTraverseRecursive(bst.root);

    }
}