package leetcode.set;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bitset {
    Set<Integer> one = new HashSet<>();
    Set<Integer> zero = new HashSet<>();
    int size;

    public Bitset(int size) {
        this.size = size;
        for (int i = 0; i < size; ++i) {
            zero.add(i);
        }
    }

    public void fix(int idx) {
        one.add(idx);
        zero.remove(idx);
    }

    public void unfix(int idx) {
        zero.add(idx);
        one.remove(idx);
    }

    public void flip() {
        Set<Integer> tmp = zero;
        zero = one;
        one = tmp;
    }

    public boolean all() {
       return zero.isEmpty();
    }

    public boolean one() {
        return !one.isEmpty();
    }

    public int count() {
        return one.size();
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (one.contains(i)) {
                sb.append(i);
            } else if (zero.contains(i)) {
                sb.append(i);
            }
        }
        char c='a';
        char c2= (char) (c+1);
        return sb.toString();
    }
}
