package dsa.mustafaSaad.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeBST {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(" ");
        } else {
            sb.append(root.value).append(" ");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    public TreeNode deserialize(String s) {
        String[] a = s.split(" ");
        Queue<String> queue = new LinkedList<>(Arrays.asList(a));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        assert val != null;
        if (val.isEmpty() || val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    // Helper method to print the tree in inorder traversal
    public void printInOrder(TreeNode root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.value + " ");
            printInOrder(root.right);
        }
    }

    public static void main(String[] args) {

        BSTImpl bst = new BSTImpl();
        bst.insert(5);
        bst.insert(7);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(9);
        bst.insert(8);
        bst.insert(10);
        // Create a sample BST
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(7);
//        root.left.right = new TreeNode(8);
//        root.right.right = new TreeNode(20);

        SerializeBST serializer = new SerializeBST();
        serializer.printInOrder(bst.root);
        System.out.println();
        String ser = serializer.serialize(bst.root);
        System.out.println(ser);
        TreeNode t = serializer.deserialize(ser);
        serializer.printInOrder(t);


    }
}
