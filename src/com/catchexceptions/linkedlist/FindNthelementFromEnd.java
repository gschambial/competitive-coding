/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.catchexceptions.linkedlist;

/**
 * @version 1.0, 12-Dec-2018
 * @author gourav
 */
public class FindNthelementFromEnd {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtBegining(10);
        ll.insertAtBegining(20);
        ll.insertAtBegining(30);
        ll.insertAtBegining(40);
        ll.insertAtBegining(50);
        ll.insertAtBegining(60);
        ll.insertAtBegining(70);
        ll.insertAtBegining(80);
        ll.insertAtBegining(90);
        ll.insertAtBegining(100);   
        System.out.println(getNthNodeFromEnd(ll.head, 1));
    }
    
    static int getNthNodeFromEnd(Node lead, int n) {
    	Node follow = lead;
    	int count = 0;
    	while(lead != null) {
    		lead = lead.next;
    		count++;
    		if(count > n) {
    			follow = follow.next;
    		}
    	}
    	return follow.data;
    }

}
