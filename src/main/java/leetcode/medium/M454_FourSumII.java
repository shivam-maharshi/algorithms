package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/4sum-ii
 * 
 * @author shivam.maharshi
 */
public class M454_FourSumII {

  // O(n^2) solution. Can do better with a O(nLog(n)) solution.
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int c = 0;
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < A.length; i++)
      for (int j = 0; j < B.length; j++) {
        if (!m.containsKey(A[i] + B[j]))
          m.put(A[i] + B[j], 0);
        m.put(A[i] + B[j], m.get(A[i] + B[j]) + 1);
      }

    for (int i = 0; i < C.length; i++)
      for (int j = 0; j < D.length; j++)
        c += m.containsKey(-(C[i] + D[j])) ? m.get(-(C[i] + D[j])) : 0;

    return c;
  }

}
