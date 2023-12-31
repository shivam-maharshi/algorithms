package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Link:
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node
 * 
 * @author shivam.maharshi
 */
public class M116_PopulatingNextRightPointersInEachNode {

  public static void connect(TreeLinkNode root) {
    if (root == null)
      return;
    Queue<TreeLinkNode> q = new LinkedList<>();
    root.next = null;
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      TreeLinkNode n = q.poll();
      if (n != null) {
        n.next = q.peek();
        q.add(n.left);
        q.add(n.right);
        if (q.peek() == null)
          q.add(null);
      }
    }
  }

  @SuppressWarnings("unused")
  private static class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }
}
