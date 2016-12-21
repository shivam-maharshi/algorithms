package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/anagrams/
 * 
 * @author shivam.maharshi
 */
public class GroupAnagrams {

  public static void main(String[] args) {
    print(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> m = new HashMap<>();
    for (String s : strs) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String cs = Arrays.toString(c);
      if (m.containsKey(cs)) {
        m.get(cs).add(s);
      } else {
        List<String> l = new ArrayList<String>();
        l.add(s);
        m.put(cs, l);
      }
    }
    return new ArrayList<>(m.values());
  }

  public static void print(List<List<String>> l) {
    for (List<String> ll : l) {
      for (String n : ll) {
        System.out.print(n + " ");
      }
      System.out.println();
    }
  }

}
