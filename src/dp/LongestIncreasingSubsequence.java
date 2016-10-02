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
		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(get(a));
		System.out.println(getMax(a));
	}
	
	public static int getMax(int[] a) {
	  int[] dp = new int[a.length];
	  for(int i=0; i<a.length; i++) {
	    int count = 0;
	    for (int j=i-1; j>=0; j--) {
	      if (a[j] < a[i]) {
	        if (count < (dp[j] + 1)) {
	          count = dp[j] + 1;
	        }
	      } else {
	        if (count < dp[j]) {
            count = dp[j];
          }
	      }
	    }
	    dp[i] = count == 0 ? 1 : count;
	  }
	  return dp[a.length-1];
	}

}
