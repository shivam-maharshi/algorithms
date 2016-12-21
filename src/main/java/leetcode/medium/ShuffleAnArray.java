package leetcode.medium;

import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/shuffle-an-array/
 * 
 * @author shivam.maharshi
 */
public class ShuffleAnArray {

  private int[] a;
  private int[] n;

  public ShuffleAnArray(int[] nums) {
    this.a = Arrays.copyOf(nums, nums.length);
    this.n = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return n;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    for (int i=1; i < n.length; i++) {
      int index = (int)((i + 1) * Math.random());
      int temp = a[index];
      a[index] = a[i];
      a[i] = temp;
    }
    return a;
  }

}
