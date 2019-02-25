package com.catchexceptions.linkedlist;

public class SwapNodesLinkedList {

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

		System.out.println("Let's swap nodes with data: 20, 50");

		swap(ll.head, 20, 999, ll);

		System.out.println("List after swapping: ");
		ll.traverse();
	}

	static void swap(Node start, int firstVal, int secondVal, LinkedList ll) {
		Node firstPrev = null, secondPrev = null, first = null, second = null;
		while (start != null) {

			if (start.data == firstVal && first == null) {
				first = start;
			} else if (first == null) {
				firstPrev = start;
			}
			if (start.data == secondVal && second == null) {
				second = start;
			} else if (second == null) {
				secondPrev = start;
			}
			start = start.next;
		}

		if (first != null && second != null) {

			// Exchange next pointers always
			Node temp = first.next;
			first.next = second.next;
			second.next = temp;

			if (firstPrev != null && secondPrev != null) {
				firstPrev.next = second;
				secondPrev.next = first;
			} else if (firstPrev == null) {
				ll.head = second;
				secondPrev.next = first;
			} else if (secondPrev == null) {
				ll.head = first;
				firstPrev.next = second;
			}
			// secondPrev pointer shall always change

		} else {
			System.out.println("Both nodes not found...");
		}
	}

}
