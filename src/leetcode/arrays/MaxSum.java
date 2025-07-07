package leetcode.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSum {

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int v : nums) {
            int digitsSum = getDigitsSum(v);
            if (!map.containsKey(digitsSum)) {
                map.put(digitsSum, v);
            } else {
                int cur = map.get(digitsSum);
                ans = Math.max(ans, v + cur);
                map.put(digitsSum, Math.max(v, cur));
            }
        }

        return ans;
    }

    private int getDigitsSum(int num) {
       int res=0;
       while(num>0){
           res+=num%10;
           num/=10;
       }
        return res;
    }
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int v:nums){
                pq.offer(Long.valueOf(v));
        }
        int count=0;
        while(!pq.isEmpty()&&pq.size()>1){
            if(pq.peek()>=k){break;} // all items >= k
            count++;
            long sum=(pq.poll()*2l) +pq.poll();
            pq.offer(sum);
        }
        return count;
    }
    public static void main(String[] args) {
//        int[] a = {229, 398, 269, 317, 420, 464, 491, 218, 439, 153, 482, 169, 411, 93, 147, 50, 347, 210, 251, 366, 401};
        MaxSum ob = new MaxSum();
        int []a={999999999,999999999,999999999};
        System.out.println(ob.minOperations(a,1000000000));
//        System.out.println(ob.maximumSum(a));
    }
}
