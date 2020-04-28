package catchexceptions.java.linkedlist;

public class RemoveDuplicatesUnsortedLinkedListUsingSorting {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(7);
		ll.insertAtBegining(3);
		ll.insertAtBegining(6);
		ll.insertAtBegining(2);
		ll.insertAtBegining(8);

		System.out.println("Original List: ");
		ll.traverse();

		Node last = ll.getLastNodeReference();
		
		Node newStart = partition(ll.head, last);

		System.out.println("Partition Node: " + newStart.data);

		System.out.println("List after sorting: ");
	
		while(newStart != null) {
			System.out.println(newStart.data);
			newStart = newStart.next;
		}

	}

	static Node getPartitionNode(Node slow) {
		Node fast = slow.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	static Node partition(Node start, Node end) {

		if (start == end) {
			return start;
		}

		Node middleNode = getPartitionNode(start);
		
		System.out.println("Middle Node: " + middleNode.data);
		
		Node startSecond = middleNode.next;
		middleNode.next = null;
		
		System.out.println("First Half: " + start.data + ", " + middleNode.data);
		System.out.println("Second Half: " + startSecond.data + ", " + end.data);

		Node first = partition(start, middleNode);
		Node second = partition(startSecond, end);
		return merge(first, second);
	}

	static Node merge(Node first, Node second) {

		Node newStart = null;
		// Node temp = first;
		while (first != null && second != null) {
			if (first.data <= second.data) {
				// Start of the newly merged node
				if (newStart == null) {
					newStart = first;
				}
				Node temp = first;
				first = first.next;
				if (first == null || first.data > second.data) {
					temp.next = second;
				}
			} else {
				// Start of the newly merged node
				if (newStart == null) {
					newStart = second;
				}
				Node temp = second;
				second = second.next;
				if (second == null || second.data > first.data) {
					temp.next = first;
				}
			}
		}
		return newStart;
	}

}
