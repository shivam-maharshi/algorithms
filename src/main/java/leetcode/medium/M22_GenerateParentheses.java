package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: https://leetcode.com/problems/generate-parentheses
 * 
 * @author shivam.maharshi
 */
public class M22_GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    generate(n, n, "", res);
    return res;
  }

  public void generate(int no, int nc, String s, List<String> res) {
    if (no == 0 && nc == 0) {
      res.add(s);
      return;
    }
    if (no > 0)
      generate(no - 1, nc, s + "(", res);
    if (nc > no)
      generate(no, nc - 1, s + ")", res);
  }

}
