package dsa.mustafaSaad.trie;

public interface ITrie {
    public  void insert(String s);
    public boolean wordExist(String s);
    public  boolean prefixExist(String s);
}
