package dsa.mustafaSaad.queue;

public interface IQueue {
    public boolean isEmpty() ;
    public void enqueue(int data);
    public int dequeue();
    public int peak();
    public void display();
}
