package catchexceptions.java.linkedlist;

public class BinaryTreeToCircularLinkedList {

	static TreeNode head = null;

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(12);
		TreeNode t3 = new TreeNode(15);
		TreeNode t4 = new TreeNode(25);
		TreeNode t5 = new TreeNode(30);
		TreeNode t6 = new TreeNode(36);

		t1.left = t2;
		t1.right = t3;

		t2.left = t4;
		t2.right = t5;

		t3.left = t6;

		TreeNode head = makeCircularList(t1);

		TreeNode ptr = head;

		do {
			System.out.println(ptr.data);
			ptr = ptr.right;
		} while (ptr != head);
	}

	static TreeNode makeCircularList(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode left = makeCircularList(root.left);
		TreeNode right = makeCircularList(root.right);

		// To get right and left when there is only single node
		root.left = root.right = root;

		// Adding Left List and root
		TreeNode leftPart = add(left, root);

		// Adding Left List + root to right
		return add(leftPart, right);

	}

	static TreeNode add(TreeNode left, TreeNode right) {

		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}

		// Getting leftMost and rightMost node by using Left List's starting point
		TreeNode rightMostNode = left.left;
		TreeNode leftMostNode = rightMostNode.right;

		// Attaching rightList to end i.e. rightMost node of leftList
		rightMostNode.right = right;
		right.left = rightMostNode;

		right.right = leftMostNode;
		leftMostNode.left = right;

		return leftMostNode;
	}

}
