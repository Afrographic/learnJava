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
    private Node tail = null;

    public Node getTail() {
        return tail;
    }

    public void setTail(Node node) {
        this.tail = node;
    }

    public Node getHead() {
        return head;
    }

    public void addNode(Node node) {
        tail.setNext(node);
        this.setTail(node);
    }

    public void remove(Node node) {
        Node current = head;
        while (current.getNext() != node) {
            current = current.getNext();
        }
        current.setNext(node.getNext());
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public SinglyLinkedList(Node head) {
        this.head = head;
        this.tail = this.getlastNodeFromStarterNode(head);
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
        Node tmpHead = head;
        while (tmpHead.getNext() != null) {
            System.out.print(tmpHead.getData() + " -> ");
            tmpHead = tmpHead.getNext();
        }
        System.out.print(tmpHead.getData());
        System.out.println("");
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

    public SinglyLinkedList clone() {
        return new SinglyLinkedList(head);
    }

    public SinglyLinkedList reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        return new SinglyLinkedList(previous);
    }

    public SinglyLinkedList rotate(Node node) {
        // Get the last Node
        Node lastNode = getlastNodeFromStarterNode(node);
        Node oldHead = head;
        head = node.getNext();
        node.setNext(null);
        lastNode.setNext(oldHead);
        return new SinglyLinkedList(head);
    }

    Node getlastNodeFromStarterNode(Node starterNode) {
        Node starter = starterNode;
        while (starter.getNext() != null) {
            starter = starter.getNext();
        }
        return starter;
    }

    public static void main(String[] args) {
        // Create the nodes
        Node a = new Node(11);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(44);

        // Connecting the nodes
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);

        // Init SinglyLinkedList
        SinglyLinkedList sll = new SinglyLinkedList(a);

        // sll.remove(c);
        long startTime = System.nanoTime();
        sll = sll.rotate(c);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time " + (endTime - startTime));

        sll.printNodes();

        // sll.printNodes();
    }

}
