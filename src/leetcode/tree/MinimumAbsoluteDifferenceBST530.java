package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceBST530 {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        bfsHelper(root, values);
        Collections.sort(values);
        long minDiff = Long.MAX_VALUE;
        for (int i = 1; i < values.size(); i++) {
            long diff = Math.abs(values.get(i) - values.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }
        return (int) minDiff;
    }

    void bfsHelper(TreeNode root, List<Integer> values) {
        if (root == null) return;
        values.add(root.val);
        // left
        bfsHelper(root.left, values);
        // right
        bfsHelper(root.right, values);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int lp = 0;
        int rp = s.length() - 1;
        while (lp < rp) {
            while (lp < rp && !Character.isLetterOrDigit(s.charAt(lp))) lp++;
            while (lp < rp && !Character.isLetterOrDigit(s.charAt(rp))) rp--;
            if (s.charAt(rp) != s.charAt(lp)) return false;
            rp--;
            lp++;
        }
        return true;
    }
}
