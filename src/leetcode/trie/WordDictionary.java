package leetcode.trie;

import dsa.mustafaSaad.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;


class TrieNode {
    Map<Character, TrieNode> nodes;
    boolean isLeaf;

    public TrieNode() {
        nodes = new HashMap();
        isLeaf = false;
    }

    void insert(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            cur = cur.nodes.computeIfAbsent(c, k -> new TrieNode());
        }
        cur.isLeaf = true;

    }

    /**
     * dfs
     *
     * @param word
     * @param start
     * @return
     */
    boolean search(TrieNode trieNode, String word, int start) {
        if (start == word.length()) {
            if (trieNode.isLeaf)
                return true;
            else
                return false;
        }
        if (start > word.length())
            return true;
        char c = word.charAt(start);
        if (c == '.') {
            for (TrieNode t : trieNode.nodes.values()) {
                if (start + 1 < word.length() && word.charAt(start + 1) != '.' && !t.nodes.containsKey(word.charAt(start + 1))) {
                    continue;
                }
                boolean found = search(t, word, start + 1);
                if (found)
                    return true;
            }
        } else {
            TrieNode cur = trieNode.nodes.get(c);
            if (cur == null)
                return false;
            if (start == word.length() - 1) {
                return cur.isLeaf;
            } else {
                return search(cur, word, start + 1);
            }
        }
        return false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    boolean dfs(TrieNode node, String word, int start) {
        TrieNode cur = node;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                //
                for (TrieNode t : cur.nodes.values()) {
                    if (dfs(t, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                cur = cur.nodes.get(c);
                if (cur == null) return false;

            }
        }
        return cur.isLeaf;

    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */