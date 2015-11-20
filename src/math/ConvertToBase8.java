package math;

/**
 * Given a decimal number, convert it to base 8. Taking care of the negative
 * numbers is a very important thing in this question.
 * 
 * Company : Google
 * 
 * @author shivam.maharshi
 */
public class ConvertToBase8 {

	public static String convert(int n) {
		String res = "";
		boolean isNeg = false;
		if (n < 0) {
			isNeg = true;
			n *= -1;
		}
		while (n != 0) {
			res = n % 8 + res;
			n = n / 8;
		}
		return isNeg ? "-" + res : res;
	}

	public static void main(String[] args) {
		System.out.println(convert(-123));
	}

}
