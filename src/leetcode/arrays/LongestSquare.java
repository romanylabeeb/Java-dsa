package leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquare {

    public static int longestSquareStreak(int[] nums) {
        Set<Integer> u=new HashSet<>();
        int max=0;
        Arrays.sort(nums);
        for(int v:nums){
            u.add(v);
        }
        for(int v:nums){
            int count=1;
            int tmp=v*v;
            while(u.contains(tmp)){
                tmp*=tmp;
                count++;
            }
            if(count>1){
                max=Math.max(max,count);
            }
        }
        return max>0?max:-1;
    }

    public static void main(String[] args) {
        int[] a={4,3,6,16,8,2};
        System.out.println(longestSquareStreak(a));
    }
}
