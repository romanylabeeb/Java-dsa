package leetcode.bitOperations;

//https://leetcode.com/problems/minimize-xor/submissions/1509706059/
public class MinXOR {
    static int countBit(int num) {
        int res = 0;
        while (num > 0) {
            res += num & 1;
            num = num >> 1;
        }
        return res;
    }

    public static int minimizeXor(int num1, int num2) {
        int k1 = countBit(num1);
        int k2 = countBit(num2);
        int c1=Integer.bitCount(num1);
        int c2=Integer.bitCount(num2);

        if (k1 == k2) return num1;
        int x = num1;
        int i = 0;
        // remove least significant
        while (k1 > k2) {
            // check current bit is one
            int currentBit = x & (1 << i);
            if (currentBit >0) {
                k1 = k1 - 1;
                // xor this bit
                x = x ^ (1 << i);
            }
            i++;
        }

        // add least significant
        while (k2 > k1) {
            int currentBit = x & (1 << i);

            // check current bit is zero
            if (currentBit == 0) {
                k2 = k2 - 1;
                // xor this bit
                x = x | (1 << i);
            }
            i++;
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(79,74));
    }
}
