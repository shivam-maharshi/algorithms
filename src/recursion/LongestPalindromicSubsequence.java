package recursion;

/**
 * Find the length of the biggest palindromic subsequence in a given string.
 * Note that this is subsequence not substring.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * 
 * @author shivam.maharshi
 */
public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    String s = "bbabcbcab";
    System.out.println(lps(s, 0, s.length() - 1));
  }

  public static int lps(String s, int l, int h) {
    if (h < l)
      return 0;
    if (h == l)
      return 1;

    int len = -1;

    int th = getPair(s, l, h);
    if (th != -1) {
      len = Math.max(len, Math.max(lps(s, l, h - 1), Math.max(lps(s, l + 1, th - 1) + 2, lps(s, l + 1, h))));
      print(l, h, th);
    } else {
      len = Math.max(len, Math.max(lps(s, l + 1, h), lps(s, l, h - 1)));
      print_r(l, h);
    }

    return len;
  }

  public static void print_r(int l, int h) {
    System.out.print("f(" + l + "," + h + ") = ");
    System.out.print("f(" + l + "," + (h - 1) + ")");
    System.out.print(", f(" + (l + 1) + "," + h + ")");
    System.out.println();
  }

  public static void print(int l, int h, int th) {
    System.out.print("f(" + l + "," + h + ") = ");
    System.out.print("f(" + l + "," + (h - 1) + ")");
    System.out.print(", f(" + (l + 1) + "," + h + ")");
    System.out.print(", f(" + (l + 1) + "," + (th - 1) + ")");
    System.out.println();
  }

  public static int getPair(String s, int l, int h) {
    int res = -1;
    while (h > l) {
      if (s.charAt(l) != s.charAt(h))
        h--;
      else {
        res = h;
        break;
      }
    }
    return res;
  }

}
