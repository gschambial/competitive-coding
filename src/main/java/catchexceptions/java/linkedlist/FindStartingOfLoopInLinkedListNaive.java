package catchexceptions.java.linkedlist;

public class FindStartingOfLoopInLinkedListNaive {

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

        Node startingNodeOfLoop = getStartingNodeOfLoop(joiningNode, ll.head);

        System.out.println("Starting Node: " + startingNodeOfLoop.data);
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
     * 1. Start traversing from joiningNode and come back to joining node. 2. Do this for each node of LL one by one. 3.
     * During each traversal, if you find the node from step 2, that is the starting node of loop.
     * 
     * @param joiningNode
     * @param nodeToBeMatched
     * @return
     */
    static Node getStartingNodeOfLoop(Node joiningNode, Node nodeToBeMatched) {
        Node start = joiningNode;
        do {
            if (start.data == nodeToBeMatched.data) {
                return nodeToBeMatched;
            }
            start = start.next;
        } while (start != joiningNode);

        return getStartingNodeOfLoop(joiningNode, nodeToBeMatched.next);
    }

}
