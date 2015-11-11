package algorithm.recursion;

import data.structures.BinaryTree;

// Print the boundaries of a tree. I.e. its left nodes, then all its leaves and then all its right nodes.
public class PrintTreeBoundaries {

	public static void print() {

	}

	private static void printLeft(BinaryTree<Integer> root) {
		while (root != null) {
			System.out.println(root.getValue());
			root = root.getLeft();
		}
	}

	private static void printRightInRev(BinaryTree<Integer> root) {
		while (root != null) {
			root = root.getRight();
			System.out.println(root.getValue());
		}
	}

	private static void printLeaves(BinaryTree<Integer> root) {
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(root.getValue());
			return;
		}
		
	}

}
