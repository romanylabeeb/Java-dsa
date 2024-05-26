package dsa.mustafaSaad.trie;

public class Trie implements ITrie {
    Trie[] child;
    boolean isLeaf;

    public Trie() {
        child = new Trie[26];
        isLeaf = false;
    }

    @Override
    public void insert(String s) {
        Trie current = this;

        for (char c : s.toCharArray()) {
            int v = c - 'a';
            if (current.child[v] == null) {
                current.child[v] = new Trie();
            }
            current = current.child[v];
        }
        current.isLeaf = true;
    }

    @Override
    public boolean wordExist(String s) {
        Trie current = this;

        for (char c : s.toCharArray()) {
            int ind = c - 'a';
            if (current.child[ind] == null) {
                return false;
            }
            current = current.child[ind];
        }
        return current.isLeaf;
    }

    @Override
    public boolean prefixExist(String s) {
        Trie current = this;
        for (char c : s.toCharArray()) {
            int ind = c - 'a';
            if (current.child[ind] == null) {
                return false;
            }
            current = current.child[ind];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("abc");
        t.insert("abcd");
        t.insert("xyz");
        t.insert("xn");
        t.insert("ab");
        t.insert("bcd");
        System.out.println("xyz is exist: " + t.wordExist("xyz"));
        System.out.println("bcd is exist: " + t.wordExist("bcd"));
        System.out.println("prefix bc is exist: " + t.prefixExist("bc"));
        System.out.println("xy is exist: " + t.wordExist("xy"));
        System.out.println("prefix xy is exist: " + t.prefixExist("xy"));
        System.out.println("prefix xy is exist: " + t.prefixExist("xnx"));
    }
}
