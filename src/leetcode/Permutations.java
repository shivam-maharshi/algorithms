package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutations/
 * 
 * @author shivam.maharshi
 */
public class Permutations {

  public static void main(String[] args) {
    print(permute(new int[] { 1, 2, 3 }));
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> p = new ArrayList<List<Integer>>();
    List<Integer> n = new ArrayList<>();
    for (int i = 0; i < nums.length; i++)
      n.add(nums[i]);
    permute(n, p, new ArrayList<Integer>(), nums.length);
    return p;
  }

  public static void permute(List<Integer> l, List<List<Integer>> p, List<Integer> r, int len) {
    if (r.size() == len) {
      p.add(new ArrayList<Integer>(r));
      return;
    }

    for (int j = 0; j < l.size(); j++) {
      int n = l.get(j);
      l.remove(j);
      r.add(n);
      permute(l, p, r, len);
      r.remove(r.size() - 1);
      l.add(j, n);
    }
  }

  public static void print(List<List<Integer>> l) {
    for (List<Integer> ll : l) {
      for (Integer n : ll) {
        System.out.print(n + " ");
      }
      System.out.println();
    }
  }

}
