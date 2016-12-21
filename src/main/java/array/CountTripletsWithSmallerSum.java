package array;

import java.util.Arrays;

/**
 * Count the number of triplets with sum smaller than a given number. Values are
 * distinct.
 * 
 * Link: http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 * 
 * @author shivam.maharshi
 */
public class CountTripletsWithSmallerSum {

	public static int countTriplets(int[] a, int sum) {
		int res = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= sum) {
				break;
			}
			int es = sum - a[i];
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				if (a[j] + a[k] < es) {
					res += k - j;
					// System.out.println("Res+" + res + "K , J : " + k + " , " + j);
					j++;
				} else if (a[j] + a[k] >= es) {
					k--;
				}
			}
		}
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 5, 1, 3, 4, 7 };
		CountTripletsWithSmallerSum.countTriplets(a, 12);
	}

}
