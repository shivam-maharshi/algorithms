package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Finding the longest substring of a string that occurs at least twice
 * 
 * Link: https://en.wikipedia.org/wiki/Longest_repeated_substring_problem
 * 
 * @author shivam.maharshi
 */
public class LongestRepeatedSubstring {

  public static void main(String[] args) {
    LongestRepeatedSubstring lrs = new LongestRepeatedSubstring();
    System.out.println(lrs.lrs("abdecdabdece")); // Output: ab
  }

  /*
   * The idea is to first create a suffix tree for a string in the first pass
   * increasing the counts of every node which is traversed during add. Then
   * again search for all the suffix string in this tree but break if a node has
   * count less than two since it would signify that node being present in the
   * word only once. O(n^2) solution.
   */
  public String lrs(String s) {
    SuffixTree st = new SuffixTree();
    StringBuilder suffix = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      st.add(suffix.toString());
      suffix.deleteCharAt(0);
    }

    String lngstSub = "", ls;
    suffix = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      ls = st.search(suffix.toString());
      if (ls.length() > lngstSub.length())
        lngstSub = ls;
      suffix.deleteCharAt(0);
    }

    return lngstSub;
  }

  class SuffixTree {
    int count = 0;
    Map<Character, SuffixTree> m = new HashMap<Character, SuffixTree>();

    public void add(String s) {
      SuffixTree node = this;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!node.m.containsKey(c)) {
          node.m.put(c, new SuffixTree());
        }
        node = node.m.get(c);
        node.count++;
      }
    }

    // Returns the prefix from the input string that has count more than 2.
    public String search(String s) {
      SuffixTree node = this;
      int i = 0;
      for (i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (!node.m.containsKey(c) || node.m.get(c).count < 2) {
          break;
        }
        node = node.m.get(c);
      }
      return s.substring(0, i);
    }

  }

}
