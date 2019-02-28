/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.catchexceptions.linkedlist;

/**
 * Node of linked list
 * 
 * @author gourav
 */
public class CircularNode {
    int  data;
    CircularNode next;

    CircularNode(int data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
    
    
}
