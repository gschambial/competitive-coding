package com.catchexceptions.linkedlist;

public class QuickSort {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(3);
		ll.insertAtBegining(6);
		ll.insertAtBegining(22);
		ll.insertAtBegining(65);
		ll.insertAtBegining(6);
		ll.insertAtBegining(18);
		ll.insertAtBegining(17);

		System.out.println("Original List: ");
		ll.traverse();

		quicksort(ll.head, ll.getLastNodeReference());

		System.out.println("Sorted List: ");
		ll.traverse();
	}

	static void quicksort(Node head, Node end) {
		if (head == end) {
			return;
		}
		Node partNodePrev = partition(head, end);
		
		if(partNodePrev == null) {
			return;
		}
		
		quicksort(head, partNodePrev);
		quicksort(partNodePrev.next, end);

	}

	static Node partition(Node head, Node end) {
		if(head == null || end == null) {
			return null;
		}
		Node prev = null;
		Node start = head;
		Node pivot = end;
		while (start != pivot) {
			if (start.data < pivot.data) {
				if (prev == null) {
					prev = head;
				} else {
					prev = prev.next;
				}
				Integer tmp = prev.data;
				prev.data = start.data;
				start.data = tmp;
			}
			start = start.next;
		}

		// swap pivot
		Integer tmp = pivot.data;
		if (prev != null) {
			pivot.data = prev.next.data;
			prev.next.data = tmp;
		} else {
			pivot.data = head.data;
			head.data = tmp;
			prev = head;
		}
		return prev;

	}

}
