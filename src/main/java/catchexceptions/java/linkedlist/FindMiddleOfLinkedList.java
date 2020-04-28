package catchexceptions.java.linkedlist;

public class FindMiddleOfLinkedList {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		ll.insertAtBegining(50);
		ll.insertAtBegining(60);
		ll.insertAtBegining(70);
		ll.insertAtBegining(80);
		ll.insertAtBegining(90);
		ll.insertAtBegining(100);
		ll.insertAtBegining(110);
		ll.insertAtBegining(120);
		
		System.out.println(findMiddle(ll.head));
	}
	
	static int findMiddle(Node slow) {
		Node fast = slow;
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		return slow.data;
	}

}
