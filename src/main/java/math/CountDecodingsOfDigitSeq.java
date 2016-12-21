package math;

/**
 * Count Possible Decodings of a given Digit Sequence
 * 
 * Link:
 * http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * 
 * @author shivam.maharshi
 */
public class CountDecodingsOfDigitSeq {

	public static int count(int[] digit, int index) {
		if (index == digit.length || index == digit.length - 1)
			return 1;
		int res = 0;
		if (isValidDoubleDigit(digit, index))
			res += count(digit, index + 2);
		res += count(digit, index + 1);
		return res;
	}

	private static boolean isValidDoubleDigit(int[] digit, int index) {
		return digit[index] == 1 || (digit[index] == 2 && digit[index + 1] < 7);
	}

	public static void main(String[] args) {
		int[] digit = new int[] { 1, 2, 3, 4 };
		System.out.println(count(digit, 0));
	}

}
