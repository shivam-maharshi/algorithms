package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Print all distinct string permutations for a string that has duplicate
 * characters.
 * 
 * @author shivam.maharshi
 */
public class StringPermutationsWithDuplicateCharacters {
  
  public static void main(String[] args) {
    print("aab");
  }

  public static void print(String s) {
    Map<Character, Integer> cm = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (cm.containsKey(c))
        cm.put(c, cm.get(c) + 1);
      else
        cm.put(c, 1);
    }
    print("", cm, s.length());
  }

  public static void print(String res, Map<Character, Integer> cm, int l) {
    if (res.length() == l) {
      System.out.println(res);
      return;
    }

    Set<Entry<Character, Integer>> es = cm.entrySet();
    Iterator<Entry<Character, Integer>> it = es.iterator();
    while (it.hasNext()) {
      Entry<Character, Integer> e = it.next();
      if (e.getValue() > 0) {
        e.setValue(e.getValue() - 1);
        print(res + e.getKey(), cm, l);
        e.setValue(e.getValue() + 1); // Backtrack.
      }
    }
  }

}
