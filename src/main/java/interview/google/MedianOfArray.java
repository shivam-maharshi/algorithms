package interview.google;

import java.util.List;

/**
 * Link: https://www.interviewbit.com/problems/median-of-array/ Link:
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * 
 * @author shivam.maharshi
 */
public class MedianOfArray {

  public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
    if ((a == null || a.size() == 0) && (b == null || b.size() == 0))
      return -1;
    if (a == null || a.size() == 0)
      return b.size() % 2 == 1 ? b.get(b.size() / 2) : b.get((b.size() / 2) - 1);
    if (b == null || b.size() == 0)
      return a.size() % 2 == 1 ? a.get(a.size() / 2) : a.get((a.size() / 2) - 1);
    int as = a.size(), bs = b.size(), sum = as + bs;
    return sum % 2 == 1 ? find(a, b, sum / 2, 0, as, 0, bs, true) : find(a, b, (sum - 1) / 2, 0, as, 0, bs, false);
  }

  public static double find(List<Integer> a, List<Integer> b, int k, int la, int ha, int lb, int hb, boolean odd) {
    double r = 0;
    return r;
  }

}
