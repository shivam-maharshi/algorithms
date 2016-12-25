package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/subsets-ii/
 * 
 * @author shivam.maharshi
 */
public class SubsetsII {

  public static void main(String[] args) {
    List<List<Integer>> r = subsetsWithDup(new int[] { 1, 2, 2 });
    for (List<Integer> l : r)
      System.out.println(Arrays.toString(l.toArray()));
  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> r = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0)
      return r;
    Arrays.sort(nums);
    List<Integer> l = new ArrayList<Integer>();
    l.add(nums[0]);
    for (int n : nums)
      if (l.get(l.size() - 1) != n)
        l.add(n);
    Map<Integer, Integer> m = new HashMap<>();
    for (int n : nums) {
      if (!m.containsKey(n))
        m.put(n, 0);
      m.put(n, m.get(n) + 1);
    }
    sub(l, 0, m, new ArrayList<Integer>(), r);
    return r;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void sub(List<Integer> n, int i, Map<Integer, Integer> m, List<Integer> l, List<List<Integer>> r) {
    if (i >= n.size()) {
      r.add((List<Integer>) ((ArrayList) l).clone());
      return;
    }
    sub(n, i + 1, m, l, r);
    if (m.get(n.get(i)) > 0) {
      l.add(n.get(i));
      m.put(n.get(i), m.get(n.get(i)) - 1);
      sub(n, i, m, l, r);
      m.put(n.get(i), m.get(n.get(i)) + 1);
      l.remove(l.size() - 1);
    }
  }

}
