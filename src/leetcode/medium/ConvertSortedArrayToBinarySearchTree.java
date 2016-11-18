package leetcode.medium;

/**
 * Link:
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author shivam.maharshi
 */
public class ConvertSortedArrayToBinarySearchTree {

  public static TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0)
      return null;
    return populateTree(nums, 0, nums.length - 1);
  }

  private static TreeNode populateTree(int[] nums, int l, int h) {
    if (l > h)
      return null;
    int m = l + (h - l) / 2;
    TreeNode r = new TreeNode(nums[m]);
    r.left = populateTree(nums, l, m - 1);
    r.right = populateTree(nums, m + 1, h);
    return r;
  }

  @SuppressWarnings("unused")
  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
