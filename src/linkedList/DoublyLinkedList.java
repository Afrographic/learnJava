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

    DoublyLinkedList(Node head) {
        this.head = head;
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

    public boolean equals(DoublyLinkedList dll1, DoublyLinkedList dll2) {
        if (dll1.getTotalNode() != dll2.getTotalNode()) {
            return false;
        }
        while (dll1.head != null) {

        }
        boolean equal = false;
        return equal;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);

        // Linking the nodes
        head.setNext(node1);
        node1.setNext(node2);
        node1.setPrev(head);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setPrev(node3);

        DoublyLinkedList dll = new DoublyLinkedList(head);
        System.out.println(dll.getMiddleNode().getData());

    }
}
