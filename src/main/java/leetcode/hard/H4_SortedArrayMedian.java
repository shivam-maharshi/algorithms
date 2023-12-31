package leetcode.hard;

/**
 * Link: https://leetcode.com/problems/median-of-two-sorted-arrays
 * 
 * @author shivam.maharshi
 */
public class H4_SortedArrayMedian {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    return getMedian(nums1, 0, nums1.length, nums2, 0, nums2.length, (nums1.length + nums2.length - 1) / 2);
  }

  private double getMedian(int[] a, int al, int ah, int[] b, int bl, int bh, int i) {
    if (i == 0)
      return calculateMedian(a, al, ah, b, bl, bh);
    int am = al + (ah - al - 1) / 2;
    int bm = bl + (bh - bl - 1) / 2;
    if (a[am] < b[bm])
      return getMedian(a, am, ah, b, bl, bh, i - am);
    else
      return getMedian(a, al, ah, b, bm, bh, i - bm);
  }

  private double calculateMedian(int[] a, int al, int ah, int[] b, int bl, int bh) {
    return 0;
  }

}
