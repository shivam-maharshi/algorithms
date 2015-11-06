package data.structures;

public class BinaryTree<V> {

	BinaryTree<V> right;
	BinaryTree<V> left;
	V value;

	public BinaryTree(V value) {
		this.value = value;
	}

	public BinaryTree<V> insertLeft(V value) {
		this.left = new BinaryTree<V>(value);
		return this.left;
	}

	public BinaryTree<V> insertRight(V value) {
		this.right = new BinaryTree<V>(value);
		return this.right;
	}

	/*
	 * Check if the given binary tree is balanced or not. Best approach is to
	 * find the difference between maxHieght and minHieght.
	 */
	public boolean isBalanced1() {
		int minHieght = Math.min(minHeight(this.left), minHeight(this.right)) + 1;
		int maxHieght = Math.max(maxHeight(this.left), maxHeight(this.right)) + 1;
		return maxHieght - minHieght < 2;
	}

	private int maxHeight(BinaryTree<V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.max(maxHeight(node.right), maxHeight(node.left));
		}
	}

	private int minHeight(BinaryTree<V> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + Math.min(minHeight(node.left), minHeight(node.right));
		}
	}

	/*
	 * Another approach is to find height and return -1 if subtree is not
	 * balanced.
	 */
	public boolean isBalanced2(BinaryTree<V> node) {
		return getHeight(node) == -1 ? false : true;
	}

	public int getHeight(BinaryTree<V> node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if (leftHeight == -1 || rightHeight == -1) {
			return -1;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int[] array = new int[6];
	public static int index = 0;

	public static void inOrderTraversal(BinaryTree<Integer> node) {
		if (node == null)
			return;
		inOrderTraversal(node.left);
		array[index] = node.value;
		System.out.println("index : " + index + " :: value : " + node.value);
		index++;
		inOrderTraversal(node.right);
	}

	public static boolean isValidBinarySearchTree(BinaryTree<Integer> root) {
		inOrderTraversal(root);

		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidBinarySearchTree(BinaryTree<Integer> node, int min, int max) {

		if (node == null) {
			return true;
		}

		return node.value >= min && node.value < max && isValidBinarySearchTree(node.left, min, node.value)
				&& isValidBinarySearchTree(node.right, node.value + 1, max);

	}

	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<Integer>(100);
		root.insertRight(150);
		BinaryTree<Integer> left = root.insertLeft(25);
		left.insertLeft(12);
		// System.out.println("Max Height : " + root.maxHeight(root));
		// System.out.println("Min Height : " + root.minHeight(root));
		// System.out.println("Is tree balanced : " + root.isBalanced1());
		// System.out.println(root.isValidBinarySearchTree(root));
		System.out.println(isValidBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

}
