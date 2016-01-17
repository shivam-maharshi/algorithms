package recursion;

import data.structures.BinaryTree;

/**
 * Given a binary tree, find the maximum path sum. The path may start and end at
 * any node in the tree.
 * 
 * @author shivam.maharshi
 */
public class MaximumPathSumBinaryTree {

	// This function returns overall maximum path sum in 'res'
	// And returns max path sum going through root.
	int findMaxUtil(BinaryTree<Integer> root, Integer res) {
		// Base Case
		if (root == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxUtil(root.left, res);
		int r = findMaxUtil(root.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + root.value, root.value);

		// Max Top represents the sum when the Node under
		// consideration is the root of the max sum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + root.value);

		res = Math.max(res, max_top); // Store the Maximum Result.

		return max_single;
	}

	// Returns maximum path sum in tree with given root
	int findMaxSum(BinaryTree root) {
		// Initialize result
		int res = Integer.MIN_VALUE;

		// Compute and return result
		findMaxUtil(root, res);
		return res;
	}

}
