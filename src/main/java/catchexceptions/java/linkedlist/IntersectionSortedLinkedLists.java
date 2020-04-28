/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package catchexceptions.java.linkedlist;

/**
 * @version 1.0, 12-Dec-2018
 * @author gourav
 */
public class IntersectionSortedLinkedLists {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.insertAtBegining(100);
		ll.insertAtBegining(90);
		ll.insertAtBegining(80);
		ll.insertAtBegining(70);
		ll.insertAtBegining(60);
		ll.insertAtBegining(50);
		ll.insertAtBegining(40);
		ll.insertAtBegining(30);
		ll.insertAtBegining(20);
		ll.insertAtBegining(10);

		LinkedList llSecond = new LinkedList();
		llSecond.insertAtBegining(90);
		llSecond.insertAtBegining(82);
		llSecond.insertAtBegining(70);
		llSecond.insertAtBegining(60);
		llSecond.insertAtBegining(57);
		llSecond.insertAtBegining(56);
		llSecond.insertAtBegining(40);
		llSecond.insertAtBegining(34);
		llSecond.insertAtBegining(22);
		llSecond.insertAtBegining(10);

		Node newHead = findIntersection(ll.head, llSecond.head);
		
		Node newStart = newHead;
		while (newStart != null) {
			System.out.println(newStart.data);
			newStart = newStart.next;
		}

	}

	static Node findIntersection(Node first, Node second) {
		Node newHead = null;
		
		if(first.data == second.data) {
			second = second.next;
		}
		
		while (first != null && second != null) {
			if (first.data <= second.data) {
				if (newHead == null) {
					newHead = first;
				}
				Node temp = first.next;
				if (first.next == null || first.next.data > second.data) {
					first.next = second;
				}
				first = temp;
			} else {
				if (newHead == null) {
					newHead = second;
				}
				Node temp = second.next;
				if (second.next == null || second.next.data > first.data) {
					second.next = first;
				}
				second = temp;
			}
		}
		return newHead;
	}

}
