package doublylinkedlist;

public class DoublyLinkedList {

    public static void main(String[] args) {
        DLinkedList d = new DLinkedList();
        d.addFirst(new Node(10));
        d.addLast(new Node(100));
        d.addAfter(10, new Node(20));
        d.printList();
        d.search(100);
        d.search(1000);
//        d.removeFirst();
//        d.removeLast();
//        d.removeVal(20);
        d.printList();
    }
    
}
