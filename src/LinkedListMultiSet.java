
// Node is only used inside the LinkedList class, so we define it in the same file;
// there can only be one public class in a file, but there can also be non-public classes.
class Node {
    int item;
    Node next;
    Node(int item) {
        this.item = item;
    }
}


public class LinkedListMultiSet extends MultiSet {

    // a linked list initially is empty
    private Node front;
    private int size;


    public void add(int item) {
        // Add a node to the front of the linked list
        Node newNode =  new Node(item);
        newNode.next = front;
        front = newNode;
        size += 1;
    }

    public void remove(int item) {
        Node prev = null;
        Node curr = front;
        while (curr != null) {
            if (curr.item == item) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    front = curr.next;
                }
                size -= 1;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int item) {
        Node curr = front;
        while (curr != null) {
            if (curr.item == item) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return front == null;
    }


    public int count(int item) {
        int count = 0;
        Node curr = front;
        while (curr != null) {
            if (curr.item == item) {
                count ++;
            }
            curr = curr.next;
        }
        return count;
    }

    public int size() {
        return size;
    }
}
