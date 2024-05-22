package dsa.mustafaSaad.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackUsingArray implements IStack {
    int top;
    int maxSize;
    int []a;

    public StackUsingArray(int max) {
        this.a = new int[max];
        top = -1;
        maxSize = max;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }
boolean isFull(){
        return top==maxSize-1;
}
    @Override
    public void push(int data) {
        if(!isFull()){
            a[++top]=data;
        }
    }

    @Override
    public int pop() {
        return !isEmpty() ? a[top--] : -1;
    }

    @Override
    public int peak() {
        return !isEmpty() ? a[top] : -1;

    }

    @Override
    public void display() {
        for(int i=top;i>=0;i--){
            System.out.print(a[i]+ " >> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackUsingArray impl=new StackUsingArray(5);
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
