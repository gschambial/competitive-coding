package com.catchexceptions.linkedlist;

public class CheckPalindromeLinkedList {
	
		public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(10);
		ll.insertAtBegining(20);
		ll.insertAtBegining(30);
		ll.insertAtBegining(40);
		ll.insertAtBegining(50);
		ll.insertAtBegining(999);
		ll.insertAtBegining(50);
		ll.insertAtBegining(40);
		ll.insertAtBegining(30);
		ll.insertAtBegining(20);
		ll.insertAtBegining(10);
		
		Node middleNode = getMiddleNode(ll.head);
		
		System.out.println("Middle Node:" + middleNode.data);
			
		Node endNode = reverseSubList(null, middleNode, middleNode.next);
		
		System.out.println("Starting Node of Reversed List: " + endNode.data);
		
		System.out.println("Is Palindrome: " + isPalindrome(ll.head, endNode, middleNode));
		
		Node backToStartingNode = reverseSubList(null, endNode, endNode.next);
		
		System.out.println("Back to Stating Node: " + backToStartingNode.data);
		
		ll.traverse();
	}
	
	static Node getMiddleNode(Node slow) {
		Node fast = slow;
		while(fast != null) {
			slow = slow.next;
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
			}
		}
		return slow;
	}
	
	static Node reverseSubList(Node prev, Node current, Node next) {
		
		//System.out.println("prev : " + prev + " current: " + current + " next: " + next);
		
		if(next == null) {
			current.next = prev;
			return current;
		}
		
		current.next = prev;
		prev = current;
		current = next;
		next = current.next;
		
		
		
		return reverseSubList(prev, current, next);
	}
	
	static boolean isPalindrome(Node firstHalfStart, Node secondHalfStart, Node middleNode) {
		while(secondHalfStart != null) {
			//System.out.println("secondHalfStart : " + secondHalfStart.data);
			//System.out.println("firstHalfStart : " + firstHalfStart.data);
			if(secondHalfStart.data != firstHalfStart.data) {
				return false;
			}
			firstHalfStart = firstHalfStart.next;
			secondHalfStart = secondHalfStart.next;
		}
		
		return true;
	}

}
