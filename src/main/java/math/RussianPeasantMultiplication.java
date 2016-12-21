package math;

/**
 * Given two integers, write a function to multiply them without using
 * multiplication operator.
 * 
 * Link: http://www.geeksforgeeks.org/fast-multiplication-method-without-using-
 * multiplication-operator-russian-peasants-algorithm/
 * 
 * @author shivam.maharshi
 *
 */
public class RussianPeasantMultiplication {

	/*
	 * The idea is to double the first number and half the second. If the second
	 * number is odd, add the first number to the result and carry on.
	 */
	public static int multiply(int a, int b) {
		int res = a;
		int t = 0;
		while (b != 1) {
			int temp = res;
			res = res << 1;
			if ((b & 1) == 1) {
				t += temp;
			}
			b = b >> 1;
		}
		return res + t;
	}

	public static void main(String[] args) {
		System.out.println(multiply(100, 399));
	}

}
