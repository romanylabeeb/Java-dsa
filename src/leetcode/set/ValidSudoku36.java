package leetcode.set;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> box1 = new HashSet<>();
        Set<Character> box2 = new HashSet<>();
        Set<Character> box3 = new HashSet<>();
        //validate rows
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            // reset boxes
            if (i == 3 || i == 6) {
                box1 = new HashSet<>();
                box2 = new HashSet<>();
                box3 = new HashSet<>();
            }
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (rowSet.contains(c)) return false;
                    rowSet.add(c);
                    if (j < 3) {
                        if (box1.contains(c)) return false;
                        box1.add(c);
                    } else if (j < 6) {
                        if (box2.contains(c)) return false;
                        box2.add(c);
                    } else {
                        if (box3.contains(c)) return false;
                        box3.add(c);
                    }
                }
            }
        }

        // validate columns
        for (int j = 0; j < 9; j++) {
            Set<Character> colSet = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                char c = board[i][j];
                if (c != '.') {
                    if (colSet.contains(c)) return false;
                    colSet.add(c);
                }
            }
        }
        return true;
    }
}