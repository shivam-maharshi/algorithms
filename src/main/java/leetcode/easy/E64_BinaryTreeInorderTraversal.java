package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal
 * 
 * @author shivam.maharshi
 */
public class E64_BinaryTreeInorderTraversal {

  public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();;
    if (root != null)
      parse(root, l);
    return l;
  }

  public static void parse(TreeNode root, List<Integer> l) {
    if (root.left != null)
      parse(root.left, l);
    l.add(root.val);
    if (root.right != null)
      parse(root.right, l);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}
