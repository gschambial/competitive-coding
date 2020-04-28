package catchexceptions.java.linkedlist;

public class RemoveDuplicatesSortedLinkedList {
	
		public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		ll.insertAtBegining(50);
		ll.insertAtBegining(999);
		ll.insertAtBegining(999);
		
		System.out.println("Original List: ");
		ll.traverse();
		
		removeDuplicate(ll.head);
		
		System.out.println("List after removing duplicates: ");
		ll.traverse();
		
	}
		
	static void removeDuplicate(Node start) {
		Node next = start.next;
		while(next != null) {
			if(start.data != next.data) {
				start.next = next;
				start = next;
			}
			next = next.next;
		}
		start.next = null;
	}

}
