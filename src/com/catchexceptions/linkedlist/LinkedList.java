/**
 *  Copyright 2018 Jasper Infotech (P) Limited . All Rights Reserved.
 *  JASPER INFOTECH PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.catchexceptions.linkedlist;

/**
 * @version 1.0, 12-Dec-2018
 * @author gourav
 */
public class LinkedList {

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
     * Insert a node at given position and current node at that position is shifted rightindex
     * 
     * @param position
     * @param data
     */
    void insertAtPosition(int position, int data) {
        if (position == 1) {
            insertAtBegining(data);
        } else {
            Node temp = head;
            Node prev = head;
            int index = 0;
            while (temp != null) {
                if (position == index + 1) {
                    Node newNode = new Node(data);
                    prev.next = newNode;
                    newNode.next = temp;
                }
                index++;
                prev = temp;
                temp = temp.next;
            }
        }

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
    void deleteFromBegining() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Delete element at Position index = position-1
     */
    void deleteFromPosition(int position) {

        if (position == 1) {
            deleteFromBegining();
        }

        Node temp = head;
        Node prev = head;
        int index = 0;
        while (temp != null) {
            if (position == index + 1) {
                prev.next = temp.next;
                break;
            }
            index++;
            prev = temp;
            temp = temp.next;
        }
    }

    /**
     * Returns length of LL
     * 
     * @return
     */
    int getLength() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    int getLengthRecursively(Node temp) {
        if (temp == null) {
            return 0;
        }
        return 1 + getLengthRecursively(temp.next);

    }

    Node getFirstNodeReference() {
        return this.head;
    }

    Node getLastNodeReference() {
        Node start = head;
        while (start.next != null) {
            start = start.next;
        }
        return start;
    }

    Node getNodeAtNthPosition(Node start, int n) {
        int count = 1;
        while (count != n) {
            count++;
            start = start.next;
        }
        return start;
    }

}
