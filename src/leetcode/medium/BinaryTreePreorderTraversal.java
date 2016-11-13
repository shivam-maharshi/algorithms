package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * @author shivam.maharshi
 */
public class BinaryTreePreorderTraversal {

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    if (root != null)
      preorder(root, l);
    return l;
  }

  public static void preorder(TreeNode n, List<Integer> l) {
    l.add(n.val);
    if (n.left != null)
      preorder(n.left, l);
    if (n.right != null)
      preorder(n.right, l);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}
