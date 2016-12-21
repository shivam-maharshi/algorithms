package math;

/**
 * Find the largest multiple of 2, 5 and 3 from a given array of integers.
 * 
 * Link: http://www.geeksforgeeks.org/find-the-largest-multiple-of-2-3-and-5/
 * 
 * @author shivam.maharshi
 */
public class LargestMultipleOf2_5_3 {

	public static void print(int[] a) {
		// Array must have one zero to be divisible by 5 & 2.
		boolean valid = false;
		for (int n : a) {
			if (n == 0) {
				valid = true;
			}
		}
		if (!valid) {
			System.out.println("Not possible");
			return;
		}
		LargestMultipleOf3.get(a);
	}

	public static void main(String[] args) {
		print(new int[] { 1, 8, 7, 6, 0 });
	}

}
