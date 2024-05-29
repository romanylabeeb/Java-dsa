package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Cycle {
    /**
     * use hashset
     * https://leetcode.com/problems/linked-list-cycle/
     *
     * @param head
     * @return
     */
    public boolean hasCycleUsingSet(ListNode head) {
        Set<ListNode> visited = new HashSet();
        ListNode p = head;
        while (p != null && !visited.contains(p)) {
            visited.add(p);
            p = p.next;
        }

        return p == null ? false : true;
    }

    /**
     * using fast-slow pointers
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
