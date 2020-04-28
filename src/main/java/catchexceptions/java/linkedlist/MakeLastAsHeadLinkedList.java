package catchexceptions.java.linkedlist;

public class MakeLastAsHeadLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		ll.insertAtBegining(50);
		ll.insertAtBegining(999);

		System.out.println("Original List: ");
		ll.traverse();

		makeLastAsHead(ll.head, ll);

		System.out.println("List after change: ");
		ll.traverse();
	}
	
	static void makeLastAsHead(Node slow, LinkedList ll) {
		Node fast = slow.next;
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		Node temp = ll.head;
		ll.head = fast;
		fast.next = temp;
		slow.next = null;
	}


}
