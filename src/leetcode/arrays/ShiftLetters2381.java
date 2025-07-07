package leetcode.arrays;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShiftLetters2381 {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int[] shift : shifts) {
            int st = shift[0];
            int end = shift[1] + 1;
            int dir = shift[2] == 1 ? 1 : -1;
            prefix[st] = (prefix[st] + dir) % 26;
            prefix[end] = (prefix[end] - dir) % 26;
        }
        int sum=0;
        for (int i = 0; i < n; ++i) {
            sum=(sum+prefix[i])%26;
            sb.append(getShifftedChar(s.charAt(i),sum));
        }
        return sb.toString();
    }

    static char getShifftedChar(char c, int op) {
        int vl = (c - 'a' + op)%26;
        if (vl < 0) vl = 26 + vl;
        return (char) (vl + 'a');
    }

    public static void main(String[] args) {
        //[[0,1,0],[1,2,1],[0,2,1]]
        int[][] shifts = new int[][]{{4,8,0}
                ,{4,4,0}
                ,{2,4,0}
                ,{2,4,0}
                ,{6,7,1}
                ,{2,2,1}
                ,{0,2,1}
                ,{8,8,0}
                ,{1,3,1}};
        String s = "xuwdbdqik";
        System.out.println(shiftingLetters(s, shifts));
    }
}
