package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/combinations
 * 
 * @author shivam.maharshi
 */
public class M77_Combinations {

  public static void main(String[] args) {
    List<List<Integer>> r = combine(3, 2);
    for (List<Integer> l : r)
      System.out.println(Arrays.toString(l.toArray()));
  }

  public static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> r = new ArrayList<>();
    combine(n, k, 1, new ArrayList<Integer>(), r);
    return r;
  }

  @SuppressWarnings("unchecked")
  public static void combine(int n, int k, int s, ArrayList<Integer> r, List<List<Integer>> res) {
    if (r.size() == k) {
      res.add((List<Integer>) r.clone());
      return;
    }
    for (int i = s; i <= n; i++) {
      r.add(i);
      combine(n, k, i + 1, r, res);
      r.remove(r.size() - 1);
    }
  }

}
