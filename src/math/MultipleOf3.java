package math;

/**
 * Find out if the given number is multiple of three or not. If the difference
 * between the number of ones in the odd places and number of ones in the even
 * places for the binary representation of a number are a multiple of 3, then so
 * is the number itself.
 * 
 * Link:
 * http://www.geeksforgeeks.org/write-an-efficient-method-to-check-if-a-number-
 * is-multiple-of-3/
 * 
 * @author shivam.maharshi
 */
public class MultipleOf3 {

	/**
	 * Complexity of this solution is O(lg(n)).
	 */
	public static boolean isMultiple(int n) {
		int even = 0;
		int odd = 0;
		boolean isEven = true;
		while (n != 0) {
			if (isEven) {
				if ((n & 1) == 1) {
					even++;
				}
				isEven = false;
			} else {
				if ((n & 1) == 1) {
					odd++;
				}
				isEven = true;
			}
			n = n >> 1;
		}
		return ((odd - even) % 3 == 0) ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(MultipleOf3.isMultiple(332));
	}

}
