package recursion;

/**
 * Return true if a string follows a given wild card pattern.
 * 
 * Link: http://www.geeksforgeeks.org/wildcard-pattern-matching/
 * 
 * @author shivam.maharshi
 */
public class WildPatternMatching {

  public static void main(String[] args) {
    System.out.println(match("babc", "?a**********b****c"));
  }

  // * means any occurrences & ? means exactly one occurrence.
  public static boolean match(String s, String p) {
    return match(s, 0, p, 0);
  }

  // Non DP approach hence less efficient.
  public static boolean match(String s, int i, String p, int j) {
    if (i == s.length() && j == p.length())
      return true;

    if (i > s.length() || j > p.length())
      return false;

    if (j < p.length() && p.charAt(j) == '*')
      return match(s, i, p, j + 1) || match(s, i + 1, p, j);

    else if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'))
      return match(s, i + 1, p, j + 1);

    return false;
  }

}
