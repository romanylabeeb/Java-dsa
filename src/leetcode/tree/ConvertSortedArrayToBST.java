package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;
//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildBST(nums, 0, nums.length - 1);
    }

    TreeNode buildBST(int nums[], int l, int r) {
        if (l > r) return null;
        int mid = l+(r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, l, mid - 1);
        root.right = buildBST(nums, mid + 1, r);
        return root;
    }
}
