package leetcode;

/**
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author shivam.maharshi
 */
public class RemoveDuplicatesFromSortedArray {

  public int removeDuplicates(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int res = 1, cur = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != cur) {
        res++;
        cur = nums[i];
        nums[res-1] = cur;
      }
    }
    return res;
  }

}
