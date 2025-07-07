package leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CircularQueueImpl {
    final int capacity;
    final int[] v;
    int front;
    int rear;
    int size;

    public CircularQueueImpl(int k) {
        capacity = k;
        v = new int[k];
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == capacity;

    }
    int overlapIncrease(int p) {
        return p == capacity - 1 ? 0 : p + 1;
    }
    int overlapDecrease(int p) {
        return p == 0 ? capacity-1 : p - 1;
    }
    public boolean insertFront(int val) {
        if (isFull()) return false;
        // add front mean move front pointer backward decrease it
        // calc front index
        front = overlapDecrease(front);
        v[front] = val;
        size++;
        return true;

    }


    public boolean insertLast(int val) {
        if (isFull()) return false;
        v[rear] = val;
        rear = overlapIncrease(rear);
        size++;
        return true;
    }
    public void inc(String key) {
      Map<String,Integer> map=new HashMap<>();
        Deque<String> maxQueue=new ArrayDeque<>();
        Deque<String> minQueue=new ArrayDeque<>();
        int count=map.getOrDefault(key,0);
        map.put(key,count+1);
        String prevMax=maxQueue.peek();

       if(prevMax==null){
           maxQueue.offer(key);
       }
       else if(prevMax.length()>=key.length()){
           maxQueue.addFirst(key);
       }
       else{
           maxQueue.add(key);
       }
       String prevMin=minQueue.peek();
       if(prevMin==null){
           minQueue.offer(key);
       }
       else if(prevMin.length()>key.length()){
           minQueue.addFirst(key);
       }
       else{
           minQueue.addLast(key);
       }
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        // delete front increase  front pointer by one and overlap if =capacity-1
        v[front] = -1;
        front = overlapIncrease(front);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = overlapDecrease(rear);
        v[rear] = -1;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return v[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        int ind=overlapDecrease(rear);
        return v[ind];
    }
}
