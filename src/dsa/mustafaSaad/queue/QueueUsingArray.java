package dsa.mustafaSaad.queue;

class QueueImpl2 {
    int[] q;
    int front=0;
    int size = 0;

    public QueueImpl2(int size) {
        q = new int[size];
    }

   public boolean isEmpty() {
        return this.size == 0;
    }

    boolean isFull() {
        return size == q.length ;
    }

    int dequeue() {
        if (!isEmpty()) {
            int res=q[front];
            front=(front+1)%q.length;
            size--;
            return res;
        }
        return -1;
    }
    // 5  f=1 size=1
    boolean enqueue(int d){
        if(isFull()) return false;
        int rp=(front+size) %q.length;
        q[rp]=d;
        size++;
        return true;
    }
    public void display() {
       int end=front+size >=q.length?q.length-1:size;
       for(int i=front;i<=end;i++){
           System.out.print(q[i]+ " >> ");
       }
       end=q.length-(size+front);
       if(end>0){
           for(int i=0;i<=end;i++){
               System.out.print(q[i]+ " >> ");
           }
       }
        System.out.println();

    }
}

class QueueImpl {
    int[] q;
    int rear;
    int front;
    int size = 0;

    public QueueImpl(int size) {
        q = new int[size];
        rear = -1;
        front = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return rear - front == 0;
    }

    public boolean isFull() {
        return rear > front ? rear - front == size - 1 : front - rear == 1;

    }

    public void enqueue(int data) {
        if (!isFull()) {
            if (rear == q.length - 1) {
                rear = -1;
            }
            q[++rear] = data;
            if (front == -1) front = 0;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        else {
            int res = q[front++];
            if (front >= q.length) {
                front = 0;
            }
            return res;
        }
    }

    public int peak() {
        if (!isEmpty()) return q[front];
        return -1;
    }

    public void display() {
        int end = rear < front ? q.length - 1 : rear;
        for (int i = front; i <= end; i++) {
            System.out.print(q[i] + " >> ");
        }
        if (rear < front) {
            for (int i = 0; i <= rear; i++) {
                System.out.print(q[i] + " >> ");
            }
        }
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        QueueImpl2 queue = new QueueImpl2(5);
        System.out.println(queue.isFull());
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
        System.out.println("front:" + queue.front);
        System.out.println("size:" + queue.size);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        System.out.println("after enqueue 6,7,8");
        queue.display();

        System.out.println("front:" + queue.front);
        System.out.println("size:" + queue.size);
        v = queue.dequeue();
        System.out.println("deque element: " + v);
        queue.display();
        System.out.println("front:" + queue.front);
        System.out.println("size:" + queue.size);
    }
}
