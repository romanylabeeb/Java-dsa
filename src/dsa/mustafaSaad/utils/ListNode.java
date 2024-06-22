package dsa.mustafaSaad.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode createNext(int val) {
        ListNode nex = new ListNode(val);
        this.next = nex;
        return nex;
    }

}

