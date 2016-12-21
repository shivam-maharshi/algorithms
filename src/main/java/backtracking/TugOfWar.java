package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of n integers, divide the set in two subsets of n/2 sizes each
 * such that the difference of the sum of two subsets is as minimum as possible.
 * If n is even, then sizes of two subsets must be strictly n/2 and if n is odd,
 * then size of one subset must be (n-1)/2 and size of other subset must be
 * (n+1)/2.
 * 
 * Link: http://www.geeksforgeeks.org/tug-of-war/
 * 
 * @author shivam.maharshi
 */
public class TugOfWar {

	public static void solve(int[] a) {
		List<Integer> minList = new ArrayList<>();
		solve(0, new ArrayList<>(), a, Integer.MAX_VALUE, minList);
		printSol(minList, a);
	}

	private static void printSol(List<Integer> minList, int[] a) {
		for (int i : minList)
			System.out.print(a[i] + " ");
	}

	private static int solve(int index, List<Integer> list, int[] a, int minDiff, List<Integer> minList) {
		if (index >= a.length)
			return minDiff;
		if (list.size() >= a.length / 2) {
			int newDiff = getMinDiff(minDiff, list, a);
			if (newDiff != minDiff) {
				copy(list, minList);
				return newDiff;
			}
			return minDiff;
		}

		list.add(index);
		int diff = solve(index + 1, list, a, minDiff, minList);
		list.remove(list.size() - 1);
		diff = solve(index + 1, list, a, diff, minList);
		return diff;
	}

	private static int getMinDiff(int minDiff, List<Integer> list, int[] a) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < a.length; i++) {
			if (list.contains(i))
				x += a[i];
			else
				y += a[i];
		}
		return Math.abs(x - y) < minDiff ? Math.abs(x - y) : minDiff;
	}

	private static void copy(List<Integer> from, List<Integer> to) {
		to.clear();
		for (int a : from)
			to.add(a);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 3, 4, 5, -3, 100, 1, 89, 54, 23, 20 };
		solve(a);
	}

}
