package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author shivam.maharshi
 */
public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] a = productExceptSelf(new int[] { 1, 2, 3, 4 });
    for (int aa : a)
      System.out.print(aa + " ");
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] r = new int[nums.length], a1 = new int[nums.length], a2 = new int[nums.length];
    a1[0] = 1;
    a2[a2.length - 1] = 1;
    for (int i = 1; i < nums.length; i++)
      a1[i] = a1[i - 1] * nums[i - 1];

    for (int i = nums.length - 1; i > 0; i--)
      a2[i - 1] = a2[i] * nums[i];

    for (int i = 0; i < nums.length; i++)
      r[i] = a1[i] * a2[i];

    return r;
  }

}
