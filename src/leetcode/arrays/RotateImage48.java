package leetcode.arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 * https://github.com/gahogg/Leetcode-Solutions/blob/main/Rotate%20Image%20-%20Leetcode%2048/Rotate%20Image%20-%20Leetcode%2048.java
 */
public class RotateImage48 {
    public static void rotate(int[][] matrix) {
// revers rows with columns m[i][j]=m[j][i];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        // swap columns colj] =cols[col-j]
        int cols = matrix[0].length - 1;
        for (int j = 0; j < matrix[0].length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int temp = matrix[i][cols - j];
                matrix[i][cols - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        int mat[][]={{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);
    }
}
