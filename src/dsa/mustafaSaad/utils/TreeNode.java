package dsa.mustafaSaad.utils;

public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    public boolean hasOneChild(){
        return this.left!=null&& this.right==null ||(this.right!=null&&this.left==null);
    }
}
