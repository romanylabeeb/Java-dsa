package leetcode.tree;

import com.sun.source.tree.Tree;
import dsa.mustafaSaad.utils.TreeNode;

public class RecoverTree {
    int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        //1-2--3--4-5--6--7
        //l0      1
        //l1    2
        //l2  3   4
        //l3 null  null
        return recover(traversal, 0);
    }

    TreeNode recover(String tra, int level) {
        if (tra.length() <= index + level) return null;
        if (!isLevelHasChild(tra, level)) return null;
        index += level;
        int val = getValue(tra);
        TreeNode root = new TreeNode(val);
        root.left = recover(tra, level + 1);
        root.right = recover(tra, level + 1);
        return root;
    }

    int getValue(String s) {
        int lp = index;
        while (lp < s.length() && Character.isDigit(s.charAt(lp))) {
            lp++;
        }
        int val = Integer.valueOf(s.substring(index, lp));
        index = lp;
        return val;
    }

    boolean isLevelHasChild(String s, int level) {
        int count = 0;
        int lp = index;
        while (lp < s.length() && (s.charAt(lp) == '-')) {
            lp++;
            count++;
        }
        return count == level;
    }

    public static void main(String[] args) {
        RecoverTree obj = new RecoverTree();
        String s = "1-2--3--4-5--6--7";
        TreeNode n = obj.recoverFromPreorder(s);
    }
}
