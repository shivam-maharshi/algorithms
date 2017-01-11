package interview.amazon;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.careercup.com/question?id=5713295928459264
 * 
 * @author shivam.maharshi
 */
public class PathToFormTargetNumber extends TestCase {

  @Test
  public static void test() {
    Tree root = new Tree(3);
    Tree l = new Tree(4);
    Tree r = new Tree(5);
    Tree ll = new Tree(6);
    Tree lr = new Tree(7);
    Tree rl = new Tree(8);
    Tree rr = new Tree(9);
    r.r = rr;
    r.l = rl;
    l.r = lr;
    l.l = ll;
    root.l = l;
    root.r = r;
    assertEquals(true, traverse(root, new int[] { 3 }, 0));
    assertEquals(true, traverse(root, new int[] { 4 }, 0));
    assertEquals(true, traverse(root, new int[] { 5 }, 0));
    assertEquals(true, traverse(root, new int[] { 6 }, 0));
    assertEquals(true, traverse(root, new int[] { 7 }, 0));
    assertEquals(true, traverse(root, new int[] { 8 }, 0));
    assertEquals(true, traverse(root, new int[] { 9 }, 0));
    assertEquals(true, traverse(root, new int[] { 3, 4 }, 0));
    assertEquals(true, traverse(root, new int[] { 3, 4, 6 }, 0));
    assertEquals(true, traverse(root, new int[] { 4, 6 }, 0));
    assertEquals(false, traverse(root, new int[] { 10 }, 0));
    assertEquals(false, traverse(root, new int[] { 3, 6 }, 0));
    assertEquals(false, traverse(root, new int[] { 4, 9 }, 0));
  }

  public static boolean traverse(Tree root, int[] n, int i) {
    if (i >= n.length)
      return true;
    if (root == null)
      return false;
    if (root.v == n[i] && (traverse(root.l, n, i + 1) || traverse(root.r, n, i + 1)))
      return true;
    if (root.v == n[0] && (traverse(root.l, n, 1) || traverse(root.r, n, 1)))
      return true;
    return traverse(root.l, n, 0) || traverse(root.r, n, 0);
  }

  public static class Tree {
    int v;
    Tree r;
    Tree l;

    public Tree(int v) {
      this.v = v;
    }
  }

}
