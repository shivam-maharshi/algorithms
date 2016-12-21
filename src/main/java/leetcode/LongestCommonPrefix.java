package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/longest-common-prefix/
 * 
 * @author shivam.maharshi
 */
public class LongestCommonPrefix extends TestCase {

  public String longestCommonPrefix(String[] strs) {
    String res = "";
    if(strs.length>0)
      res = strs[0];
    for(int i=1; i<strs.length; i++) {
      res = getCommonPrefix(res, strs[i]);
      if (res.equals(""))
        break;
    }
    return res;
  }
  
  public String getCommonPrefix(String a, String b) {
    String res = "";
    for(int i=0; i<Math.min(a.length(), b.length()); i++) {
      if(a.charAt(i)==b.charAt(i))
        res += a.charAt(i);
      else
        break;
    }
    return res;
  }
  
  @Test
  public void test() {
    LongestCommonPrefix l = new LongestCommonPrefix();
    assertEquals(l.longestCommonPrefix(new String[]{"aasasd", "aassds"}), "aas");
    assertEquals(l.longestCommonPrefix(new String[]{}), "");
  }
  
}
