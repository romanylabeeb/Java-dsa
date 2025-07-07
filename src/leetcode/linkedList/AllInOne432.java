package leetcode.linkedList;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllInOne432 {
    class Node {
        int freq;
        Set<String> strs = new HashSet<>();
        Node next;
        Node prev;

        Node() {}

        Node(int freq) {
            this.freq = freq;
        }
    }

    Map<String, Node> map;
    Node head;
    Node tail;

    public AllInOne432() {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        Node curr = map.get(key);
        int freq = 1;
        if (curr != null) {
            freq = curr.freq + 1;
            removeKeyFromNode(curr, key);
        }

        Node pointer = head.next;
        while (pointer != null && pointer != tail && pointer.freq < freq) {
            pointer = pointer.next;
        }

        if (pointer != null && pointer.freq == freq) {
            pointer.strs.add(key);
        } else {
            Node newNode = new Node(freq);
            newNode.strs.add(key);
            newNode.prev = pointer.prev;
            newNode.next = pointer;
            pointer.prev.next = newNode;
            pointer.prev = newNode;
        }

        map.put(key, pointer.prev);  // pointer.prev is now the node with the correct freq
    }

    private void removeKeyFromNode(Node curr, String key) {
        if (curr == null) return;
        curr.strs.remove(key);
        if (curr.strs.isEmpty()) {
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = null;
            curr.prev = null;
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);
        if (curr == null) return;
        curr.strs.remove(key);

        if (curr.freq == 1) {
            map.remove(key);
            removeKeyFromNode(curr, key);
            return;
        }

        int freq = curr.freq - 1;
        Node pointer = curr.prev;
        while (pointer != null && pointer != head && pointer.freq > freq) {
            pointer = pointer.prev;
        }

        if (pointer != null && pointer.freq == freq) {
            pointer.strs.add(key);
        } else {
            Node newNode = new Node(freq);
            newNode.strs.add(key);
            newNode.prev = pointer;
            newNode.next = pointer.next;
            pointer.next.prev = newNode;
            pointer.next = newNode;
        }

        map.put(key, pointer.next);  // pointer.next is now the node with the correct freq
        if (curr.strs.isEmpty()) {
            removeKeyFromNode(curr, key);
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) return "";  // Handle empty list case
        return tail.prev.strs.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) return "";  // Handle empty list case
        return head.next.strs.iterator().next();
    }
}

