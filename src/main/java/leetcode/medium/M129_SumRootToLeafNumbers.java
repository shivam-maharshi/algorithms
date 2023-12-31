package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/sum-root-to-leaf-numbers
 * 
 * @author shivam.maharshi
 */
public class M129_SumRootToLeafNumbers extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, sumNumbers(null));
    TreeNode root = new TreeNode(1);
    assertEquals(1, sumNumbers(root));
    TreeNode l = new TreeNode(2);
    TreeNode r = new TreeNode(3);
    root.left = l;
    root.right = r;
    assertEquals(25, sumNumbers(root));
    TreeNode ll = new TreeNode(4);
    l.left = ll;
    assertEquals(137, sumNumbers(root));
  }

  public static int sumNumbers(TreeNode root) {
    if (root == null)
      return 0;
    List<Integer> l = new ArrayList<>();
    sumNumbers(root, l, root.val);
    int r = 0;
    for (Integer n : l)
      r += n;
    return r;
  }

  public static void sumNumbers(TreeNode root, List<Integer> res, int n) {
    if (root.left == null && root.right == null) {
      res.add(n);
      return;
    }
    if (root.left != null)
      sumNumbers(root.left, res, 10 * n + root.left.val);
    if (root.right != null)
      sumNumbers(root.right, res, 10 * n + root.right.val);
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
