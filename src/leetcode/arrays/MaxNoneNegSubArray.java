package leetcode.arrays;

import java.util.Arrays;

public class MaxNoneNegSubArray {

    public static int[] maxset(int[] A) {
        long maxSum = 0;
        int maxStartIndex = 0;
        int maxEndIndex = 0;
        long sum = 0;
        int startIndex = -1;
        for (int i = 0; i < A.length; i++) {
            int v = A[i];
            if (v >= 0) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                sum += v;
            } else {

                if (maxSum <= sum) {
                    int n1 = maxSum == 0 ? 0 : maxEndIndex - maxStartIndex;
                    int n2 = i - startIndex;
                    if (n1 < n2) {
                        maxStartIndex = startIndex;
                        maxEndIndex = i - 1;
                        maxSum = sum;
                    }
                }
                startIndex = -1;
                sum = 0;
            }
        }
        int n1 = maxEndIndex - maxStartIndex;
        int n2 = A.length - 1 - startIndex;
        if (maxSum <= sum && (n1 <= n2)) {
            maxStartIndex = startIndex;
            maxEndIndex = A.length - 1;
        }
        if (maxStartIndex == -1) {  // No non-negative subarray found
            return new int[0];
        }
        int n = maxEndIndex - maxStartIndex;
        int[] res = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            res[i] = A[maxStartIndex++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {756898537, -1973594324, -2038664370, -184803526, 1424268980};
        int[]res=maxset(a);
        Arrays.stream(res).forEach(System.out::println);
    }
}
