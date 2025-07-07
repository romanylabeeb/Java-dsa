package dsa.mustafaSaad.bootcamp;

import java.io.*;
import java.util.*;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
class NestedIterator implements Iterator<List<Integer>> {
    private int index;
    private List<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public boolean hasNext() {
        return index < nestedList.size();
    }

    @Override
    public List<Integer> next() {
        NestedInteger nested = nestedList.get(index++);
        List<Integer> list = new ArrayList<>();
        flatten(nested, list);
        return list;
    }

    void flatten(NestedInteger nested, List<Integer> list) {
        if (nested.isInteger()) {
            list.add(nested.getInteger());
        } else {
            for (NestedInteger current : nested.getList()) {
                flatten(current, list);
            }
        }
    }
}
// Example implementation of NestedInteger interface
class NestedIntegerImpl implements NestedInteger {
    private Integer integer;
    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
        this.list = null;
    }

    public NestedIntegerImpl(List<NestedInteger> list) {
        this.integer = null;
        this.list = list;
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
public class NestedInt {
    public static void main(String[] args) {

        List<NestedInteger> nestedList = new ArrayList<>();

        // Adding elements manually for demonstration
        List<NestedInteger> firstNested = new ArrayList<>();
        firstNested.add(new NestedIntegerImpl(1));
        firstNested.add(new NestedIntegerImpl(1));
        nestedList.add(new NestedIntegerImpl(firstNested));

        nestedList.add(new NestedIntegerImpl(2));

        List<NestedInteger> secondNested = new ArrayList<>();
        secondNested.add(new NestedIntegerImpl(1));
        secondNested.add(new NestedIntegerImpl(1));
        nestedList.add(new NestedIntegerImpl(secondNested));

        NestedIterator iterator = new NestedIterator(nestedList);
        while (iterator.hasNext()) {
            System.out.println( "next");
            iterator.next().forEach(System.out::println);
            System.out.println( "----------");

        }
    }

}
