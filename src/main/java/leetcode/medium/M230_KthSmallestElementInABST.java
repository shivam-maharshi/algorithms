package leetcode.medium;

import java.util.Stack;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst
 * 
 * @author shivam.maharshi
 */
public class M230_KthSmallestElementInABST extends TestCase {

  @Test
  public static void test() {
    TreeNode l = new TreeNode(1), r = new TreeNode(3), n = new TreeNode(2);
    n.left = l;
    n.right = r;
    assertEquals(2, kthSmallest(n, 2));
  }

  public static int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> s = new Stack<>();
    TreeNode r = root;
    while (!(s.isEmpty() && r==null)) {
      if (r != null) {
        s.push(r);
        r = r.left;
      } else {
        r = s.pop();
        k--;
        if (k == 0)
          return r.val;
        r = r.right;
      }
    }
    return -1;
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int v) {
      this.val = v;
    }

  }

}
