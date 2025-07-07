package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountWaysBuildGoodString2466 {
    int low, high, zero, one;
    int[] lookup;
    static int mod = 1000000000 + 7;

    //    using memoization bottom up
    public int countGoodStrings2(int low, int high, int zero, int one) {
        this.low = low;
        this.high = high;
        this.zero = zero;
        this.one = one;
        this.lookup = new int[high + 1];
        Arrays.fill(this.lookup, -1);
        return dfs(0);
    }

    int dfs(int len) {
        if (len > high) return 0;
        if (lookup[len] > -1) {
            return lookup[len];
        }
        int res = len >= low ? 1 : 0;
        lookup[len] = (res + dfs(len + zero) + dfs(len + one)) % mod;
        return lookup[len];

    }

    // using tabulation top down
    public static   int countGoodStrings(int low, int high, int zero, int one) {
        int []lookup=new int[high+1];
        lookup[0]=1;
        int sum=0;
        for (int i = 1; i < high + 1; ++i) {
            if(i>=zero){
                lookup[i]+=lookup[i-zero];
            }
            if(i>=one){
                lookup[i]+=lookup[i-one];
            }
            lookup[i]%=mod;
            if(i>=low){
                sum=(sum+lookup[i])%mod;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int low=1,high=100000,zero=1,one=1;
        int res=countGoodStrings(low,high,zero,one);
        System.out.println(res);
    }
}
