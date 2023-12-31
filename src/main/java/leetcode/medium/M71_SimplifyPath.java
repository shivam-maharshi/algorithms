package leetcode.medium;

import java.util.Stack;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/simplify-path
 * 
 * @author shivam.maharshi
 */
public class M71_SimplifyPath extends TestCase {

  @Test
  public static void test() {
    assertEquals("/", simplifyPath("/.."));
    assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    assertEquals("/c", simplifyPath("/c/"));
    assertEquals("/c", simplifyPath("/../../c/"));
    assertEquals("/c", simplifyPath("../../c/"));
    assertEquals("/a/c", simplifyPath("/a/./b/../c/"));
    assertEquals("/a/d", simplifyPath("/a/./b/../c/../d/"));
    assertEquals("/a/d", simplifyPath("/a/./b/../////////c/..//d/"));
    assertEquals("/a/d", simplifyPath("/a/./b/..///  ///  ///    c/..//   d/"));
    assertEquals("/", simplifyPath("/a/./b/../c/../../../../../../"));
  }

  public static String simplifyPath(String path) {
    if (path == null || path.length() == 0)
      return "/";

    String[] s = path.split("/");
    Stack<String> ss = new Stack<>();

    for (int i = 0; i < s.length; i++) {
      if (s[i].trim().equals("..") && !ss.isEmpty())
        ss.pop();
      else if (!s[i].trim().equals(".") && !s[i].trim().isEmpty() && !s[i].trim().equals(".."))
        ss.push(s[i].trim());
    }
    String r = "";

    while (!ss.isEmpty())
      r = "/" + ss.pop() + r;

    return r.isEmpty() ? "/" : r;
  }

}
