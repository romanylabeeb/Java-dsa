package dsa.mustafaSaad.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeapImpl implements IHeap {
    HeapWrapper heap;

    public MinHeapImpl() {
        this.heap = new HeapWrapper();
    }

    @Override
    public void push(int key) {
        // add in last index
        this.heap.pushBack(key);
        // re heap up this key
        this.reHeapUp(this.size() - 1);
    }

    @Override
    public int pop() {
        int top=this.heap.front();
        // get last node value
        int lastNodeVal = this.heap.back();
        // update top node value=lastNodeVal
        this.set(0, lastNodeVal);
        // remove last node
        heap.popBack();
        // re heap down starting from top node
        this.reHeapDown(0);
        return top;
    }

    @Override
    public int size() {
        return this.heap.size();
    }

    @Override
    public int top() {
        return this.heap.front();
    }

    @Override
    public int parent(int in) {
        if (in == 0) return -1;
        return (in - 1) / 2;
    }

    @Override
    public int left(int in) {
        int lp = (in * 2) + 1;
        return lp < this.size() ? lp : -1;
    }

    @Override
    public int right(int in) {
        int rp = (in * 2) + 2;
        return rp < this.size() ? rp : -1;
    }

    public int get(int index) {
        return this.heap.get(index);
    }

    public void set(int in, int val) {
        this.heap.set(in, val);
    }

    @Override
    public void reHeapUp(int in) {
        // no parent for the root where in=0;
        if (in == 0) {
            return;
        }
        int parentIndex = this.parent(in);

        // swap and re heap if parent value> current value
        if (this.get(parentIndex) > this.get(in)) {

            // swap values for parent and it's child
            int cVal = this.get(in);
            this.set(in, this.get(parentIndex));
            this.set(parentIndex, cVal);

            // re heap up for new  parent index
            this.reHeapUp(parentIndex);
        }
    }

    @Override
    public void reHeapDown(int in) {
        int lSelectIndex = this.left(in);
        if (lSelectIndex == -1) return;
        int rIndex = this.right(in);
        if (rIndex != -1 && this.get(rIndex)<this.get(lSelectIndex)){
            lSelectIndex=rIndex;
        }
        // if current value > child then swap and re heap down again
        if(this.get(in)>this.get(lSelectIndex)){
            //swap
            int cVal=this.get(lSelectIndex);
            this.set(lSelectIndex,this.get(in));
            this.set(in,cVal);
            reHeapDown(lSelectIndex);
        }
    }
    public void  print(){
        this.heap.print();
    }

    public static void main(String[] args) {
        MinHeapImpl h=new MinHeapImpl();
        h.push(3);
        h.push(4);
        h.push(7);
        h.push(21);
        h.push(10);
        h.push(20);
        h.push(8);
        h.push(22);
        h.push(28);
        h.push(13);
        h.push(19);
        h.push(25);

        h.print();

        h.push(6);
        h.print();

        int v=h.pop();
        System.out.println("pop value:"+v);


        h.print();
    }
}
