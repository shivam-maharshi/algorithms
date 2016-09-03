package leetcode;

/**
 * Link: https://leetcode.com/problems/remove-element/
 * 
 * @author shivam.maharshi
 */
public class RemoveElement {

  public int removeElement(int[] nums, int val) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[res] = nums[i];
        res++;
      }
    }
    return res;
  }

}
