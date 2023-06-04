package doublylinkedlist;

public class DLinkedList {
    private Node head;
    private Node tail;
    int size;
    
    public DLinkedList() {
        head = new Node(0); // انشئ نود كاملة
        tail = new Node(0);
        head.next = null;
        head.prev = null;
        tail.next = null;
        tail.prev = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        if (head.next == null && tail.prev == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void addFirst(Node e) {
        if (isEmpty()) {
            head.next = e;
            tail.prev = e;
            e.next = tail;
            e.prev = head;
            size++;
        } else {
            e.next = head.next;
            head.next.prev = e;
            e.prev = head;
            head.next = e;
            size++;
        }
    }
    
    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        } else if(size ==1) {
            Node temp = null; // the element you want delete
            temp = head.next;
            head.next = null;
            tail.prev = null;
            temp.next = null;
            temp.prev = null;
            size--;
            return temp;
        } else {
            Node temp = null;
            temp = head.next;  // the element next head is the first element
            head.next.next.prev = head; 
            head.next = head.next.next;
            temp.next = null;
            temp.prev = null;
            size--;
            return temp;
        }
    }
    
    public void addLast(Node e) {
        if (isEmpty()) {
            head.next = e;
            tail.prev = e;
            e.next = tail;
            e.prev = head;
            size++;
        } else {
            e.next = tail;
            tail.prev.next = e;
            e.prev = tail.prev;
            tail.prev = e;
        }
    }
    
    public Node removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
           Node temp = null; // the element you want delete
            temp = tail.next;
            head.next = null;
            tail.prev = null;
            temp.next = null;
            temp.prev = null;
            size--;
            return temp; 
        } else {
            Node temp = null;
            temp = tail.prev;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            temp.next = null;
            temp.prev = null;
            size--;
            return temp;
        }
    }
    
    public void addAfter(int valBefore, Node e) { // add after valBefore
        if (isEmpty()) {
            System.out.println("The List is Empty");
        } else {
            // search for the value
            Node i = null;
            i = head.next; // the head is node now
            while (i.data != valBefore && i.next != tail) {                
                i = i.next;
            }
            if (i.data == valBefore) {
                Node t = null; // مؤشر ع العنصر الي بعد i
                t = i.next;
                e.next = t;
                e.prev = i;
                i.next = e;
                t.prev = e;
                size++;
            } else {
                System.out.println("The value does not exist");
            }
        }
    }
    
    public Node removeVal(int val) {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Node temp = null;
            temp = head.next;
            if (temp.data == val) {
                head.next = null;  
                tail.prev = null;
                temp.next = null;
                temp.prev = null;
                size--;
                return temp;
            } else {
                return null;
            }
        } else {
            Node temp = null; // the value
            Node i = null; // the element before
            Node t = null; // the element after
            temp = head.next;
            while (temp.data != val && temp.next != tail) {                
                temp = temp.next;
            }
            if (temp.data == val) {
                i = temp.prev;
                t = temp.next;
                i.next = t;
                t.prev = i;
                temp.next = null;
                temp.prev = null;
                size--;
                return temp;
            } else {
                return null;
            }
        }
    }
    
    public void search(int val) {
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node temp = null;
            temp = head.next;
            while (temp.data != val && temp.next != tail) {                
                temp = temp.next;
            }
            if (temp.data == val) {
                System.out.println("The value is exist");
            } else {
                System.out.println("The value does not exist");
            }
        }
    }
    
    public void printList() {
        if (isEmpty()) {
            System.out.println("The list is Empty");
        } else {
            Node temp = null;
            temp = head.next;
            while (temp != tail) {                
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}
