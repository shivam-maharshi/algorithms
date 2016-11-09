package leetcode.hard;

/**
 * Link: https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * @author shivam.maharshi
 */
public class FindTheDuplicateNumber {

  public int findDuplicate(int[] nums) {
    int slow = 0;
    int fast = 0;

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    int find = 0;

    while (find != slow) {
      slow = nums[slow];
      find = nums[find];
    }
    return find;
  }

}
