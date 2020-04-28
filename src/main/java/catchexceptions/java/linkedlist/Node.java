/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package catchexceptions.java.linkedlist;

/**
 * Node of linked list
 * 
 * @author gourav
 */
public class Node {
    int  data;
    Node next;

    Node(int data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
    
    
}
