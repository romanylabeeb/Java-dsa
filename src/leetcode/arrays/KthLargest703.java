package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargest703 {
    int k;
    PriorityQueue<Integer> maxHeap;

    public KthLargest703(int k, int[] nums) {
        this.k = k;
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        // Adding elements from the array to the max heap
        for (int v : nums) {
            maxHeap.offer(v);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
    }

    public int add(int val) {
        maxHeap.offer(val);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        KthLargest703 sol=new KthLargest703(3,new int[]{4,5,8,2});
        System.out.println("add 3:"+sol.add(3));
        System.out.println("add 5:"+sol.add(5));
        System.out.println("add 10:"+sol.add(10));
        System.out.println("add 9:"+sol.add(9));
        System.out.println("add 9:"+sol.add(4));
    }
}
