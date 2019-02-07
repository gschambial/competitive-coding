package com.catchexceptions.linkedlist;

public class FindValueatNthIndex {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		
		System.out.println("Find element at Nth position ");
		System.out.println(getNth(ll.head, 3));
		
		System.out.println("Find element at Nth position recursively");
		System.out.println(getNthRecursively(ll.head, 3, 0));
	}
	
	static int getNth(Node head, int n) {
		
		Node start = head;
		int count = 0;
		while (start != null) {
			Node currentNode = start;
			count++;
			if(count == n) {
				return currentNode.data;
			}
			start = currentNode.next;
		}
		return 0;
	}
	
	static int getNthRecursively(Node pointer, int n, int count) {
		if(null != pointer) {
			count++;
			if(count == n) {
				return pointer.data;
			}
			return getNthRecursively(pointer.next, n, count);
		}
		return 0;
	}

}
