package algorithm.recursion;

/* 
 * Given an expression with just 1,0,&,|,^, calculate the number of ways to parenthesise it to get the given boolean result value.
 */

public class ParenthesisCombForExpression {

	public static int findWaysToParenEx(String ex, boolean result, int s, int e) {
		if (s == e) {
			if (ex.equals("0") && !result)
				return 1;
			if (ex.equals("1") && result)
				return 1;
			else
				return 0;
		}
		int ways = 0;
		for (int i = s + 1; i <= e; i = i + 2) {
			char op = ex.charAt(i);
			if (op == '&') {
				if (result) {
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
				} else {
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
				}
			} else if (op == '|') {
				if (!result) {
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
				} else {
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
				}
			} else if (op == '^') {
				if (result) {
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
				} else {
					ways += findWaysToParenEx(ex, true, s, i - 1) * findWaysToParenEx(ex, true, i + 1, e);
					ways += findWaysToParenEx(ex, false, s, i - 1) * findWaysToParenEx(ex, false, i + 1, e);
				}
			}
		}
		return ways;
	}

	public static void main(String[] args) {
		String ex = "1&1";
		System.out.println(ParenthesisCombForExpression.findWaysToParenEx(ex, true, 0, ex.length()-1));
	}

}
