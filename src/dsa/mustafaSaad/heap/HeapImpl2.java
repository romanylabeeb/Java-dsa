package dsa.mustafaSaad.heap;

import java.util.*;

public class HeapImpl2 {
    private int[] heap;
    int elements;
    static int DEFAULT_SIZE = 10;

    public HeapImpl2() {
        this(DEFAULT_SIZE);
    }

    public HeapImpl2(int size) {
        heap = new int[size];
    }

    void enqueue(int val) {
        // validate size
        //add
        // reheapup
        validateSize();
        heap[elements] = val;
        reHeapup(elements, val);
        elements++;
    }

    void setByIndex(int index, int val) {
        heap[index] = val;
    }

    private void reHeapup(int index, int val) {
        int parent = getParentIndex(index);
        if (parent >= 0 && heap[parent] > val) {
            setByIndex(index, heap[parent]);
            reHeapup(parent, val);
        } else {
            heap[index] = val;
        }


    }

    int dequeue() {
        if (isEmpty()) return -1;
        int val = heap[0];
        elements--;
        if (elements > 0) {
            int lastVal = heap[elements];
            heap[elements] = 0;
            //swapLastElement
            reheapDown(0, lastVal);
        }
        return val;
    }

    private void reheapDown(int index, int lastVal) {
        int smallest = index;
        int left = getLeft(smallest);
        int right = getRight(smallest);
        if (left < elements && heap[left] < lastVal) {
            smallest = left;
        }
        if (right < elements && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != index) {
            setByIndex(index, heap[smallest]);
            reheapDown(smallest, lastVal);
        } else {
            heap[smallest] = lastVal;
        }
    }


    private boolean isEmpty() {
        return elements == 0;
    }

    private boolean isFull() {
        return elements == heap.length;
    }

    void validateSize() {
        if (isFull()) {
            int nC = elements + elements / 2;
            heap = Arrays.copyOf(heap, nC);
        }
    }

    int getParentIndex(int in) {
        if (in == 0) return -1;
        return (in - 1) / 2;
    }

    int getLeft(int in) {
        return (in * 2) + 1;
    }

    int getRight(int in) {
        return (in * 2) + 2;
    }


    boolean hasGreatParent(int index, int val) {
        int parent = (index - 1) / 2;
        return heap[parent] > val;
    }

    void swapParentDown(int index, int val) {
        int parent = (index - 1) / 2;
        heap[index] = heap[parent];
    }

    public static void main(String[] args) {
//        HeapImpl2 impl = new HeapImpl2();
//        4, 7, 3, 8, 2, 9, 6, 5, 1
//        impl.enqueue(4);
//        impl.enqueue(7);
//        impl.enqueue(3);
//        impl.enqueue(8);
//        impl.enqueue(2);
//        impl.enqueue(9);
//        impl.enqueue(6);
//        impl.enqueue(5);
//        impl.enqueue(1);
//        for (int val : impl.heap) {
//            System.out.println(val);
//        }
//        int d1 = impl.dequeue();
//        System.out.println("d1" + d1);
//
//        int d2 = impl.dequeue();
//        System.out.println("d2" + d2);
//        System.out.println("/////////");
        HeapImpl2 heap = new HeapImpl2();
        heap.enqueue(10);
        heap.enqueue(5);
        heap.enqueue(20);
        heap.enqueue(3);
        heap.enqueue(2);
        for (int val : heap.heap) {
            System.out.println(val);
        }
        System.out.println("******");
        System.out.println(heap.dequeue()); // 2
        System.out.println(heap.dequeue()); // 3
        System.out.println(heap.dequeue()); // 5
        System.out.println(heap.dequeue()); // 10
    }
}

