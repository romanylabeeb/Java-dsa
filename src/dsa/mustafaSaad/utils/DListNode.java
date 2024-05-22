package dsa.mustafaSaad.utils;

public class DListNode {
    public int val;
    public DListNode next;
    public DListNode prev;

    public  DListNode(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}
