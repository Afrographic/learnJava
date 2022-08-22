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

    public static void main(String[] args) {

     
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(55);
        Node node6 = new Node(55);

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

        // Linking the nodes for dll2
        Node head2 = new Node(1);
        head2.setNext(node1);
        node1.setNext(node2);
        node1.setPrev(head2);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setPrev(node3);
        node4.setNext(node5);
        node5.setPrev(node4);
        node5.setNext(node6);
        node6.setPrev(node5);

      
        DoublyLinkedList dll2 = new DoublyLinkedList(head2);

        System.out.println("size 1 "+dll.getTotalNode());
        System.out.println("size 2 "+dll2.getTotalNode());
        System.out.println("Are equals " + equals(dll, dll2));

    }
}
