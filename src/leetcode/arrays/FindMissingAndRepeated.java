package leetcode.arrays;

public class FindMissingAndRepeated {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        boolean[] rep = new boolean[(n * n) + 1];
        int[] res = new int[2];
        for (int[] row : grid) {
            for (int v : row) {
                if (rep[v] == true) {
                    res[0] = v;
                }
                rep[v] = true;
            }
        }

        for (int i = 1; i <= rep.length; ++i) {
            if (rep[i] == false) {
                res[1] = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] inp = {{
                9, 1, 7}, {8, 9, 2}, {3, 4, 6
        }};
        int[]res=findMissingAndRepeatedValues(inp);
        System.out.printf("res");
    }
}
