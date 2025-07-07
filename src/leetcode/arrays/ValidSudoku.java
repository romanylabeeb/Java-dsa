package leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //validate rows
        for (int i = 0; i < 9; ++i) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                char c = board[i][j];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
        }
        //validate cols
        for (int j = 0; j < 9; ++j) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 9; ++i) {
                char c = board[i][j];
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
        }


        //validate boxes
        //get starts pair
        int[][] starts = {{0, 0}, {0, 3}, {0, 6},
                {3, 0}, {3, 3}, {3, 6},
                {6, 0}, {6, 3}, {6, 6},
        };
        for (int[] pair : starts) {

            Set<Character> set = new HashSet<>();
            for (int i = pair[0]; i < pair[0] + 3; ++i) {
                for (int j = pair[1]; j < pair[0] + 3; ++j) {
                    char c = board[i][j];
                    if (c != '.' && !set.add(c)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    boolean valid(String s, Set<Character> set) {
        set.clear();
        int i = 0;
        while (i < s.length() && !set.contains(s.charAt(i))) {
            set.add(s.charAt(i++));
        }
        return i == s.length();
    }

    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int lp = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
                lp = i;
            }
            StringBuilder sb = new StringBuilder();

            for (int j = lp; j <= i; ++j) {
                sb.append(s.charAt(j));
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);

            }
        }
        int maxLen=0;
        for(String key:map.keySet()){
            if(map.get(key)>=3&&maxLen<key.length()){
                maxLen=key.length();
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {


        char[][] b = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'}
                , {'.', '4', '.', '3', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '3', '.', '.', '1'}
                , {'8', '.', '.', '.', '.', '.', '.', '2', '.'}
                , {'.', '.', '2', '.', '7', '.', '.', '.', '.'}
                , {'.', '1', '5', '.', '.', '.', '.', '.', '.'}
                , {'.', '.', '.', '.', '.', '2', '.', '.', '.'}
                , {'.', '2', '.', '9', '.', '.', '.', '.', '.'}
                , {'.', '.', '4', '.', '.', '.', '.', '.', '.'}};
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.maximumLength("aaaa"));
        boolean bcv = v.isValidSudoku(b);
        System.out.println(bcv);
    }
}
