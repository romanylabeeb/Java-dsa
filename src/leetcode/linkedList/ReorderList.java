package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;
/**
 * https://leetcode.com/problems/reorder-list/submissions/1271686536/
 */
import java.util.Stack;

public class ReorderList {
    public void reorderListUsingSack(ListNode head) {
        if (head == null) return;
        int size = 0;
        Stack<ListNode> stk = new Stack();
        ListNode t = head;
        while (t != null) {
            size++;
            stk.push(t);
            t = t.next;
        }
        t = head;
        int counter = size / 2;
        while (counter >= 0) {
            ListNode r = stk.pop();
            r.next = t.next;
            t.next = r;
            t = r.next;
            counter--;
        }
        t.next = null;
    }


    //        1 ,2 ,3 ,4 ,5
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;

        ListNode prev = null;
        // reverse second part
        while (second != null) {
            ListNode nxt = second.next;
            second.next = prev;
            prev = second;
            second = nxt;
        }

        // merge
        second = prev;
        ListNode first = head;
        while (second != null) {
            ListNode nxt1 = first.next, nxt2 = second.next;

            first.next = second;
            second.next = nxt1;

            second = nxt2;
            first = nxt1;
        }
    }
}