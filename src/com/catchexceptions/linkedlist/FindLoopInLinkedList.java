package com.catchexceptions.linkedlist;

public class FindLoopInLinkedList {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		ll.insertAtBegining(50);
		ll.insertAtBegining(60);
		
		Node node60 = ll.head;
		
		ll.insertAtBegining(70);
		ll.insertAtBegining(80);
		ll.insertAtBegining(90);
		ll.insertAtBegining(100);
		ll.insertAtBegining(110);
		ll.insertAtBegining(120);
		
		//Get last node
		Node lastNode = ll.getLastNodeReference();
		
		//Create a loop by pointing last node to node60
		lastNode.next = node60;
		
		System.out.println(isLoopPresent(ll.head));
	}
	
	static boolean isLoopPresent(Node slow) {
		Node fast = slow;
		boolean isLoopPresent = false;
		while(fast != null) {
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
			slow = slow.next;
			if(slow == fast) {
				isLoopPresent = true;
				break;
			}
		}
		return isLoopPresent;
	}

}
