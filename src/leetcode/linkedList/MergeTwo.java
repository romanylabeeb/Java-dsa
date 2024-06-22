package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwo {
    /**
     * https://leetcode.com/problems/merge-two-sorted-lists/
     *
     * @param h1
     * @param h2
     * @return
     */
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                tail.next = h1;
                h1 = h1.next;
            } else {
                tail.next = h2;
                h2 = h2.next;
            }
            tail = tail.next;
        }
        if (h1 != null) {
            tail.next = h1;
        } else if (h2 != null) {
            tail.next = h2;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        mergeKLists(Arrays.asList(lists), tail);
        return dummy.next;

    }

    private void mergeKLists(List<ListNode> row, ListNode tail) {
        if (row.isEmpty()) return;
        List<ListNode> nextRow = new ArrayList<>();
        List<ListNode> tmpRow = new ArrayList<>();

        for (ListNode node : row) {
            if (node.next != null) {
                nextRow.add(node.next);
            }
            tmpRow.add(node);
        }
        // sorttmp row
        // Sort tmpRow based on ListNode values
        tmpRow.sort((n1, n2) -> Integer.compare(n1.val, n2.val));
        for (ListNode n : tmpRow) {
            tail.next = n;
            tail = tail.next;
        }

        // sort second row
        mergeKLists(nextRow, tail);
    }

    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode h1 = new ListNode(1);
        ListNode n11 = new ListNode(4);
        n11.next = new ListNode(5);
        h1.next=n11;

        ListNode h2 = new ListNode(1);
         n11 = new ListNode(3);
        n11.next = new ListNode(4);
        h2.next=n11;

        ListNode h3 = new ListNode(2);
        h3.next=new ListNode(6);
        MergeTwo m=new MergeTwo();
        m.mergeKLists(new ListNode[]{h1,h2,h3});

    }
}