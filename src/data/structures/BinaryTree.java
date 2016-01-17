package data.structures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<V> {

	public BinaryTree<V> right;
	public BinaryTree<V> left;
	public V value;

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

	public static boolean isComplete(BinaryTree<Integer> root) {
		if (root == null) {
			return true;
		}
		return isComplete(root, 0) < 0 ? false : true;
	}

	/**
	 * This is my algorithm. A little complex but more efficient.
	 */
	private static int isComplete(BinaryTree<Integer> root, int level) {
		if (level < 0) {
			return level;
		}
		if (root == null) {
			return level - 1;
		}
		int l = isComplete(root.left, level + 1);
		int r = isComplete(root.right, level + 1);
		if (l < r || l - r >= 2) {
			return -1;
		} else {
			return l;
		}
	}

	/**
	 * Do level order traversal of a tree and insert -1 for nulls. If there are
	 * -1s in the middle of the array / queue then it is not a complete tree
	 * otherwise if there are no -1s or all are at the end then it is a complete
	 * tree.
	 */
	public static boolean isComplete1(BinaryTree<Integer> root) {
		boolean res = true;
		Queue<BinaryTree<Integer>> queue = new LinkedList<BinaryTree<Integer>>();
		int[] a = new int[(int) Math.pow(2, root.getHeight(root) + 1)];
		Arrays.fill(a, Integer.MIN_VALUE);
		queue.add(root);
		int i = 0;
		while (!queue.isEmpty()) {
			BinaryTree<Integer> node = queue.remove();
			if (node != null) {
				a[i] = node.value;
				queue.add(node.left);
				queue.add(node.right);
			} else {
				a[i] = Integer.MIN_VALUE;
			}
			i++;
		}
		boolean minOcc = false;
		for (i = 0; i < a.length; i++) {
			if (minOcc && a[i] != Integer.MIN_VALUE) {
				return false;
			} else if (a[i] == Integer.MIN_VALUE) {
				minOcc = true;
			}
		}
		return res;
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

	/**
	 * This will not work. This is incorrect approach.
	 */
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
		BinaryTree<Integer> right = root.insertRight(150);
		BinaryTree<Integer> left = root.insertLeft(25);
		left.insertRight(12);
		left.insertLeft(12);
		right.insertLeft(12);
		right.insertRight(13);
		// System.out.println("Max Height : " + root.maxHeight(root));
		// System.out.println("Min Height : " + root.minHeight(root));
		// System.out.println("Is tree balanced : " + root.isBalanced1());
		// System.out.println(root.isValidBinarySearchTree(root));
		// System.out.println(isValidBinarySearchTree(root, Integer.MIN_VALUE,
		// Integer.MAX_VALUE));
		System.out.println(isComplete(root));
		System.out.println(isComplete1(root));
	}

	public BinaryTree<V> getRight() {
		return right;
	}

	public void setRight(BinaryTree<V> right) {
		this.right = right;
	}

	public BinaryTree<V> getLeft() {
		return left;
	}

	public void setLeft(BinaryTree<V> left) {
		this.left = left;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
