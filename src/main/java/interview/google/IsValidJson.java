package interview.google;

import java.util.Stack;

/**
 * Validate whether given string is valid JSON fromat string or not.
 * 
 * Link: http://www.careercup.com/question?id=5643209168388096
 * 
 * @author shivam.maharshi
 */
public class IsValidJson {

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == ',') {
				if (!validateComma(stack))
					return false;
			} else if (c == '}') {
				if (!validateBraces(stack))
					return false;
			} else {
				stack.push(c);
			}
		}
		return true;
	}

	private static boolean validateComma(Stack<Character> stack) {
		char c = stack.pop();
		String temp = "";
		while (c != '{') {
			temp += c;
			c = stack.pop();
		}
		if (c == '{')
			stack.push('{');
		return temp.split(":").length == 2 ? true : false;
	}

	private static boolean validateBraces(Stack<Character> stack) {
		char c = stack.pop();
		String temp = "";
		while (c != '{') {
			temp += c;
			c = stack.pop();
		}
		if (c == '{')
			stack.push('*');
		return temp.split(":").length == 2 ? true : false;
	}

	public static void main(String[] args) {
		String s0 = "{a:b,c:{e:f}}";
		String s1 = "{a:b, c:d}";
		String s2 = "{a}";
		String s3 = "{{a}}";
		System.out.println(isValid(s3));
	}

}
