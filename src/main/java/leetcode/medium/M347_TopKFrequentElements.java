package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Link: https://leetcode.com/problems/top-k-frequent-elements
 * 
 * @author shivam.maharshi
 */
public class M347_TopKFrequentElements {
  
  public static void main(String[] args) {
    topKFrequent(new int[]{1,1,1,2,2,3}, 2);
  }

  public static List<Integer> topKFrequent(int[] nums, int k) {
    if(nums==null || nums.length==0)
      return null;
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < nums.length; i++)
      if (m.containsKey(nums[i]))
        m.put(nums[i], 1 + m.get(nums[i]));
      else
        m.put(nums[i], 1);
    PriorityQueue<Pair> q = new PriorityQueue<>(new PairComp());
    Set<Entry<Integer, Integer>> es = m.entrySet();
    for (Entry<Integer, Integer> e : es)
      q.add(new Pair(e.getKey(), e.getValue()));

    List<Integer> l = new ArrayList<Integer>();

    while (k > 0) {
      l.add(q.poll().k);
      k--;
    }

    return l;
  }

  private static class PairComp implements Comparator<Pair> {

    @Override
    public int compare(Pair o1, Pair o2) {
      return o1.v > o2.v ? -1 : 1;
    }

  }

  private static class Pair {
    int k;
    int v;

    public Pair(int k, int v) {
      this.v = v;
      this.k = k;
    }

  }

}
