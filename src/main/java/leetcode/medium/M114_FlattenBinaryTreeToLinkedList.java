package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 * 
 * @author shivam.maharshi
 */
public class M114_FlattenBinaryTreeToLinkedList {

  public static void main(String[] args) {
    // Balanced tree
    TreeNode ll = new TreeNode(3);
    TreeNode lr = new TreeNode(4);
    TreeNode l = new TreeNode(2);
    l.left = ll;
    l.right = lr;
    TreeNode rl = new TreeNode(6);
    TreeNode rr = new TreeNode(7);
    TreeNode r = new TreeNode(5);
    r.left = rl;
    r.right = rr;
    TreeNode root = new TreeNode(1);
    root.left = l;
    root.right = r;
    flatten(root);
    print(root);
    // Single node
    root = new TreeNode(1);
    flatten(root);
    print(root);
    // All left tree
    l = new TreeNode(2);
    root.left = l;
    l.left = new TreeNode(3);
    flatten(root);
    print(root);
    // All right tree
    r = new TreeNode(2);
    root.right = r;
    r.right = new TreeNode(3);
    flatten(root);
    print(root);
  }

  public static void print(TreeNode root) {
    while (root != null) {
      System.out.print(root.val + " ");
      root = root.right;
    }
    System.out.println();
  }

  public static void flatten(TreeNode root) {
    if (root != null)
      f(root);
  }

  public static TreeNode f(TreeNode root) {
    TreeNode tail = root, right = root.right;
    if (root.left != null) {
      root.right = root.left;
      root.left = null;
      tail = f(root.right);
    }
    if (right != null) {
      tail.right = right;
      tail = f(right);
    }
    return tail;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
