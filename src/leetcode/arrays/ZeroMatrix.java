package leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ZeroMatrix {
    public static void setZeroes(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        boolean[] changeRows = new boolean[rows];
        boolean[] changeCols = new boolean[cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (m[i][j] == 0) {
                    changeRows[i] = true;
                    changeCols[j] = true;
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (changeRows[i] || changeCols[j]) {
                    m[i][j] = 0;
                }
            }
        }
    }

    private static void change(int[][] m, int row, int col, boolean[][] isChanged) {
        for (int j = 0; j < m[0].length; ++j) {
            if (m[row][j] != 0) {
                isChanged[row][j] = true;
                m[row][j] = 0;
            }
        }

        for (int i = 0; i < m.length; ++i) {
            if (m[i][col] != 0) {
                isChanged[i][col] = true;
                m[i][col] = 0;
            }
        }
    }

    static void zero(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        Set<Integer> zeroCol = new HashSet<>();
        Set<Integer> zeroRow = new HashSet<>();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (m[i][j] == 0) {
                    zeroCol.add(j);
                    zeroRow.add(i);
                }
            }
        }

        for (int r : zeroRow) {
            for (int j = 0; j < cols; ++j) {
                m[r][j] = 0;
            }
        }

        for (int col : zeroCol) {
            for (int i = 0; i < rows; ++i) {
                m[i][col] = 0;
            }
        }

    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 0},
                {0, 4, 2},
                {4, 3, 2}
        };
        setZeroes(m);
        System.out.println(m);
    }
}
