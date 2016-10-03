package dp;

import java.util.Stack;

/**
 * The longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, length of LIS for {
 * 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-
 * subsequence/
 * 
 * @author shivam.maharshi
 */
public class LongestIncreasingSubsequence {

  public static int get(int[] a) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(a[0]);
    int withCur = get(a, 1, stack) + 1;
    stack.pop();
    int withoutCur = get(a, 1, stack);
    return Math.max(withoutCur, withCur);
  }

  private static int get(int[] a, int index, Stack<Integer> stack) {
    if (index == a.length)
      return 0;
    int withCur = 0;
    if (!stack.isEmpty() && a[index] > stack.peek()) {
      stack.push(a[index]);
      withCur = get(a, index + 1, stack) + 1;
      stack.pop();
    }
    int withoutCur = get(a, index + 1, stack);
    return Math.max(withoutCur, withCur);
  }

  public static void main(String[] args) {
    int[] a = { 10, 9, 2, 5, 3, 7, 101, 18 };
    System.out.println(getMax(a));
  }

  public static int getMax(int[] a) {
    if (a.length == 0)
      return 0;
    int[] dp = new int[a.length];
    dp[0] = 1;
    for (int i = 1; i < a.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (a[i] > a[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      dp[i] = (dp[i] == 0) ? 1 : dp[i];
    }
    int max = 0;
    for (int i = 0; i < a.length; i++)
      max = Math.max(dp[i], max);
    return max;
  }

}
