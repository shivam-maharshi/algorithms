package recursion;

import data.structures.BinaryTree;

/**
 * Find the lowest common ancestor.
 * 
 * @author shivam.maharshi
 */
public class LowestCommonAncestor {

  /*
   * Keep going into subtree unless you find at least one value and then return
   * that node. A place where you receive one node from left and another from
   * right you know that is the parent.
   */
  public static BinaryTree<Integer> lca(BinaryTree<Integer> root, int a, int b) {
    if (root == null)
      return null;
    if (root.value == a || root.value == b)
      return root;
    BinaryTree<Integer> l = lca(root.left, a, b);
    BinaryTree<Integer> r = lca(root.right, a, b);
    if (l != null && r != null)
      return root;
    else if (l != null)
      return l;
    else if (r != null)
      return r;
    else
      return null;
  }

  public static void main(String[] args) {
    BinaryTree<Integer> root = new BinaryTree<Integer>(9);
    BinaryTree<Integer> right = root.insertRight(150);
    BinaryTree<Integer> left = root.insertLeft(25);
    BinaryTree<Integer> lr = left.insertRight(12);
    BinaryTree<Integer> ll = left.insertLeft(10);
    BinaryTree<Integer> rl = right.insertLeft(20);
    BinaryTree<Integer> rr = right.insertRight(30);
    lr.insertRight(50);
    System.out.println(lca(root, 12, 20).value);
  }

}
