package leetcode.easy;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/palindrome-number
 * 
 * Avoid using any extra space.
 * 
 * @author shivam.maharshi
 */
public class E9_PalindromeNumber extends TestCase {
  
  public boolean isPalindrome(int x) {
   if (x < 0)
     return false;
   
   int len = getLen(x); // 6 // 5
   for(int i=1; i<=len/2; i++) { // 1 - 3 // 1 - 2
     if(getDigit(x, i) != getDigit(x, len + 1 - i)) { // 1-6, 2-5, 3-4 // 1-5, 2-4
       return false;
     }
   }
    return true;
  }
  
  public int getDigit(int x, int digit) {
    int res = 0;
    for(int i=0; i<digit; i++) {
      res = x % 10;
      x = x/10;
    }
    return res;
  }
  
  public int getLen(int x) {
    int len = 0;
    while(x != 0) {
      x = x/10;
      len++;
    }
    return len;
  }
  
  @Test
  public void tests() {
    E9_PalindromeNumber pn = new E9_PalindromeNumber();
    assertEquals(true, pn.isPalindrome(52125));
    assertEquals(true, pn.isPalindrome(-52125));
    assertEquals(false, pn.isPalindrome(53125));
    assertEquals(true, pn.isPalindrome(521125));
    assertEquals(false, pn.isPalindrome(522125));
  }

}
