package leetcode.twopointers;

import java.util.HashMap;
import java.util.Map;

public class MaxTrappingwater {
    public int trap(int[] h) {
        int lp=0,rp=1;
        int total=0;
        int n=h.length;
        while(lp<n&&rp<n){
            int maxRight=0;
            int sumBlocks=0;
            while(rp<n&&h[lp]>h[rp]){
                if(maxRight<h[rp]) maxRight=h[rp];
                sumBlocks+=h[rp++];
            }
            if(rp==n) break;
            if(rp<n) maxRight=h[lp];
            int w=rp-lp-1;
            total+= (w*maxRight)-sumBlocks;
            lp=rp;
            rp++;
        }
        return total;
    }

    public static void main(String[] args) {
        MaxTrappingwater m=new MaxTrappingwater();
        Map<Integer,Boolean>map=new HashMap<>();
        System.out.println(m.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
