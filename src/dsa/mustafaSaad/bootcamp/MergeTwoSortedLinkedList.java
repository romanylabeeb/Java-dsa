package dsa.mustafaSaad.bootcamp;

import dsa.mustafaSaad.utils.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions/1299766839/
 */
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode dummyNode=new ListNode();
        ListNode p=dummyNode;
        while (h1!=null&&h2!=null){
            if(h1.val<h2.val){
                p.next=h1;
                h1=h1.next;
            }
            else{
                p.next=h2;
                h2=h2.next;
            }
            p=p.next;
        }
        if(h1!=null){
            p.next=h1;
        }
        else{
            p.next=h2;
        }
        return dummyNode.next;
    }

    }
