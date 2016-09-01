package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Leetcode: https://leetcode.com/problems/3sum/
 * 
 * @author shivam.maharshi
 */
public class ThreeSum {

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3)
      return new ArrayList<List<Integer>>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Set<V> set = new TreeSet<V>();
    Arrays.sort(nums);
    for (int n = nums.length - 1; n >= 2; n--) {
      int num = -1 * nums[n];
      int r = n - 1, l = 0;
      addCriteriaMatchingValues(nums, num, r, l, set);
    }
    populateList(res, set);
    return res;
  }

  public void addCriteriaMatchingValues(int[] nums, int num, int r, int l, Set<V> set) {
    while (r > l) {
      int sum = nums[r] + nums[l];
      if (sum == num) {
        addNum(nums, num, r, l, set);
        r--;
        l++;
      } else if (sum > num) {
        r--;
      } else {
        l++;
      }
    }
  }

  public void addNum(int[] nums, int num, int r, int l, Set<V> set) {
    set.add(new V(nums[l], nums[r], -1*num));
  }
  
  public void populateList(List<List<Integer>> list, Set<V> set) {
    Iterator<V> it = set.iterator();
    while(it.hasNext()) {
      List<Integer> l = new ArrayList<Integer>();
      V v = it.next();
      l.add(v.a);
      l.add(v.b);
      l.add(v.c);
      list.add(l);
    }
  }

}

class V implements Comparable<V> {
  
  public int a;
  public int b;
  public int c;
  
  public V() {
    super();
  }

  public V(int a, int b, int c) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
  }

  @Override
  public int compareTo(V o) {
    if(this.a < o.a)
      return -1;
    else if( this.a == o.a) {
      if(this.b < o.b)
        return -1;
      else if(this.b == o.b) {
        if (this.c < o.c)
          return -1;
        else if(this.c == o.c)
          return 0;
        else
          return 1;
      } else
        return 1;
    } else 
      return 1;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + a;
    result = prime * result + b;
    result = prime * result + c;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    V other = (V) obj;
    if (a != other.a)
      return false;
    if (b != other.b)
      return false;
    if (c != other.c)
      return false;
    return true;
  }
  
}
