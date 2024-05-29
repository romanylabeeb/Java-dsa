package dsa.mustafaSaad.trie;

/**
 * trie interface
 */
public interface ITrie {
    public  void insert(String s);
    public boolean wordExist(String s);
    public  boolean prefixExist(String s);
}
