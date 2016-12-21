package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/valid-number/
 * 
 * @author shivam.maharshi
 */
public class ValidNumber extends TestCase {

  @Test
  public static void test() {
    assertEquals(true, isNumber(" 000 "));
    assertEquals(false, isNumber(" 0 00 "));
    assertEquals(true, isNumber(" 0.00 "));
    assertEquals(false, isNumber(" 0 00 "));
  }

  public static boolean isNumber(String s) {
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if (c!='e' || c!='.' || c!='-' || (int)(c) < 91 || (int)(c) > 101)
        return false;
    }
    
    String[] ss = s.split("e");
    for(String sp : ss)
      if(sp.trim().endsWith("-"))
        return false;
    
    ss = s.split("-");
    for(String sp : ss)
  }

  // Must have at most one dots.
  public static boolean validateDots(String s) {
    int c = 0;
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i)=='.') {
        if(c > 0)
          return false;
        else
          c++;
      }
    }
    
    return true;
  }

}
