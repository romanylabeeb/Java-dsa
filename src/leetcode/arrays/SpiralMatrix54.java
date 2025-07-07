package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/spiral-matrix/submissions/1340852140/
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        List<Integer> res = new ArrayList<>();
        int upWall = 0;
        int rightWall = m;
        int downWall = n;
        int leftWall = -1;
        int direction = 1;
        int i = 0, j = 0;
        while (res.size() != n * m) {
            // move right;
            if (direction == 1) {
                while (j < rightWall) {
                    res.add(mat[i][j++]);
                }
                i++;
                j--;
                rightWall--;
                direction = 2;
            } else if (direction == 2) {
                // move down
                while (i < downWall) {
                    res.add(mat[i++][j]);
                }
                i--;
                j--;
                downWall--;
                direction = 3;
            } else if (direction == 3) {
                //move left
                while (j > leftWall) {
                    res.add(mat[i][j--]);
                }
                i--;
                j++;
                leftWall++;
                direction = 4;
            } else if (direction == 4) {
                //move up
                while (i > upWall) {
                    res.add(mat[i--][j]);
                }
                i++;
                j++;
                upWall++;
                direction = 1;
            }
        }
        return res;
    }
}

