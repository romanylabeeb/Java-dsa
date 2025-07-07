package leetcode.queue;

import java.util.*;
class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

}
class MyCircularQueue {
    private List<Integer> list;
    private int size = 0;
    private int f = 0;
    private int r = 0;
    private int count = 0;

    public MyCircularQueue(int k) {
        this.list = new ArrayList<Integer>(k);
        this.size = k;
    }

    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        if (this.r  == this.size) {
            this.r = 0;
        }
        this.list.add(r++, value);
        this.count++;
        return true;
    }

    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.list.add(this.f, null);
        this.f =(this.f + 1 == this.size)? 0:f+1;
        this.count--;
        return true;

    }

    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.list.get(this.f);
    }

    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.list.get(this.r-1);
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.size;
    }
/*
["MyCircularQueue",
"enQueue","enQueue","enQueue","enQueue",
"Rear",
"isFull",
"deQueue",
"enQueue",
"Rear"]
 */
    public static void main(String[] args) {

        List<Integer>l=new ArrayList<>(3);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(l);
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.list);
        int rear = obj.Rear();
        System.out.println(rear);
        boolean full = obj.isFull();
        System.out.println(full);
        boolean deq= obj.deQueue();
        System.out.println(deq);
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */