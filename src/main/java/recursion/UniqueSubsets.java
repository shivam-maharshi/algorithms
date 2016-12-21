package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string with repeated characters, print all the unique subsets only.
 * 
 * @author shivam.maharshi
 */
public class UniqueSubsets {

  public static void main(String[] args) {
    print("aab"); // {a, aa, aab, ab, b} 
  }

  public static void print(String s) {
    Map<Character, Integer> co = new HashMap<>();
    List<Character> cl = new ArrayList<>();
    for (Character c : s.toCharArray()) {
      if (co.get(c) != null)
        co.put(c, co.get(c) + 1);
      else {
        co.put(c, 1);
        cl.add(c);
      }
    }
    print(s, "", 0, cl, co);
  }

  public static void print(String s, String r, int in, List<Character> cl, Map<Character, Integer> co) {
    if (in == s.length())
      return;
    
    for (int i = in; i < cl.size(); i++) {
      char c = cl.get(i);
      if (co.get(c) > 0) {
        co.put(c, co.get(c) - 1);
        System.out.println( r + c );
        print(s, r + c, i, cl, co);
        co.put(c, co.get(c) + 1);
      }
    }
  }

}
