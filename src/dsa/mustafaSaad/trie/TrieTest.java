package dsa.mustafaSaad.trie;

public class TrieTest {

    static void testTrie(ITrie trie) {
        trie.insert("hello");
        trie.insert("world");

        // Testing wordExist
        System.out.println(trie.wordExist("hello")); // Output: true
        System.out.println(trie.wordExist("world")); // Output: true
        System.out.println(trie.wordExist("hell"));  // Output: false
        System.out.println(trie.wordExist("worlds")); // Output: false

        // Testing prefixExist
        System.out.println(trie.prefixExist("hell")); // Output: true
        System.out.println(trie.prefixExist("worl")); // Output: true
        System.out.println(trie.prefixExist("abc"));  // Output: false


        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("xyz");
        trie.insert("xn");
        trie.insert("ab");
        trie.insert("bcd");
        System.out.println("xyz is exist: " + trie.wordExist("xyz"));
        System.out.println("bcd is exist: " + trie.wordExist("bcd"));
        System.out.println("prefix bc is exist: " + trie.prefixExist("bc"));
        System.out.println("xy is exist: " + trie.wordExist("xy"));
        System.out.println("prefix xy is exist: " + trie.prefixExist("xy"));
        System.out.println("prefix xy is exist: " + trie.prefixExist("xnx"));
    }

    public static void main(String[] args) {
        TrieUsingMap trie = new TrieUsingMap();
        System.out.println("test trie using map");
        testTrie(trie);

        Trie trie2 = new Trie();
        System.out.println("test trie using array based");
        testTrie(trie2);
    }
}
