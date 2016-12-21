package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Subset sum problem is to find subset of elements that are selected from a
 * given set whose sum adds up to a given number K. We are considering the set
 * contains non-negative values. It is assumed that the input set is unique (no
 * duplicates are presented).
 * 
 * Link: http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 * 
 * @author shivam.maharshi
 */
public class SubsetSum {

	public static void print(int[] a, int sum) {
		print(a, sum, -1, new ArrayList<>());
	}

	// This solution is better than naive, which is exponential.
	private static void print(int[] a, int sum, int index, List<Integer> list) {
		if (sum == 0) {
			printList(list);
			return;
		}
		for (int i = index + 1; i < a.length; i++) {
			if (a[i] <= sum) {
				list.add(a[i]);
				print(a, sum - a[i], i, list);
				list.remove(list.size() - 1); // This is backtracking.
			}
		}
	}

	private static void printList(List<Integer> list) {
		for (int n : list)
			System.out.print(n + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] a = new int[] { 10, 7, 5, 18, 12, 20, 15 };
		print(a, 35);
	}

}
