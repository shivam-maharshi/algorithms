package algorithm;

import java.util.HashSet;
import java.util.Set;

public class GivenSumTwoElements {

	public static void givenSumTwoElements(int[] arr, int sum) {

		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int diffValue = sum - arr[i];
			if (!set.contains(diffValue)) {
				set.add(diffValue);
			} else {
				System.out.println("Sum : " + sum + " = " + diffValue + " + " + arr[i]);
				return;
			}
		}
	}

	public static void main(String[] args) {
		givenSumTwoElements(new int[] {4, 9, 1, 6, 3, 2},  7);
	}

}
