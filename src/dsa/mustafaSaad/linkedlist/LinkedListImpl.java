package dsa.mustafaSaad.linkedlist;


import dsa.mustafaSaad.utils.ListNode;

public class LinkedListImpl implements ILinkedList<Integer> {
    private ListNode head;
    int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }
public  ListNode search(int val){
        ListNode temp=head;
        while(temp!=null&&temp.val!=val){
            temp=temp.next;
        }
        return temp;
}
    /**
     * O(N) loop to insert new node
     * @param val
     */
    @Override
    public void insert(Integer val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            ListNode lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * O(N)
     * @param afterVal
     * @param newVal
     */
    public void insertAfter(Integer afterVal, Integer newVal) {
        ListNode temp = head;
        while (temp != null && temp.val != afterVal) {
            temp = temp.next;
        }
        if (temp != null) {
            ListNode newNode = new ListNode(newVal);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    /**
     * O(1) just insert in head
     * @param val
     */
    public void insertHead(Integer val) {
        ListNode newHead = new ListNode(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    /**
     * O(N)
     * @param value
     * @return
     */
    public boolean remove(Integer value) {
        // 1 -> 2 -> 3 -> 5 -> 6 -> 18 -> 9 -> null
        if (isEmpty()) {
            return false;
        }
        ListNode temp = head;
        ListNode before = null;
        // get exact node to be removed with getting prev node pointer in before value
        while (temp != null && temp.val != value) {
            before = temp;
            temp = temp.next;
        }
        if (temp != null) {
            if (before == null) {
                head = temp.next;
            } else {
                before.next = temp.next;
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * O(N)
     * @param val
     * @return
     */
    public boolean removeAll(Integer val){
        // 1 -> 2 -> 3 -> 5 -> 6 -> 18 -> 9 -> null
        if (isEmpty()) {
            return false;
        }
        int oldSize=size;
        ListNode temp = head;
        ListNode before = null;
        // get exact node to be removed with getting prev node pointer in before value
        while (temp != null ) {
            if (temp.val==val) {
                if (before == null) {
                    head = temp.next;
                } else {
                    before.next = temp.next;
                }
                size--;
            }
            else {
                before = temp;
            }
            temp = temp.next;
        }

        return oldSize==size;
    }

    /**
     * O(N)
     */
    public void printList() {

        ListNode pointer = head;
        while (pointer != null) {
            System.out.print(pointer.val + " -> ");
            pointer = pointer.next;
        }
        System.out.println("null");
    }


    public static void main(String ar[]) {
        LinkedListImpl impl = new LinkedListImpl();
        impl.insert(3);
        impl.insert(18);
        impl.insert(6);
        impl.insert(9);
        impl.insert(6);
        impl.insertAfter(3, 5);
        impl.insertAfter(5, 6);
        impl.insertAfter(5, 6);
        impl.insertHead(2);
        impl.insertHead(1);

        impl.printList();
        System.out.println(impl.size);
        System.out.println(impl.remove(3));
        impl.printList();
        System.out.println(impl.size);
        System.out.println(impl.removeAll(6));
        impl.printList();
        System.out.println(impl.size);
        System.out.println(impl.remove(36));
        System.out.println(impl.size);
        System.out.println(impl.search(7));
    }
}
