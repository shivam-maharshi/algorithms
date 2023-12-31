package leetcode.medium;

import java.util.Stack;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 
 * @author shivam.maharshi
 */
public class M331_VerifyPreorderSerializationOfABinaryTree extends TestCase {

  @Test
  public void test() {
    assertEquals(true, isValidSerialization("#"));
    assertEquals(true, isValidSerialization("9,#,#"));
    assertEquals(false, isValidSerialization("#,#"));
    assertEquals(false, isValidSerialization("#,1"));
    assertEquals(false, isValidSerialization("1,#"));
    assertEquals(false, isValidSerialization("9,#,#,1"));
    assertEquals(true, isValidSerialization("9,#,92,#,#"));
    assertEquals(true, isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
  }

  public static boolean isValidSerialization(String preorder) {
    if (preorder == null || preorder.isEmpty())
      return false;
    String[] ss = preorder.split(",");
    Stack<String> s = new Stack<>();
    for (int i = 0; i < ss.length; i++) {
      s.push(ss[i]);
      while (s.size() >= 3 && s.get(s.size() - 1).equals("#") && s.get(s.size() - 2).equals("#")
          && !s.get(s.size() - 3).equals("#")) {
        s.pop();
        s.pop();
        s.pop();
        s.push("#");
      }
    }
    return s.size() == 1 && s.pop().equals("#");
  }

}