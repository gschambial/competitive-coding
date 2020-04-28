package catchexceptions.java.linkedlist;

public class LinkedListOperations {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        // Insert into LinkedList - O(n)
        ll.insertAtBegining(10);
        ll.insertAtBegining(20);
        ll.insertAtBegining(30);
        System.out.println("After inserting: 10, 20, 30");
        // Traverse LinkedList
        ll.traverse();

        ll.deleteFromBegining();
        System.out.println("After deleting: 30");
        ll.traverse();

        ll.insertAtBegining(30);
        System.out.println("After inserting: 30");
        ll.traverse();

        ll.deleteFromPosition(2);
        System.out.println("After delete from position 2: 20");
        ll.traverse();

        ll.insertAtPosition(2, 20);
        System.out.println("After inserting 20 at Position 2");
        ll.traverse();

        System.out.println("Length of LL is: " + ll.getLength());

        Node temp = ll.head;
        System.out.println("Length of LL is: " + ll.getLengthRecursively(temp));

    }

}


