package dsa.mustafaSaad.heap;

public interface IHeap {
    public void push(int key);
    public int pop();
    public  int size();
    public int top();

    public int parent(int in);

    public int left(int in);

    public int right(int in);

    public void  reHeapUp(int in);

    public void reHeapDown(int in);

}
