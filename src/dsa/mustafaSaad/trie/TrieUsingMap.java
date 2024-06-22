package dsa.mustafaSaad.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieUsingMap implements ITrie {
    Map<Character, TrieUsingMap> child;
    boolean isLeaf;

    public TrieUsingMap() {
        this.child = new HashMap<>();
        isLeaf = false;
    }

    @Override
    public void insert(String s) {
        TrieUsingMap cur = this;
        for (char c : s.toCharArray()) {
            cur = cur.child.computeIfAbsent(c, k -> new TrieUsingMap());
        }
        cur.isLeaf = true;
    }

    @Override
    public boolean wordExist(String s) {
        TrieUsingMap current = this;
        for (char c : s.toCharArray()) {
            current = current.child.get(c);
            if (current==null) {
                return false;
            }
        }
        return current.isLeaf;
    }

    @Override
    public boolean prefixExist(String s) {
        TrieUsingMap current = this;
        for (char c : s.toCharArray()) {
            current = current.child.get(c);
            if (current==null) {
                return false;
            }
        }
        return true;
    }
}
