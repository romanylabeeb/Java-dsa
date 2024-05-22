package dsa.mustafaSaad.linkedlist;

import dsa.mustafaSaad.utils.DListNode;

public class DoubleLinkedListImpl implements ILinkedList<Integer>{
    int size=0;
    DListNode head;
    DListNode tail;
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void insert(Integer val) {
        if(isEmpty()){
            head=new DListNode(val);
        }
        else{
            DListNode temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            DListNode newNode=new DListNode(val);
            newNode.prev=temp;
            temp.next=newNode;
        }
        size++;
    }

    @Override
    public void insertAfter(Integer afterVal, Integer newVal) {
        DListNode temp = head;
        while (temp != null && temp.val != afterVal) {
            temp = temp.next;
        }
        if(temp!=null){
            DListNode newNode=new DListNode(newVal);
            DListNode next=temp.next;
            newNode.next=next;
            newNode.prev=temp;
            // update prev pointer for next node
            next.prev=newNode;
            temp.next=newNode;
            size++;
        }
    }

    @Override
    public void insertHead(Integer val) {
        if(isEmpty()){
            head=new DListNode(val);
        }
        else{
            DListNode newHead=new DListNode(val);
            newHead.next=head;
            head.prev=newHead;
            head=newHead;
            size++;
        }
    }

    @Override
    public boolean remove(Integer value) {
        // 1 -> 2 -> 3 -> 5 -> 6 -> 18 -> 9 -> null
        if (isEmpty()) {
            return false;
        }
        DListNode temp=head;
        while (temp!=null&&temp.val!=value){
            temp=temp.next;
        }
        if(temp!=null){
            DListNode prev=temp.prev;
            DListNode next=temp.next;
            // update next pointer
            if(prev==null){
                head=next;
            }
            else {
                prev.next=next;
            }
            // update previous pointers
            if(next!=null){
                next.prev=prev;
            }
            size--;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean removeAll(Integer val) {
        return false;
    }

    @Override
    public void printList() {
        DListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.val + " <---> ");
            pointer = pointer.next;
        }
        System.out.println("null");
    }

    public static void main(String ar[]) {
        DoubleLinkedListImpl impl = new DoubleLinkedListImpl();
        impl.insert(3);
        impl.insert(18);
        impl.insert(6);
        impl.insert(9);
        impl.insert(6);
        impl.printList();

        System.out.println("Insert 5 after 3");
        impl.insertAfter(3, 5);
        impl.printList();

        System.out.println("Insert 6 after 5");
        impl.insertAfter(5, 6);
        impl.printList();

        System.out.println("Insert 6 after 5");
        impl.insertAfter(5, 6);
        impl.printList();

        System.out.println("Insert 1,2 at head");
        impl.insertHead(2);
        impl.insertHead(1);

        impl.printList();
        System.out.println(impl.size);
        System.out.println("Remove 3");
        System.out.println(impl.remove(3));
        impl.printList();
        System.out.println(impl.size);

        System.out.println("Remove 6");
        System.out.println(impl.remove(6));
        impl.printList();
        System.out.println(impl.size);

        System.out.println("Remove 36");
        System.out.println(impl.remove(36));
        System.out.println(impl.size);

    }
}
