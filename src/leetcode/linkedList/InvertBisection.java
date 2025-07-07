package leetcode.linkedList;

import java.util.*;

public class InvertBisection {
    public static LinkedList invertedBisection(LinkedList head) {
        // Write your code here.
        LinkedList p1 = head;
        int size = 0;
        while (p1 != null) {
            size++;
            p1 = p1.next;
        }
        LinkedList firstHalf = null;
        LinkedList p = head;
        //split in two halfs
        int count = 0;
        while (count < size / 2) {
            count++;
            firstHalf = p;
            p = p.next;
        }

        if (firstHalf != null) {
            firstHalf.next = null;
        }

        LinkedList firstPart = getReversed(head);
        LinkedList mid = null;

        if (size % 2 != 0) {
            mid = p;
            p = p.next;
        }
        LinkedList secondPart = getReversed(p);
        LinkedList tail = firstPart;
        if (firstPart != null) {
            while (tail.next != null) {
                tail = tail.next;
            }
            if (mid != null) {
                tail.next = mid;
                mid.next = secondPart;
            } else {
                tail.next = secondPart;
            }
        }
        return firstPart;
    }

    static LinkedList getReversed(LinkedList head) {
        if (head == null || head.next == null) return head;
        LinkedList nh = null;
        LinkedList p = head;
        while (p != null) {
            LinkedList tmpNxt = p.next;
            p.next = nh;
            nh = p;

            p = tmpNxt;
        }
        return nh;
    }

    // This is an input class. Do not edit.
    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }


    public static List<String> specialStrings(String[] strings) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            if ("B".equals(element)) {
                list.remove(element);
                iterator.remove();  // Safely removing element
            }
        }
        // Write your code here.
        List<String> specailList = new ArrayList<>();

        Set<String> words = new HashSet<>();
        for (String w : strings) {
            specailList.add(w);
        }

        for (String w : strings) {
            // remove current
            words.remove(w);
            if (canFormed(w, words)) {
                specailList.add(w);
            }
            words.add(w);
        }
        return specailList;
    }

    public static boolean canFormed(String target, Set<String> words) {
        if (target.isEmpty()) return true;
        for (String w : words) {
            if (w.startsWith(target)) {
                return canFormed(target.substring(w.length()), words);
            }
        }
        return false;
    }
}
