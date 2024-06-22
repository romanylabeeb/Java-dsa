package leetcode.tree;

import com.sun.source.tree.BreakTree;
import dsa.mustafaSaad.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/same-tree/description/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) return true;
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * https://leetcode.com/problems/subtree-of-another-tree/
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == subRoot)
            return true;
        if (root == null)
            return false;

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap= new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        preorderIndex=0;
        return buildTree(preorder, inorder, inorderIndexMap,0, preorder.length - 1);
    }
    private int preorderIndex;

    private TreeNode buildTree(int[] preorder, int[] inorder,Map<Integer, Integer> inorderIndexMap, int left, int right) {
        if (left>right) {
            return null;
        }
        int rootVal=preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIndexMap.get(rootVal);
        root.left = buildTree(preorder, inorder,inorderIndexMap, left, mid-1);
        root.right = buildTree(preorder, inorder,inorderIndexMap, mid + 1, right);
        return root;
    }

    private int findParentNode(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
