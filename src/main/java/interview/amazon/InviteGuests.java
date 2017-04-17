package interview.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Given a list of guess figure out the people who should absolutely not be
 * invited to avoid reducing candies for the main host.
 * 
 * @author shivam.maharshi
 */
public class InviteGuests extends TestCase {
  
  @Test
  public static void childNotInvited() {
    String[] s = { "Guest,Inviter,CandyBrought,CandyConsumed",
        "Ivan,Cass,6,4", "Kale,Ivan,1,6",
        "Leon,Ivan,2,5", "Mark,Ivan,1,6" };
    assertEquals(3, getBlacklistedGuests(s).size());
  }

  public static void main(String[] args) {
    String[] s = { "Guest,Inviter,CandyBrought,CandyConsumed",
                    "Dole,Adam,2,3", "Greg,Dole,6,2" };
    List<String> l = getBlacklistedGuests(s);
    for (String ll : l)
      System.out.println(ll);
  }

  public static List<String> getBlacklistedGuests(String[] s) {
    List<String> l = new ArrayList<>();
    // First entry is the header.
    if (s == null || s.length == 0 || s.length == 1)
      return l;
    Node root = populateTree(s);
    getBlacklistedGuests(root, l);
    return l;
  }

  public static int getBlacklistedGuests(Node root, List<String> l) {
    for (String child : root.child.keySet())
      root.total += getBlacklistedGuests(root.child.get(child), l);
    if (root.total < 0) {
      l.add(root.name);
      return 0;
    } else
      return root.total;
  }

  public static Node populateTree(String[] s) {
    Map<String, Node> m = new HashMap<>();
    String[] a = s[1].split(",");
    String root = a[1];
    m.put(a[1], new Node(a[1], 0));
    for (int i = 1; i < s.length; i++) {
      a = s[i].split(",");
      Node n = new Node(a[0], Integer.parseInt(a[2]) - Integer.parseInt(a[3]));
      m.put(n.name, n);
      m.get(a[1]).child.put(n.name, n);
    }
    return m.get(root);
  }

  static class Node {
    String name;
    int val;
    int total;
    Map<String, Node> child;

    public Node(String name, int value) {
      this.name = name;
      this.val = value;
      this.total = value;
      this.child = new HashMap<>();
    }

  }

}
