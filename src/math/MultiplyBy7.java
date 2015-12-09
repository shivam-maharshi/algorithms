package math;

/**
 * Multiply a number by 7 in the most efficient way.
 * 
 * Link: http://www.geeksforgeeks.org/efficient-way-to-multiply-with-7/
 * 
 * @author shivam.maharshi
 */
public class MultiplyBy7 {

	/**
	 * Time complexity is O(1). However pay attention to overflow. Edge case
	 * when multiply by 7 is not an overflow but multiply by 8 is.
	 */
	public static int multiply(int n) {
		int t = n << 3;
		return t - n;
	}

	public static void main(String[] args) {
		System.out.println(MultiplyBy7.multiply(7));
	}

}
