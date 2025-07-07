package dsa.mustafaSaad.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BSTImpl {
    TreeNode root;

    // This method mainly calls insertRec()

    /**
     * Inserts a value into the BST using recursion. If the value already exists, it will not be inserted.
     *
     * @param key the value to be inserted
     */
    void insert(int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        insertRec(root, key);
    }

    /**
     * Helper method to recursively insert a value into the BST.
     *
     * @param node the current node in the BST
     * @param key  the value to be inserted
     * @return true if the value was inserted, false if the value already exists
     */
    public boolean insertRec(TreeNode node, int key) {
        if (node.value == key) return false;
        if (key > node.value) {
            if (node.right == null) {
                node.right = new TreeNode(key);
                return true;
            }
            return insertRec(node.right, key);
        } else if (node.left == null) {
            node.left = new TreeNode(key);
            return true;
        }
        return insertRec(node.left, key);
    }

    /**
     * Inserts a value into the BST using iteration. If the value already exists, it will not be inserted.
     * O(Log n)
     *
     * @param key the value to be inserted
     * @return true if the value was inserted, false if the value already exists
     */
    public boolean insert1(int key) {
        TreeNode tmp = new TreeNode(key);
        if (root == null) {
            root = tmp;
            return true;
        }

        TreeNode current = root;
        TreeNode parent = root;
        while (current != null) {
            parent = current;
            if (key == current.value) return false;
            current = key > current.value ? current.right : current.left;
        }
        if (key > parent.value) {
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
     *
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
     *
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
     *
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
    public void postOrderTraverseUsingWhile(TreeNode node){
        Deque<TreeNode> stack = new ArrayDeque<>();


    }

    /**
     *
     */
    public void inOrderTraverseUsingWhile() {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        // traverse tree
        while (current != null || !stack.isEmpty()) {
            // reach leftmost node of current node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // pop leftmost node from stack
            current = stack.pop();
            System.out.print(current.value + " >> ");

            // we have visited the node and its left subtree
            // need to visit right subtree
            current = current.right;
        }
    }

    /**
     * Enter a while loop that continues as long as the stack is not empty.
     * Inside the loop, pop a node from the stack and print its value.
     * If the popped node has a right child, push the right child onto the stack.
     * If the popped node has a left child, push the left child onto the stack.
     */
    public void preOrderTraverseUsingWhile() {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode current;
        // traverse tree
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.value + " >> ");
            // Push right child first so that left child is processed first
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        System.out.println();
    }

    public TreeNode findMinValue(TreeNode current) {
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }


    public TreeNode findMaxValue(TreeNode current) {
        while (current != null && current.right != null) {
            current = current.right;
        }
        return current;
    }

    public TreeNode search(int key) {
        TreeNode current = root;

        while (current != null && current.value != key) {
            if (key > current.value) {
                current = current.right;
            } else current = current.left;
        }
        return current;
    }

    /**
     * 1. If the node has a right subtree
     * get  the successor is the minimum value node in that right subtree.
     * 2. If the node doesn't have a right subtree,
     * the successor is determined by traversing the tree from the root until the node is found,
     * updating the successor variable along the way
     * @param key
     * @return
     */
    public TreeNode getSuccessor(int key) {
        TreeNode node = search(key);
        if (node == null) return null;

        if (node.right != null) {
            // get min of right subtree
            TreeNode rt = node.right;
            while (rt.left != null) {
                rt = rt.left;
            }
            return rt;
        }
        TreeNode current = root;
        TreeNode successor = null;
        while (current != null) {
            if (current.value > key) {
                successor = current;
                current = current.left;
            } else if (current.value < key) {
                current = current.right;

            } else {
                break;
            }
        }
        return successor;
    }

    /**
     * predecessor of a node is
     * the node with the largest value that is smaller than the given node's value.
     *
     * @param key
     * @return
     */
    public TreeNode getPredecessor(int key) {
        TreeNode node = search(key);
        if (node == null) return null;
        // if n.left !=null get max of l subtree
        if (node.left != null) {
            TreeNode lt = node.left;
            while (lt.right != null) {
                lt = lt.right;
            }
            return lt;
        }
        TreeNode current = root;
        TreeNode pre = null;
        while (current != null) {
            if (current.value < key) {
                pre = current;
                current = current.right;
            } else if (current.value > key) {
                current = current.left;
            } else {
                break;
            }
        }
        return pre;
    }

    public TreeNode getParent(int key) {
        TreeNode c = root;
        TreeNode parent=null;
        while (c != null && c.value != key) {
            parent=c;
            if (c.value > key) {
                c = c.left;
            } else {
                c = c.right;
            }
        }
        return parent;
    }

    public boolean delete(int key) {
        TreeNode node = search(key);
        if(node==null) return false;
        TreeNode parent = getParent(key);

        // case 1 if is leaf or has one child
        if (node.isLeaf() || node.hasOneChild()) {
            TreeNode child = null;
            if (node.hasOneChild()) {
                child = node.left != null ? node.left : node.right;
            }
            if (parent == null) {
                root = child;
            } else if (parent.left != null && parent.left.value == key) {
                parent.left = child;
            } else if (parent.right != null && parent.right.value == key) {
                parent.right = child;
            }
        } else {
            TreeNode successor = this.findMinValue(node.right);
            delete(successor.value);
            node.value = successor.value;
        }
        return true;
    }

    // Given a binary search tree and a key, this function deletes the key and returns the new root
    TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.value > key) {
            return deleteNode(root.left, key);
        }
        if (root.value < key) {
            return deleteNode(root.right, key);
        }
        // If key is same as root's key, then this is the node to be deleted
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        // Node with two children: Get the inorder successor (smallest in the right subtree)
        TreeNode successor = findMinValue(root.right);
        root.value = successor.value;
        // delete inorder successor
        root.right = deleteNode(root.right, root.value);
        return root;
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

        System.out.println("Inorder traverse");
        bst.inOrderTraverseRecursive(bst.root);
        System.out.println("\nInorder traverse");
        bst.inOrderTraverseUsingWhile();

        System.out.println("\nPre traverse");
        bst.preOrderTraverseRecursive(bst.root);
        System.out.println("\nPre traverse using while");
        bst.preOrderTraverseUsingWhile();

        System.out.println("\npostOrder traverse");
        bst.postOrderTraverseRecursive(bst.root);

        System.out.println("\nMin value:" + bst.findMinValue(bst.root).value);
        System.out.println("successor:");
        System.out.println(bst.getSuccessor(8).value);
        System.out.println("predecessor:");
        System.out.println(bst.getPredecessor(8).value);
        System.out.println("delete 5");
        bst.delete(5);
        bst.inOrderTraverseUsingWhile();
    }

    public int solve(int[] A) {
        Arrays.sort(A);
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1]&&(Math.abs(A[i])==(A.length-1-i))){
                return 1;
            }
        }
        return -1;
    }
}