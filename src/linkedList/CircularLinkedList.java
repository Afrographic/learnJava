package linkedList;

public class CircularLinkedList {


    public static void main(String[] args) {
      
        Ol a = new Ol("ol");
        Ol b = Ol.copy(a);
        b.setName("fuck big ass");

        System.out.println(a.getName());
        System.out.println(b.getName());
    }
}


