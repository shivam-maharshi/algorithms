package sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * Find a pair in the array that sum to N.
 * 
 * Link: http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-
 * numbers-and-another-number-x-determines-whether-or-not-there-exist-two-
 * elements-in-s-whose-sum-is-exactly-x/
 * 
 * @author shivam.maharshi
 */
public class GivenSumTwoElements {

	public static void givenSumTwoElements(int[] arr, int sum) {

		Map<Integer, Void> set = new HashMap<Integer, Void>();

		for (int i = 0; i < arr.length; i++) {
			int diff = sum - arr[i];
			if (!set.containsKey(diff)) {
				set.put(arr[i], null);
			} else {
				System.out.println("Sum : " + sum + " = " + diff + " + " + arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		givenSumTwoElements(new int[] { 4, 9, 1, 6, 3, 2 }, 7);
	}

}
