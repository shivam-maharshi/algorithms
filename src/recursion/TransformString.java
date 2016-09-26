package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Transform one string into other by updating one character at a time such that
 * all the strings in transition must be present in the dictionary.
 * 
 * Strings have the same lenght.
 * 
 * @author shivam.maharshi
 */
public class TransformString {

  static Map<Integer, List<Integer>> g = new HashMap<>();

  public static int transform(String[] words, int s, String d) {
    populateGraph(words);
    boolean[] visited = new boolean[words.length];
    visited[s] = true;
    List<String> path = new ArrayList<String>();
    int traverse = traverse(words, s, d, visited, path);
    for (String p : path) {
      System.out.print(p + " => ");
    }
    return traverse;
  }

  /*
   * This is a DFS solution which is less optimal than a BFS solution which will
   * return minimum path.
   */
  public static int traverse(String[] words, int s, String d, boolean[] visited, List<String> path) {
    if (words[s].equals(d))
      return 0;

    for (int i = 0; i < g.get(s).size(); i++) {
      if (!visited[g.get(s).get(i)]) {
        visited[g.get(s).get(i)] = true;
        path.add(words[g.get(s).get(i)]);
        int dist = traverse(words, g.get(s).get(i), d, visited, path);
        if (dist != Integer.MIN_VALUE)
          return 1 + dist;
        else {
          path.remove(path.size() - 1);
          visited[g.get(s).get(i)] = false; // Backtracking.
        }
      }
    }
    return Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    String[] words = { "cat", "dat", "dog", "boy", "cot", "bot" };
    System.out.println(transform(words, 0, "boy"));
  }

  public static void populateGraph(String[] words) {
    for (int i = 0; i < words.length; i++) {
      g.put(i, new ArrayList<Integer>());
    }
    for (int i = 0; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        if (isDistanceOne(words[i], words[j])) {
          g.get(i).add(j);
          g.get(j).add(i);
        }
      }
    }
  }

  public static boolean isDistanceOne(String a, String b) {
    int[] cc = new int[256];
    for (char c : a.toCharArray())
      cc[c]++;
    for (char c : b.toCharArray())
      cc[c]--;
    int extra = 0, missing = 0;
    for (int n : cc) {
      if (n == 1)
        extra++;
      else if (n == -1)
        missing++;
      else if (n != 0)
        return false;
    }

    return extra == 1 && missing == 1;
  }

}
