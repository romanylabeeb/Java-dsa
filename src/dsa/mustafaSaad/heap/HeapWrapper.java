package dsa.mustafaSaad.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapWrapper {
    private List<Integer> heap;

    public HeapWrapper() {
        this.heap = new ArrayList<>();
    }

    public int size() {
        return this.heap.size();
    }

    public void pushBack(int val) {
        this.heap.add(val);
    }

    public void popBack() {
        heap.remove(heap.size() - 1);
    }

    public int front() {
        return this.get(0);
    }

    public int back() {
        return this.get(this.size() - 1);
    }

    public void set(int in, int val) {
        if (size() > in) {
            this.heap.set(in, val);
        }
    }

    public int get(int in) {
        return this.size() > 0 && this.size() > in ? this.heap.get(in) : -1;
    }

    public void print(){
        this.heap.forEach(System.out::println);
    }
}
