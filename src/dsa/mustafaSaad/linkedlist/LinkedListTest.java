package dsa.mustafaSaad.linkedlist;

public class LinkedListTest {
    public static void testDoubleLinkedList() {
        System.out.println("Test double linked list");

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

    public static void testSingleLinkedList() {
        System.out.println("Test single linked list");

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


    public static void main(String[] args) {
        testSingleLinkedList();
        System.out.println("\n**********************************\n");
        testDoubleLinkedList();

    }
}
