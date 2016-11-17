package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/house-robber-iii/
 * 
 * @author shivam.maharshi
 */
public class HouseRobberIII {

  public static int rob(TreeNode root) {
    if (root == null)
      return 0;
    // return max(root, false);
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
  }

  @SuppressWarnings("unused")
  private static int max(TreeNode root, boolean parentIncluded) {
    if (root == null)
      return 0;

    int m = max(root.left, false) + max(root.right, false);
    if (parentIncluded)
      return m;
    else
      return Math.max(root.val + max(root.left, true) + max(root.right, true), m);
  }

  public static int[] helper(TreeNode root) {
    if (root == null) {
      int[] result = { 0, 0 };
      return result;
    }

    int[] result = new int[2];
    int[] left = helper(root.left);
    int[] right = helper(root.right);

    // result[0] is when root is selected, result[1] is when not.
    result[0] = root.val + left[1] + right[1];
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return result;
  }

  private class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}
