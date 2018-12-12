package com.catchexceptions.linkedlist;

public class LinkedListOperations {

	Node head;

	public static void main(String[] args) {

		LinkedListOperations llOperations = new LinkedListOperations();

		// Initialize head
		llOperations.head = new Node(-1);

		// Insert into LinkedList - O(n)
		llOperations.insertAtBegining(10);
		llOperations.insertAtBegining(20);
		llOperations.insertAtBegining(30);

		// Traverse LinkedList
		llOperations.traverse();
	}

	/**
	 * Method to insert a new node at beginning of LL
	 * 
	 * @param data
	 */
	void insertAtBegining(int data) {
		Node node = new Node(data);
		node.next = head.next;
		head.next = node;
	}

	/**
	 * Method to traverse LL
	 */
	void traverse() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
			System.out.println(temp.data);

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
