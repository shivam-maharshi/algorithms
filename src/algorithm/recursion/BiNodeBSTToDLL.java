package algorithm.recursion;

/* 
 * Convert a Binary Search Tree in BiNode representation to Doubly Linked List, in place.
 */

public class BiNodeBSTToDLL {

	public static BiNode getNode(BiNode root, boolean isLeft) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		BiNode leftTail = getNode(root.left, true);
		BiNode rightHead = getNode(root.right, false);
		merge(root, leftTail, rightHead);
		if (isLeft)
			return rightHead != null ? rightHead : root;
		else {
			return leftTail != null ? leftTail : root;
		}
	}

	private static void merge(BiNode root, BiNode leftTail, BiNode rightHead) {
		root.left = leftTail;
		if (leftTail != null)
			leftTail.right = root;
		root.right = rightHead;
		if (rightHead != null)
			rightHead.left = root;
	}

	public static void main(String[] args) {
		BiNode zero = new BiNode(0, null, null);
		BiNode one = new BiNode(1, zero, null);
		BiNode three = new BiNode(3, null, null);
		BiNode two = new BiNode(2, one, three);
		BiNode six = new BiNode(6, null, null);
		BiNode five = new BiNode(5, null, six);
		BiNode four = new BiNode(4, two, five);
		BiNode result = BiNodeBSTToDLL.getNode(four, false);
		System.out.println(result);
	}
}

class BiNode {
	int value;
	BiNode left;
	BiNode right;

	public BiNode(int value, BiNode left, BiNode right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}
