package dsa.mustafaSaad.linkedlist;

public interface ILinkedList<T> {
    boolean isEmpty();
    void insert(T val);
    void insertAfter(T afterVal, T newVal);
    void insertHead(T val);
    boolean remove(T value);

    boolean removeAll(T val);
    void printList();
}
