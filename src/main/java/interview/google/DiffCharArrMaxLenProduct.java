package interview.google;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of words (i.e. ["ABCW", "BAZ", "FOO", "BAR", "XTFN",
 * "ABCDEF"]), find the max value of length(s) * length(t), where s and t are
 * words from the array. The catch here is that the two words cannot share any
 * characters.
 * 
 * Link: http://www.careercup.com/question?id=5113734827606016
 * 
 * @author shivam.maharshi
 */
public class DiffCharArrMaxLenProduct {

	public static int max(String[] a) {
		Arrays.sort(a, new LengthComprarator());
		int max = 0;
		boolean[] flag = new boolean[26];
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() * a[i].length() <= max)
				break; // Optimization.
			for (char c : a[i].toCharArray()) {
				flag[(int) c - 65] = true;
			}
			for (int j = i = 1; j < a.length; j++) {
				if (a[i].length() * a[j].length() <= max) {
					break; // Optimization.
				} else if (!hasSimilarCharacters(a[j], flag)) {
					max = a[i].length() * a[j].length();
					break;
				}
			}
			Arrays.fill(flag, false);
		}
		System.out.println(max);
		return max;
	}

	private static boolean hasSimilarCharacters(String s, boolean[] flag) {
		for (char c : s.toCharArray()) {
			if (flag[c - 65])
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String[] a = { "ABCW", "BAZ", "FOO", "BAR", "XTFN", "ABCDEF" };
		max(a);
	}

}

class LengthComprarator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return o1.length() > o2.length() ? -1 : 1;
	}

}