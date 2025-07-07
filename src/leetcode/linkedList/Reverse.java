package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;


public class Reverse {
    /**
     * https://leetcode.com/problems/reverse-linked-list/
     */
    public ListNode reverseList(ListNode head) {
        ListNode nh = null;
        ListNode p = head;
        while (p != null) {
            ListNode nxt = p.next;
            p.next = nh;
            nh = p;
            p = nxt;

        }
        return nh;
    }

    /**
     * /**
     * * https://leetcode.com/problems/reverse-linked-list/
     * 1 -> 2 -> 3
     * split as sub linked list
     *
     * @param head
     * @return
     */
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        // revers pointers
        head.next.next = head;
        head.next = null;
        return newHead;
    }


}
