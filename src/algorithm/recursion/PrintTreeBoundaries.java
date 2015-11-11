package algorithm.recursion;

import data.structures.BinaryTree;

/**
 * Print the boundaries of a tree. I.e. its left nodes, then all its leaves and
 * then all its right nodes.
 * 
 * @author shivam.maharshi
 */
public class PrintTreeBoundaries {

	public static void print(BinaryTree<Integer> root) {
		printLeft(root);
		printLeaves(root);
		printRightInRev(root);
	}

	private static void printLeft(BinaryTree<Integer> root) {
		if (root != null) {
			// Not a leaf node.
			if (!(root.getLeft() == null && root.getRight() == null)) {
				System.out.println(root.getValue());
				printLeft(root.getLeft());
			}
		}
	}

	private static void printRightInRev(BinaryTree<Integer> root) {
		if (root != null) {
			// Not a leaf node.
			if (!(root.getLeft() == null && root.getRight() == null)) {
				printRightInRev(root.getRight());
				System.out.println(root.getValue());
			}
		}
	}

	private static void printLeaves(BinaryTree<Integer> root) {
		if (root != null) {
			printLeaves(root.getLeft());
			if (root.getLeft() == null && root.getRight() == null) {
				System.out.println(root.getValue());
			}
			printLeaves(root.getRight());
		}
	}

	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<Integer>(1);
		root.insertLeft(2);
		root.insertRight(3);
		root.getLeft().insertLeft(4);
		root.getLeft().insertRight(5);
		root.getRight().insertLeft(6);
		root.getRight().insertRight(7);
		root.getLeft().getLeft().insertLeft(8);
		root.getLeft().getLeft().insertRight(9);
		root.getLeft().getRight().insertLeft(10);
		root.getRight().getLeft().insertLeft(11);
		root.getRight().getRight().insertRight(12);
		PrintTreeBoundaries.print(root);
	}

}
