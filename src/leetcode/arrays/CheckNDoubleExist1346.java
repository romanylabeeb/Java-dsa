package leetcode.arrays;

import java.util.*;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/description/
 */
public class CheckNDoubleExist1346 {
    public static boolean checkIfExist(int[] arr) {
        // Create a Set and add elements from the array
        Map<Integer,Integer> map = new HashMap();
        for (int i=0;i<arr.length;i++) {
            map.put( arr[i],i);
        }
        for (int i=0;i<arr.length;i++) {
            int index=map.getOrDefault(arr[i]*2,-1);
            if (index>-1&&index!=i) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []a={-2,0,10,-19,4,6,-8};
        System.out.println(checkIfExist(a));
    }
}
