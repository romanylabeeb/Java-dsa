package leetcode.tree;

import dsa.mustafaSaad.utils.TreeNode;

//https://leetcode.com/problems/balanced-binary-tree/
public class BalancedTree110 {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        int[][] adj1 = buildAdj(edges1);
        int[][] adj2 = buildAdj(edges2);
        int d1 = getDiameter(adj1);
        int d2 = getDiameter(adj2);

        return (int) Math.max(Math.max(d1, d2), (1 + Math.ceil(d1 / 2.0) + Math.ceil(d2 / 2.0)));
    }

    int getDiameter(int[][] adj) {
        return 8;
    }

    int[][] buildAdj(int[][] edges) {
        int[][] adj = new int[edges.length + 1][edges.length + 1];
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            adj[i][j] = 1;
            adj[j][i] = 1;
        }
        return adj;
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1 ? true : false;
    }

    //height
    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (left == -1) return -1;
        int right = dfs(root.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);

    }

}
