package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
 * 
 * @author shivam.maharshi
 */
public class M117_PopulatingNextRightPointersInEachNodeII {

  public void connect(TreeLinkNode root) {
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
        if (n.left != null)
          q.add(n.left);
        if (n.right != null)
          q.add(n.right);
        if (q.peek() == null)
          q.add(null);
      }
    }
  }

  class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }

}
