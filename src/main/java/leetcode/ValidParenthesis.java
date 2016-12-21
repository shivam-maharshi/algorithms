package leetcode;

import java.util.Stack;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/valid-parentheses/
 * 
 * @author shivam.maharshi
 */
public class ValidParenthesis extends TestCase {

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for(char c : s.toCharArray()) {
      if(c=='(' || c=='{' || c=='[')
        stack.push(c);
      else {
        if(stack.empty())
          return false;
        Character p = stack.pop();
        char v = p.charValue();
        if((v=='(' && c!=')') || (v=='{' && c!='}') || (v=='[' && c!=']'))
          return false;
      }
   }
  return stack.isEmpty();
}
  
  @Test
  public void test() {
    ValidParenthesis vp = new ValidParenthesis();
    //assertEquals(true, vp.isValid(""));
    //assertEquals(true, vp.isValid("[{((()))}]"));
    assertEquals(false, vp.isValid("([)]"));
  }

}
