package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 * @author shivam.maharshi
 */
public class DeleteNodeInABST {

	public static void main(String[] args) {
		TreeNode leftChild = new TreeNode(2);
		TreeNode rightChild = new TreeNode(4);
		TreeNode l = new TreeNode(3);
		l.left = leftChild;
		l.right = rightChild;
		TreeNode rootNode = new TreeNode(7);
		TreeNode r = new TreeNode(6);
		r.right = rootNode;
		TreeNode root = new TreeNode(5);
		root.left = l;
		root.right = r;
		root = deleteNode(root, 3);
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		TreeNode node = get(root, key);
		TreeNode parent = getParent(root, key);
		if (root == null || node == null)
			return root;
		else if (parent == null) {
			TreeNode right = root.right;
			TreeNode result = root.left;
			root = root.left;
			while (root.right != null)
				root.right = root;
			root.right = right;
			return result;
		} else {
			boolean isLeft = parent.left != null && parent.left.val == node.val;
			if (node.left == null || node.right == null) {
				TreeNode nonNullNode = node.left != null ? node.left : node.right;
				if (isLeft)
					parent.left = nonNullNode;
				else
					parent.right = nonNullNode;
			} else {
				if (isLeft) {
					parent.left = node.left;
					parent = parent.left;
				} else {
					parent.right = node.left;
					parent = parent.right;
				}
				while (parent.right != null)
					parent = parent.right;
				parent.right = node.right;
			}
			return root;
		}
	}

	public static TreeNode getParent(TreeNode root, int key) {
		if (root == null || root.val == key)
			return null;
		else if ((root.left != null && root.left.val == key) || (root.right != null && root.right.val == key))
			return root;
		else if (root.val > key)
			return getParent(root.left, key);
		else
			return getParent(root.right, key);
	}

	public static TreeNode get(TreeNode root, int key) {
		if (root == null)
			return null;
		else if (root.val == key)
			return root;
		else if (root.val > key)
			return get(root.left, key);
		else
			return get(root.right, key);
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
