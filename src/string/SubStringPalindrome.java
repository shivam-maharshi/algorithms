package string;

/**
 * Find the number of distinct substrings that are palindrome as well in O(n^2).
 * 
 * @author shivam.maharshi
 */
public class SubStringPalindrome {

  public static void main(String[] args) {
    System.out.println(palindrome("aabaa"));
  }

  public static int palindrome(String str) {
    java.util.Map<String, Void> m = new java.util.HashMap<String, Void>();
    for (int i = 0; i < str.length(); i++) {
      String s = "";
      m.put("" + str.charAt(i), null);

      int l = i;
      int h = i + 1;
      // For even
      while (l >= 0 && h < str.length()) {
        if (str.charAt(l) == str.charAt(h)) {
          s = str.charAt(l) + s + str.charAt(h);
          m.put(s, null);
        } else {
          break;
        }
        l--;
        h++;
      }

      l = i - 1;
      h = i + 1;
      s = "" + str.charAt(i);
      // For Odd
      while (l >= 0 && h < str.length()) {
        if (str.charAt(l) == str.charAt(h)) {
          s = str.charAt(l) + s + str.charAt(h);
          m.put(s, null);
        } else {
          break;
        }
        l--;
        h++;
      }

    }
    return m.size();
  }

}
