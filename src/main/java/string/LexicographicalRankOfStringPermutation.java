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
    System.out.println(rankUsingList("cab"));
    System.out.println(rankUsingConstantSizedArray("cab"));
  }

  // O(n(log(n))) way better than O(n!) brute force.
  public static int rankUsingList(String s) {
    int rank = 0;
    // O(n).
    int fact = fact(s.length());
    List<Character> cl = new ArrayList<Character>();
    for (char c : s.toCharArray())
      cl.add(c);
    Collections.sort(cl);
    for (int i = 0; i < s.length(); i++) { // O(n)
      fact = fact / (s.length() - i);
      int crank = getRank(s.charAt(i), cl); // O(log(n))
      rank += crank * fact;
      cl.remove(crank);
    }
    return rank + 1;
  }
  
  // Complexity is O(n) because rank is found in constant time.
  public static int rankUsingConstantSizedArray(String s) {
    int rank = 0;
    // Creates rank array with O(256*n) complexity.
    int[] cc = createRankArray(s);
    // O(n).
    int fact = fact(s.length());
    for (int i = 0; i < s.length(); i++) { // O(n)
      fact = fact / (s.length() - i);
      int crank = getRank(s.charAt(i), cc); // O(log(n))
      rank += crank * fact;
    }
    return rank + 1;
  }
  
  public static int[] createRankArray(String s) {
    int[] cc = new int[256];
    for (int i=s.length()-1; i>=0; i--) {
      int ci = (int)(s.charAt(i));
      int cCount = 1;
      for(int j=0; j < ci; j++)
        cCount += cc[j];
      cc[ci] = cCount;
    }
    return cc;
  }

  // Complexity is O(n), but can be improved to O(log(n)) by binary search.
  public static int getRank(char c, List<Character> cl) {
    for (int i = 0; i < cl.size(); i++)
      if (cl.get(i) == c)
        return i;
    return 0;
  }
  
  // Complexity is O(256) which is constant.
  public static int getRank(char c, int[] cc) {
    return cc[c] - 1;
  }

  // Can be improved to O(n) by using DP.
  public static int fact(int n) {
    if (n <= 1)
      return 1;
    return n * fact(n - 1);
  }

}
