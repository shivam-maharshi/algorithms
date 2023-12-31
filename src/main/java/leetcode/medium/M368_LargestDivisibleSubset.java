package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/largest-divisible-subset
 * 
 * @author shivam.maharshi
 */
public class M368_LargestDivisibleSubset extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, largestDivisibleSubset(new int[] {}).size());
    assertEquals(1, largestDivisibleSubset(new int[] { 1 }).size());
    assertEquals(2, largestDivisibleSubset(new int[] { 1, 2, 3 }).size());
    assertEquals(3, largestDivisibleSubset(new int[] { 1, 2, 3, 4 }).size());
    assertEquals(5, largestDivisibleSubset(new int[] { 1, 2, 3, 4, 8, 16 }).size());
    assertEquals(4, largestDivisibleSubset(new int[] { 2, 3, 4, 8, 16 }).size());
    assertEquals(4, largestDivisibleSubset(new int[] { 1, 3, 4, 6, 18 }).size());
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  public static List<Integer> largestDivisibleSubset(int[] nums) {
    if (nums == null || nums.length == 0)
      return new ArrayList<>();
    Arrays.sort(nums);
    Map<Integer, List<Integer>> m = new TreeMap<>();
    m.put(-1, new ArrayList<>());
    for (int i = 0; i < nums.length; i++) {
      List<Integer> t = new ArrayList<>();
      t.add(nums[i]);
      // Subset for only smaller numbers added till now.
      for (int j : m.keySet()) {
        List<Integer> l = m.get(j);
        if (l.size() > 0 && nums[i] % j == 0 && l.size() + 1 > t.size()) {
          t = (List<Integer>) ((ArrayList) l).clone();
          t.add(nums[i]);
        }
      }
      m.put(nums[i], t);
    }
    List<Integer> r = new ArrayList<>();
    for (int j : m.keySet())
      if (m.get(j).size() > r.size())
        r = m.get(j);
    for (int rr : r)
      System.out.print(rr + " ");
    System.out.println();
    return r;
  }

}
