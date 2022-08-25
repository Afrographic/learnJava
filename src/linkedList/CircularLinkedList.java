package linkedList;

public class CircularLinkedList {

    private Node head = null;

    public void setHead(Node head) {
        this.head = head;
    }

    CircularLinkedList(Node head) {
        this.head = head;
    }

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

    public int getSize() {
        if (head == null)
            return 0;
        int size = 1;
        Node initialHead = head;
        Node current = head;
        while (current.next != initialHead) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void printCll() {
        Node initialHead = head;
        Node current = head;
        while (current.next != initialHead) {
            System.out.print(current.getData() + "->");
            current = current.next;
        }
        System.out.print(current.getData());
        System.out.println();
    }

    Node getLastNode() {
        Node initialHead = head;
        Node current = head;
        while (current.next != initialHead) {
            current = current.next;
        }
        return current;
    }

    public CircularLinkedList[] split() {

        Node current = head;
        Node next = head;
        for (int i = 0; i <= (this.getSize() / 2) - 2; i++) {
            next = next.getNext();
        }
        Node headForSecondList = next.getNext();
        next.setNext(current);
        CircularLinkedList cll1 = new CircularLinkedList(null);
        cll1.setHead(current);
        System.out.println("First Circular linked list");
        cll1.printCll();

        // Building the second circular list
        Node next2 = headForSecondList;
        while(next2.getNext()!=head){
            next2 = next2.getNext();
        }
        next2.setNext(headForSecondList);
        CircularLinkedList cll2 = new CircularLinkedList(headForSecondList);
        System.out.println("Second Circular linked list");
        cll2.printCll();

        CircularLinkedList[] cllArray = { cll1, cll2 };
        return cllArray;
    }

    public static void main(String[] args) {

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);
        Node i = new Node(8);
        Node j = new Node(8);
        // Connecting the nodes
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(f);
        f.setNext(g);
        g.setNext(h);
        h.setNext(i);
        i.setNext(j);
        j.setNext(a);
        // Circular Linked List instance
        CircularLinkedList cll = new CircularLinkedList(a);
        cll.printCll();
        cll.split();

        // System.out.println(cll.getLastNode().getData());

    }
}
