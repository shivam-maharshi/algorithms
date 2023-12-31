package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/longest-common-prefix
 * 
 * @author shivam.maharshi
 */
public class E14_LongestCommonPrefix extends TestCase {

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
    E14_LongestCommonPrefix l = new E14_LongestCommonPrefix();
    assertEquals(l.longestCommonPrefix(new String[]{"aasasd", "aassds"}), "aas");
    assertEquals(l.longestCommonPrefix(new String[]{}), "");
  }
  
}
