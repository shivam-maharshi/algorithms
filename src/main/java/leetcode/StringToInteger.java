package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * 
 * @author shivam.maharshi
 */
public class StringToInteger extends TestCase {
	IntegerValue value = new IntegerValue();
	public int inputString(String str) {
		int result = 0;
		boolean isNeg = false;
		String input = str.trim();
		input = reverse(input);
		input.trim();
		input = reverse(input);
		if (input.length() > 0) {
			char fc = input.charAt(0);
			if (fc == '-') {
				isNeg = true;
			} else if (fc == '+') {
				// do nothing
			} else if (getValue(fc) == -1) {
				return 0;
			} else {
				result = getValue(fc);
			}
		}

		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			int cValue = getValue(c);
			if (cValue == -1) {
				break;
			} else {
				if (!isNeg) {
					if (value.isIntLessThanMax(result, cValue)) {
						result = result * 10 + cValue;
					} else {
						result = Integer.MAX_VALUE;
						break;
					}
				} else {
					if (value.isIntMoreThanMin(result, cValue)) {
						result = result * 10 + cValue;
					} else {
						result = Integer.MIN_VALUE;
						break;
					}
				}
			}
		}
		return isNeg && result > 0 ? -1 * result : result;
	}

	public int getValue(char c) {
		int ascii = (int) c;
		if (ascii >= 48 && ascii <= 57) {
			return ascii - 48;
		}
		return -1;
	}

	public String reverse(String s) {
		String result = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			result += s.charAt(i);
		}
		return result;
	}

	@Test
	public void test() {
		StringToInteger s = new StringToInteger();
		assertEquals(s.inputString("   2147483647"), 2147483647);
		assertEquals(s.inputString("   +2147483647"), 2147483647);
		assertEquals(s.inputString("   2147483646"), 2147483646);
		assertEquals(s.inputString("   +2147483646"), 2147483646);
		assertEquals(s.inputString("   2147483648"), 2147483647);
		assertEquals(s.inputString("   +2147483648"), 2147483647);
		assertEquals(s.inputString("   2147483647000000000"), 2147483647);
		assertEquals(s.inputString("   +214748364700000000"), 2147483647);
		assertEquals(s.inputString("   2147483647asdas"), 2147483647);

		assertEquals(s.inputString("   -2147483648"), -2147483648);
		assertEquals(s.inputString("   -2147483647"), -2147483647);
		assertEquals(s.inputString("   -2147483649"), -2147483648);
		assertEquals(s.inputString("   -214748364800000000"), -2147483648);
		assertEquals(s.inputString("   -2147483648asads"), -2147483648);
	}

}
