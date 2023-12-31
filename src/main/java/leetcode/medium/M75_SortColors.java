package leetcode.medium;

import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/sort-colors
 * 
 * @author shivam.maharshi
 */
public class M75_SortColors {
  
  public static void main(String[] args) {
    int[] a = new int[]{1,0};
    sortColors(a);
    System.out.println(Arrays.toString(a));
  }

  // Single pass solution.
  public static void sortColors(int[] nums) {
    int l = 0, h = nums.length - 1, i = 0;
    while (i <= h) {
      if (nums[i] == 0) {
        if (l==i) {
          i++;
          l++;
        } else {
          if (nums[l] != 0)
            swap(nums, l, i);
          l++;
        }
      } else if (nums[i] == 2) {
        if (nums[h] != 2)
          swap(nums, i, h);
        h--;
      } else {
        i++;
      }
    }
  }
  
  public static void swap(int[] n, int l, int h) {
    int t = n[l];
    n[l] = n[h];
    n[h] = t;
  }

}
