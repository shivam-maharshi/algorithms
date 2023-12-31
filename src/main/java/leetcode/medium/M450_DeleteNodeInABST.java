package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/delete-node-in-a-bst
 * 
 * @author shivam.maharshi
 */
public class M450_DeleteNodeInABST {

  public static void main(String[] args) {
    TreeNode ll = new TreeNode(2);
    TreeNode lr = new TreeNode(4);
    TreeNode l = new TreeNode(3);
    l.left = ll;
    l.right = lr;
    TreeNode rr = new TreeNode(7);
    TreeNode r = new TreeNode(6);
    r.right = rr;
    TreeNode root = new TreeNode(5);
    root.left = l;
    root.right = r;
    root = deleteNode(root, 3);
  }

  public static TreeNode deleteNode(TreeNode root, int key) {
    TreeNode n = get(root, key);
    TreeNode p = getParent(root, key);
    if (root == null || n == null)
      return root;
    else if (p == null) {
      TreeNode right = root.right;
      TreeNode res = root.left;
      root = root.left;
      while (root.right != null)
        root.right = root;
      root.right = right;
      return res;
    } else {
      boolean isLeft = p.left!=null && p.left.val == n.val;
      if (n.left == null || n.right == null) {
        TreeNode nonNullNode = n.left != null ? n.left : n.right;
        if (isLeft)
          p.left = nonNullNode;
        else
          p.right = nonNullNode;
      } else {
        if (isLeft) {
          p.left = n.left;
          p = p.left;
        } else {
          p.right = n.left;
          p = p.right;
        }
        while (p.right != null)
          p = p.right;
        p.right = n.right;
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
