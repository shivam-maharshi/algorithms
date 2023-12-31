package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/4sum
 * 
 * @author shivam.maharshi
 */
public class M18_FourSum extends TestCase {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    if (nums.length < 4)
      return new ArrayList<List<Integer>>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    Set<F> set = new TreeSet<F>();
    Arrays.sort(nums);
    for (int m = nums.length - 1; m >= 3; m--) {
      for (int n = m - 1; n >= 2; n--) {
        int num = target -1 * (nums[n] + nums[m]);
        int r = n - 1, l = 0;
        addCriteriaMatchingFalues(nums, num, r, l, n, m, set);
      }
    }
    populateList(res, set);
    return res;
  }

  public void addCriteriaMatchingFalues(int[] nums, int num, int r, int l, int n, int m, Set<F> set) {
    while (r > l) {
      int sum = nums[r] + nums[l];
      if (sum == num) {
        addNum(nums, num, r, l, n, m, set);
        r--;
        l++;
      } else if (sum > num) {
        r--;
      } else {
        l++;
      }
    }
  }

  public void addNum(int[] nums, int num, int r, int l, int n, int m, Set<F> set) {
    set.add(new F(nums[l], nums[r], nums[n], nums[m]));
  }

  public void populateList(List<List<Integer>> list, Set<F> set) {
    Iterator<F> it = set.iterator();
    while (it.hasNext()) {
      List<Integer> l = new ArrayList<Integer>();
      F v = it.next();
      l.add(v.a);
      l.add(v.b);
      l.add(v.c);
      l.add(v.d);
      list.add(l);
    }
  }

  @Test
  public void test() {
    M18_FourSum f = new M18_FourSum();
    assertEquals(new ArrayList<List<Integer>>(), f.fourSum(new int[]{0,0,0,0}, 1));
  }

}

class F implements Comparable<F> {

  public int a;
  public int b;
  public int c;
  public int d;

  public F() {
    super();
  }

  public F(int a, int b, int c, int d) {
    super();
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  @Override
  public int compareTo(F o) {
    if (this.a < o.a)
      return -1;
    else if (this.a == o.a) {
      if (this.b < o.b)
        return -1;
      else if (this.b == o.b) {
        if (this.c < o.c)
          return -1;
        else if (this.c == o.c) {
          if (this.d < o.d)
            return -1;
          else if (this.d == o.d)
            return 0;
          else
            return 1;
        } else
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
    result = prime * result + d;
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
    F other = (F) obj;
    if (a != other.a)
      return false;
    if (b != other.b)
      return false;
    if (c != other.c)
      return false;
    if (d != other.d)
      return false;
    return true;
  }

}
