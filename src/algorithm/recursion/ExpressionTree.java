package algorithm.recursion;

import data.structures.BinaryTree;

/*
 *  Expression tree is a binary tree in which each internal node corresponds to operator and each leaf node corresponds to operand
 */
public class ExpressionTree {

	public static int calculateExpression(BinaryTree root) {
		if(root==null) return 0;
		if(root.type==operator)
			return calculateExpression(root.left) operator calculateExpression(root.right);
		else {
			// Its just an operand.
			return root.value;
		}
	}

}
