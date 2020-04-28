package catchexceptions.java.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesUnsortedLinkedListHashing {
	
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
		Map<Integer, Node> uniqueNodeMap = new HashMap<>();
		uniqueNodeMap.put(start.data, start);
		Node lastUnique = start;
		start = start.next;
		
		while(start != null) {
			if(!(uniqueNodeMap.containsKey(start.data))) {
				uniqueNodeMap.put(start.data, start);
				lastUnique.next = start;
				lastUnique = start;
			}
			start = start.next;
		}
	}

}
