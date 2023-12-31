package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/subsets
 * 
 * @author shivam.maharshi
 */
public class M78_Subsets {

  public static void main(String[] args) {
    subsets(new int[] { 1, 2, 3 });
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> r = new ArrayList<List<Integer>>();
    subset(nums, r, new ArrayList<>(), 0);
    for (List<Integer> l : r)
      System.out.println(Arrays.toString(l.toArray()));
    return r;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static void subset(int[] nums, List<List<Integer>> r, List<Integer> t, int i) {
    if (i >= nums.length) {
      r.add((List<Integer>) ((ArrayList) t).clone());
      return;
    }
    subset(nums, r, t, i + 1);
    t.add(nums[i]);
    subset(nums, r, t, i + 1);
    t.remove(t.size() - 1);
  }

}
