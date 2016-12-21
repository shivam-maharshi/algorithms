package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given n fair dice with m side, return the histogram of frequency of their sum.
 */
public class DiceRollHistogram {

	// This is brute force. O(N^M). We need to find better.
	public static Map<Integer, Integer> getHistogram(int n, int m) {
		Map<Integer, Integer> histogram = new HashMap<Integer, Integer>();
		int[] a = new int[n];
		Arrays.fill(a, 1);
		while (true) {
			try {
				int sum = computeSum(a);
				if (histogram.containsKey(sum)) {
					histogram.put(sum, histogram.get(sum) + 1);
				} else {
					histogram.put(sum, 1);
				}
				a = incermentCounter(a, m);
			} catch (OverFlowExecution e) {
				break;
			}
		}
		return histogram;
	}

	private static int computeSum(int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			count += a[i];
		}
		return count;
	}

	private static int[] incermentCounter(int[] a, int m) {
		if (isMax(a, m))
			throw new OverFlowExecution();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == m) {
				a[i] = 1;
				continue;
			} else {
				a[i] = a[i] + 1;
				break;
			}
		}
		return a;
	}

	private static boolean isMax(int[] a, int m) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] < m)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Map<Integer, Integer> histogram = DiceRollHistogram.getHistogram(2, 3);
		System.out.println(histogram.size());
	}

}

class OverFlowExecution extends RuntimeException {

	private static final long serialVersionUID = -3553581134335170678L;

}
