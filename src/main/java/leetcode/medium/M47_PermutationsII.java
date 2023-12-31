package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/permutations-ii
 * 
 * @author shivam.maharshi
 */
public class M47_PermutationsII {
  
  public static void main(String[] args) {
    print(permuteUnique(new int[0]));
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> p = new ArrayList<List<Integer>>();
    List<Integer> n = new ArrayList<>();
    List<Integer> c = new ArrayList<>();
    popLists(nums, n, c);
    permute(n, c, p, new ArrayList<Integer>(), nums.length);
    return p;
  }
  
  public static void popLists(int[] nums, List<Integer> n, List<Integer> c) {
    if (nums.length > 0) {
      n.add(nums[0]);
      c.add(1);
    }

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        c.set(c.size() - 1, c.get(c.size() - 1) + 1);
      } else {
        n.add(nums[i]);
        c.add(1);
      }
    }
  }

  public static void permute(List<Integer> l, List<Integer> c, List<List<Integer>> p, List<Integer> r, int len) {
    if (r.size() == len) {
      p.add(new ArrayList<Integer>(r));
      return;
    }

    for (int j = 0; j < l.size(); j++) {
      int n = l.get(j);
      int cn = c.get(j);
      if (cn == 1) {
        c.remove(j);
        l.remove(j);
      } else {
        c.set(j, cn - 1);
      }
      r.add(n);
      permute(l, c, p, r, len);
      r.remove(r.size() - 1);
      if (cn == 1) {
        c.add(j, 1);
        l.add(j, n);
      } else {
        c.set(j, cn);
      }
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
