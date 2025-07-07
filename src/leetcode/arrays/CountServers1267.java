package leetcode.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CountServers1267 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!sb.isEmpty()) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static int countServers(int[][] g) {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        int n = g.length;
        int m = g[0].length;
        int[] acum = new int[m];
        for (int[] row : g) {
            int rowSum = 0;
            int countRepeat = 0;
            for (int j = 0; j < m; ++j) {
                if (row[j] == 1) {
                    rowSum++;
                    acum[j]++;
                    if (acum[j] > 1) {
                        countRepeat++;
                    }
                }

            }
            if (rowSum == 1) {
                res += countRepeat;
            }
            res += rowSum > 1 ? rowSum : 0;
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] g = {
                {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}

        };
        int res = countServers(g);
        System.out.println(res);
    }
}
