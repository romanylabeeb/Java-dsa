package leetcode.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMaxAfterMultiply {
//https://leetcode.com/problems/final-array-state-after-k-multiplication-operations-i/
    // using pq
    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        Comparator<int[]> cm = (v1, v2) -> {
            int com = Integer.compare(v1[0], v2[0]);
            if (com == 0) {
                return Integer.compare(v1[1], v2[1]);
            }
            return com;
        };
        PriorityQueue<int[]> pq = new PriorityQueue<>(cm);
        for(int i=0;i<nums.length;++i){
            pq.offer(new int[]{nums[i],i});
        }
        for (int j = 0; j < k; ++j) {
            int[] a=pq.poll();
            a[0]*=multiplier;
            nums[a[1]]=a[0];
            pq.offer(a);
        }
        return nums;
    }
//brute force
    public int[] getFinalState2(int[] nums, int k, int multiplier) {

        for(int j=0;j<k;++j){

            int minInd=getIndexForMin(nums);
            nums[minInd]*=multiplier;
        }
        return nums;
    }

    int getIndexForMin(int[]a){
        int min=a[0];
        int ind=0;
        for(int i=1;i<a.length;++i){
            if(min>a[i]){
                min=a[i];
                ind=i;
            }
        }
        return ind;
    }
    public static void main(String[] args) {
        int[]nums={2,1,3,5,6};
        int k=5;
        int multiplier=2;
        getFinalState(nums,k,multiplier);
    }
}
