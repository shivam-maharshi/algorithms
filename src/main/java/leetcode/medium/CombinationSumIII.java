package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/combination-sum-iii/
 * 
 * @author shivam.maharshi
 */
public class CombinationSumIII {

  public static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> r = new ArrayList<List<Integer>>();
    cs(k, n, 1, new ArrayList<Integer>(), r);
    return r;
  }

  public static void cs(int k, int sum, int n, List<Integer> l, List<List<Integer>> r) {
    if (sum == 0 && k==0) {
      r.add(new ArrayList<>(l));
      return;
    }

    if (k == 0)
      return;

    for (int i = n; i < 10; i++) {
      if (i <= sum) {
        l.add(i);
        cs(k - 1, sum - i, i + 1, l, r);
        l.remove(l.size()-1);
      } else {
        break;
      }
    }

  }

}
