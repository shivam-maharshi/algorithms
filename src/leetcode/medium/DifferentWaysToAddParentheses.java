package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/different-ways-to-add-parentheses/
 * 
 * @author shivam.maharshi
 */
public class DifferentWaysToAddParentheses {

  public static void main(String[] args) {
    List<Integer> l = diffWaysToCompute("11*222+1");
    for (int i = 0; i < l.size(); i++)
      System.out.print(l.get(i) + " ");
  }

  public static List<Integer> diffWaysToCompute(String input) {
    List<Integer> r = new ArrayList<Integer>();
    r = parse(input, 0, input.length());
    Collections.sort(r);
    return r;
  }

  public static List<Integer> parse(String s, int l, int h) {
    List<Integer> r = new ArrayList<>();
    for (int i = l; i < h; i++) {
      char c = s.charAt(i);
      if (c == '-' || c == '+' || c == '*')
        r.addAll(compute(parse(s, l, i), parse(s, i + 1, h), c));
    }
    if (r.size() == 0)
      r.add(Integer.valueOf(s.substring(l, h)));
    return r;
  }

  public static List<Integer> compute(List<Integer> a, List<Integer> b, char c) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < a.size(); i++)
      for (int j = 0; j < b.size(); j++) {
        if (c == '+')
          l.add(a.get(i) + b.get(j));
        else if (c == '-')
          l.add(a.get(i) - b.get(j));
        else
          l.add(a.get(i) * b.get(j));
      }
    return l;
  }

}
