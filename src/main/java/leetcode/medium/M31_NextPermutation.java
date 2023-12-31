package leetcode.medium;

import java.util.Arrays;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/next-permutation
 * 
 * @author shivam.maharshi
 */
public class M31_NextPermutation extends TestCase {

  public void nextPermutation(int[] nums) {
    boolean solExists = false;
    outer:
    for (int i = nums.length - 2; i >= 0; i--) {
      for (int j = nums.length - 1; j > i; j--) {
        if (nums[j] > nums[i]) {
          swap(nums, j, i);
          Arrays.sort(nums, i+1, nums.length);
          solExists = true;
          break outer;
        }
      }
    }
    if(!solExists) {
      Arrays.sort(nums);
    }
    
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1,3,2};
    new M31_NextPermutation().nextPermutation(nums);
    for(int n : nums)
      System.out.print(n + " ");
  }

}
