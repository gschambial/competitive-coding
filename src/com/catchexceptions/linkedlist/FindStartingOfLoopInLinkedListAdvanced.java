package com.catchexceptions.linkedlist;

public class FindStartingOfLoopInLinkedListAdvanced {

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

        Node node90 = ll.head;

        ll.insertAtBegining(100);
        ll.insertAtBegining(110);
        ll.insertAtBegining(120);

        //Get last node
        Node lastNode = ll.getLastNodeReference();

        //Create a loop by pointing last node to node60
        lastNode.next = node90;

        Node joiningNode = getJoiningNode(ll.head);
        System.out.println("Joining Node: " + joiningNode.data);

        Node crossingNode = findCrossingNode(ll.head, joiningNode);
        System.out.println("Starting Node of Loop: " + crossingNode.data);
    }

    /**
     * Using Floyd's Loop Detection method
     * 
     * @param slow
     * @return
     */
    static Node getJoiningNode(Node slow) {
        Node fast = slow;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    /**
     * Returns no of nodes involved in Loop
     * 
     * @param joiningNode
     * @return
     *//*
       static int getLengthOfLoop(Node joiningNode) {
        Node start = joiningNode;
        int count = 0;
        do {
            count++;
            start = start.next;
        } while (start != joiningNode);
        return count;
       }*/

    /**
     * Start 2 pointers one from HEAD and another from JOINING NODE, where they meet is starting point of loop
     * 
     * @param fromHead
     * @param nodeAtNthPosition
     * @return
     */
    static Node findCrossingNode(Node fromHead, Node nodeAtNthPosition) {
        while (fromHead != nodeAtNthPosition) {
            fromHead = fromHead.next;
            nodeAtNthPosition = nodeAtNthPosition.next;
        }
        return fromHead;
    }
}
