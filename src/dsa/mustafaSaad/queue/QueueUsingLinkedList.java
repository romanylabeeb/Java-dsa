package dsa.mustafaSaad.queue;

import java.util.List;

class ListNode{
    int value;
    ListNode next;
    public ListNode(int d){
        this.value=d;
    }
}
public class QueueUsingLinkedList implements IQueue {
    ListNode head;
    ListNode tail;
    int size=0;
    public boolean isEmpty(){
        return  size==0;
    }

    /**
     * enqueue in tail
     * @param data
     */
    @Override
    public void enqueue(int data) {
        ListNode temp=new ListNode(data);
        if(!isEmpty()){
            tail.next=temp;
        }
        else{
            head=temp;
        }
        tail=temp;
        size++;
    }

    /**
     * dequeue from head
     * @return
     */
    @Override
    public int dequeue() {
        if(!isEmpty()){
            int value=head.value;
            head=head.next;
//            System.out.println("Dequeue node:"+value);
            size--;
            return value;
        }
        System.out.println("queue is empty!!");
        return -1;
    }

    @Override
    public int peak() {
        if(!isEmpty()){
            return head.value;
        }
        return 0;
    }

    @Override
    public void display() {
        ListNode tmp=head;
        while (tmp!=null){
            System.out.print(tmp.value+"  >> ");
            tmp=tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue=new QueueUsingLinkedList();
        System.out.println(queue.isEmpty());
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        queue.display();
        int v = queue.dequeue();
        System.out.println("\ndeque element: " + v);
        queue.display();
        System.out.println("\nenqueue 1 element");

        queue.enqueue(1);
        queue.display();

        v = queue.dequeue();
        System.out.println("deque element: " + v);
        queue.display();
        v = queue.dequeue();
        System.out.println("deque element: " + v);
        queue.display();
        v = queue.dequeue();
        System.out.println("deque element: " + v);
        queue.display();
        System.out.println("front:" + queue.head.value);
        System.out.println("size:" + queue.size);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println("after enqueue 6,7,8");
        queue.display();

        System.out.println("front:" + queue.head.value);
        System.out.println("size:" + queue.size);
        v = queue.dequeue();
        System.out.println("deque element: " + v);
        queue.display();
        System.out.println("front:" + queue.head.value);
        System.out.println("size:" + queue.size);
    }
}
