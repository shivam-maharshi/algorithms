package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * @author shivam.maharshi
 */
public class TwoSumIIInputArraySorted {

  public static int[] twoSum(int[] numbers, int target) {
    int l = 0, h = numbers.length - 1;
    while (l < h) {
      int sum = numbers[l] + numbers[h];
      if (sum == target)
        return new int[] { l + 1, h + 1 };
      else if (sum < target)
        l++;
      else
        h--;
    }
    return new int[] { -1, -1 };
  }

}
