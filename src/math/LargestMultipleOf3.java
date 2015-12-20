package math;

import java.util.Arrays;

/**
 * Find the largest multiple of 3 that can be made by the given numbers.
 * 
 * Link: http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
 * 
 * @author shivam.maharshi
 */
public class LargestMultipleOf3 {

	public static void get(int[] a) {
		Arrays.sort(a);
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		int rem = sum % 3;
		if (rem == 1) {
			boolean oneFound = false;
			int twoCount = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] % 3 == 1) {
					a[i] = -1;
					oneFound = true;
					break;
				}
			}
			if (oneFound) {
				print(a);
				return;
			}
			if (!oneFound) {
				for (int i = 0; i < a.length; i++) {
					if (a[i] % 3 == 2) {
						a[i] = -1;
						twoCount++;
						if (twoCount == 2) {
							break;
						}
					}
				}
				if (twoCount == 2) {
					print(a);
					return;
				} else {
					System.out.println("Number not possible.");
					return;
				}
			}
		} else if (rem == 2) {
			boolean twoFound = false;
			int oneCount = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] % 3 == 2) {
					a[i] = -1;
					twoFound = true;
					break;
				}
			}
			if (twoFound) {
				print(a);
				return;
			} else {
				if (!twoFound) {
					for (int i = 0; i < a.length; i++) {
						if (a[i] % 3 == 2) {
							a[i] = -1;
							oneCount++;
							if (oneCount == 2) {
								break;
							}
						}
					}
					if (oneCount == 2) {
						print(a);
						return;
					} else {
						System.out.println("Number not possible.");
						return;
					}
				}
			}
		}
		print(a);
	}

	public static void print(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != -1) {
				System.out.print(a[i]);
			}
		}
	}

	public static void main(String[] args) {
		get(new int[] { 8, 1, 7, 6, 0 });
	}

}
