package leetcode.linkedList;

import dsa.mustafaSaad.utils.ListNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicates {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        Set<Integer> dup = new HashSet<>();
        ListNode prev = null;
        while (current != null) {
            if (dup.contains(current.val)) {
                prev.next = current.next;
            } else {
                prev = current;
                dup.add(current.val);
            }
            current = current.next;
        }
        return head;
    }

    public String largestNumber(int[] nums) {
        String[]strs=new String[nums.length];
        for(int i=0;i<nums.length;++i){
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (s,t)-> (t+s).compareTo(s+t));
        StringBuilder sb = new StringBuilder();
        for(String w:strs){sb.append(w);}

        String large= sb.toString();
        return large.startsWith("0")?"0":large;
    }

    public void removeDuplicates(ListNode head, int n) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            if (prev != null && current.val == prev.val) {
                ListNode tmpNext = current.next;
                prev.next = tmpNext;
                current = tmpNext;
            } else {
                prev = current;
            }
        }
    }
}
