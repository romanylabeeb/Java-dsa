package dsa.mustafaSaad.stack;

import dsa.mustafaSaad.utils.ListNode;

public class StackUsingLinkedList implements IStack{
    ListNode top;
    int size=0;

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public void push(int data) {
        ListNode tmp=new ListNode(data);
        tmp.next=top;
        top=tmp;
        size++;
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            int v=top.val;
            top=top.next;
            size--;
            return v;
        }
        return -1;
    }

    @Override
    public int peak() {
        return !isEmpty()?top.val:-1;
    }

    @Override
    public void display() {
    ListNode tmp=top;
    while (tmp!=null){
        System.out.print(tmp.val+" >> ");
        tmp= tmp.next;
    }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingLinkedList impl=new StackUsingLinkedList();
        impl.push(5);
        impl.push(4);
        impl.push(3);
        impl.push(2);
        impl.push(1);
        impl.display();
        int v= impl.pop();
        System.out.println("pop value:"+v);
        v= impl.pop();
        System.out.println("pop value:"+v);
        v= impl.pop();
        System.out.println("pop value:"+v);
        impl.push(6);
        impl.push(7);
        impl.display();
    }
}
