package linkedList;

public class DoublyLinkedList {
    private static class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void setPrev(Node node) {
            this.prev = node;
        }

        public void setData(int data) {
            this.data = data;
        }

    }

    private Node head;
    private Node tail;

    DoublyLinkedList(Node head) {
        this.head = head;
        this.tail = head.getNext();
    }

    public int getTotalNode() {
        int totalNode = 0;
        Node temp = head;
        while (temp != null) {
            totalNode++;
            temp = temp.getNext();
        }

        return totalNode;
    }

    public Node getMiddleNode() {
        int size = getTotalNode();
        Node middleNode = head;
        for (int i = 0; i <= (size / 2) - 1; i++) {
            middleNode = middleNode.getNext();
        }
        if (size % 2 == 0) {
            return middleNode.getPrev();
        } else {
            return middleNode;
        }
    }

    public static boolean equals(DoublyLinkedList dll1, DoublyLinkedList dll2) {
        System.out.println("Size1 " + dll1.getTotalNode());
        System.out.println("Size2 " + dll2.getTotalNode());
        if (dll1.getTotalNode() != dll2.getTotalNode()) {
            System.out.println("Stop here");
            return false;
        }
        while (dll1.head != null) {
            if (dll1.head != dll2.head) {
                return false;
            }
            dll1.head = dll1.head.next;
            dll2.head = dll2.head.next;
        }

        return true;
    }

    public void remove(Node node) {
        node.getPrev().setNext(node.getNext());
    }

    public void add(Node node) {
        tail.setNext(node);
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getData()+"->");
            current = current.getNext();
        }
    }

    public static void main(String[] args) {

     
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
     

        // Linking the nodes for dll1
        Node head = new Node(1);
        head.setNext(node1);
        node1.setNext(node2);
        node1.setPrev(head);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setPrev(node3);

        DoublyLinkedList dll = new DoublyLinkedList(head);
    
        dll.print();
        dll.remove(node2);
        System.out.println("Removed");
        dll.print();

 

    }
}
