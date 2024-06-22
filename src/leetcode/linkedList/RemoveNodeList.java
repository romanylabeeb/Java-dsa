package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNodeList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode r = head;
        int count = 0;
        while (r != null && n > 0) {
            r = r.next;
            n--;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode l = dummy;
        while (r != null) {
            l = l.next;
            r = r.next;
        }
        l.next = l.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null)
            return head;
        ListNode t = head;
        int size = 0;
        while (t != null) {
            size++;
            t = t.next;
        }
        int indexToRemove = size - n;
        if (indexToRemove == 0) {
            return head.next;
        }
        t = head;
        int counter = 0;
        ListNode prev = head;
        while (t != null && counter < indexToRemove) {
            counter++;
            prev = t;
            t = t.next;
        }
        if (t != null) {
            prev.next = t.next;
        }
        return head;
    }
}
