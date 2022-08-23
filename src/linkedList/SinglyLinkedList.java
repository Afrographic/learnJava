package linkedList;

public class SinglyLinkedList {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head = null;

    public Node getHead() {
        return head;
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    // Update methods
    // public void addFirst(int e) {
    // head = new Node<>(e);
    // if (size == 0) {
    // tail = head;
    // }
    // size++;
    // }
    public void printNodes() {
        if (head == null)
            return;
        Node tmpHead = head;
        while (tmpHead.getNext() != null) {

            System.out.print(tmpHead.getData() + " -> ");

            tmpHead = tmpHead.getNext();
        }
        System.out.print(tmpHead.getData());
    }

    public int getSize() {
        if (head == null)
            return 0;
        int sizeList = 1;
        Node temp = head;
        while (temp.getNext() != null) {
            sizeList++;
            temp = temp.getNext();
        }
        return sizeList;
    }

    public SinglyLinkedList reverse() {
        int temp = 0;
        Node traverse = head;
        while (traverse.next != null) {
            temp = traverse.getData();
            traverse.setData(traverse.next.getData());
            traverse.next.setData(temp);
            traverse = traverse.next;
        }
        return this;
    }

    public static void main(String[] args) {
        // Create the nodes
        Node a = new Node(11);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        // Connecting the nodes
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        // Init SinglyLinkedList
        SinglyLinkedList sll = new SinglyLinkedList(a);

        sll = sll.reverse();

        sll.printNodes();
    }

}
