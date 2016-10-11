package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Find the lexicographical rank of a given string containing no duplicate
 * characters.
 * 
 * @author shivam.maharshi
 */
public class LexicographicalRankOfStringPermutation {

  public static void main(String[] args) {
    System.out.println(rank("acbd"));
  }

  // O(n^2) way better than O(n!) brute force.
  public static int rank(String s) {
    int rank = 0;
    List<Character> cl = new ArrayList<Character>();
    for (char c : s.toCharArray()) {
      cl.add(c);
    }
    Collections.sort(cl);
    for (int i = 0; i < s.length(); i++) { // O(n)
      int crank = getRank(s.charAt(i), cl); // O(log(n))
      rank += crank * fact(s.length() - i - 1); // O(n).
      cl.remove(crank);
    }
    return rank + 1;
  }

  // Complexity is O(n), but can be improved to O(log(n)) by binary search.
  public static int getRank(char c, List<Character> cl) {
    for (int i = 0; i < cl.size(); i++)
      if (cl.get(i) == c)
        return i;
    return 0;
  }

  // Can be improved to O(n) by using DP.
  public static int fact(int n) {
    if (n <= 1)
      return 1;
    return n * fact(n - 1);
  }

}
