
package doublylinkedlist;

public class Node {
    public int data;
    public Node next;
    public Node prev;
    
    public Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
    
    
    @Override
    public String toString() {
        return String.format("The data is: %d ", data);
    }
}
