package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Print all string permutations which doesn't have any duplicates characters.
 * 
 * @author shivam.maharshi
 */
public class StringPermutationsWithoutDuplicates {

  public static void main(String[] args) {
    print("abc");
  }

  public static void print(String s) {
    List<Character> set = new ArrayList<Character>();
    for (char c : s.toCharArray())
      set.add(c);
    print("", set);
  }

  public static void print(String s, List<Character> cl) {
    if (cl.isEmpty())
      System.out.println(s);

    for (int i = 0; i < cl.size(); i++) {
      char c = cl.get(i);
      cl.remove(i); // Remove from set as it is used.
      print(s + c, cl);
      cl.add(i, c); // Backtrack
    }
  }

}
