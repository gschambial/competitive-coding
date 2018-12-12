package com.catchexceptions.linkedlist;

public class LinkedListOperations {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		// Insert into LinkedList - O(n)
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);

		System.out.println("After 3 inserts");
		// Traverse LinkedList
		ll.traverse();

		ll.deleteAtBegining();

		System.out.println("After 1 delete");
		ll.traverse();
	}

}

class LinkedList {

	Node head;

	/**
	 * Method to insert a new node at beginning of LL
	 * 
	 * @param data
	 */
	void insertAtBegining(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	/**
	 * Method to traverse LL
	 */
	void traverse() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	/**
	 * Delete a node from beginning of LL
	 */
	void deleteAtBegining() {
		if (head != null) {
			head = head.next;
		}
	}

}

/**
 * Node of linked list
 * 
 * @author gourav
 *
 */
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}
