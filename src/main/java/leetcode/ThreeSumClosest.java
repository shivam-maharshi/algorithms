package leetcode;

import java.util.Arrays;

/**
 * Link: https://leetcode.com/problems/3sum-closest/
 * 
 * @author shivam.maharshi
 */
public class ThreeSumClosest {

  public int threeSumClosest(int[] nums, int target) {
    int res = 0, minDiff = Integer.MAX_VALUE;
    if (nums.length < 3)
      return target;
    Arrays.sort(nums);
    for (int n = nums.length - 1; n >= 2; n--) {
      int r = n - 1, l = 0, num = nums[n];
      E e = getMinDiffSum(nums, num, r, l, target);
      res = e.diff < minDiff ? e.sum : res;
      minDiff = e.diff < minDiff ? e.diff : minDiff;
    }
    return res;
  }

  public E getMinDiffSum(int[] nums, int num, int r, int l, int target) {
 // Difference that a + b must bring close to 0.
    int tdiff = target - num;
    int minDiff = Integer.MAX_VALUE;
    int res = 0;
    while (r > l) {
      int sum = nums[r] + nums[l];
      if (sum == tdiff) {
        return new E(target, 0);
      } else if (sum > tdiff) {
        res = Math.abs(sum - tdiff) < minDiff ? sum : res;
        minDiff = Math.abs(sum - tdiff);
        r--;
      } else {
        res = Math.abs(sum - tdiff) < minDiff ? sum : res;
        minDiff = Math.abs(sum - tdiff);
        l++;
      }
    }
    return new E(res+num, minDiff);
  }
  
  public static void main(String[] args) {
    System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4, -5, 6, 0}, 1));
  }

}

class E {
  public int sum;
  public int diff;
  
  public E(int sum, int diff){
    this.sum = sum;
    this.diff = diff;
  }
}
