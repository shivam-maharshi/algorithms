package google;

import java.util.List;

import string.SearchPatternKMP;

/**
 * Given a long string s and short strings t1, t2, t3 (which can have different
 * length) find the shortest substring of s which contains t1, t2 and t3.
 * 
 * Link: http://www.careercup.com/question?id=6326674964611072
 * 
 * @author shivam.maharshi
 */
public class ShortestContainingSubtring {

	public static String get(String s, String a, String b, String c) {
		List<Integer> al = SearchPatternKMP.match(s, a);
		List<Integer> bl = SearchPatternKMP.match(s, b);
		List<Integer> cl = SearchPatternKMP.match(s, c);
		int start = 0, end = 0, minSubLen = Integer.MAX_VALUE;

		// Use sliding window
		int i = 0, j = 0, k = 0;
		while (i < a.length() || j < b.length() || k < c.length()) {
			int mins = Math.min(al.get(i), Math.min(bl.get(j), cl.get(k)));
			int maxs = Math.max(al.get(i) + a.length(), Math.max(bl.get(j) + b.length(), cl.get(k) + c.length()));
			if ((maxs - mins) < minSubLen) {
				minSubLen = maxs - mins;
				start = mins;
				end = maxs;
			}
			if (al.get(i) == Math.min(al.get(i), Math.min(bl.get(j), cl.get(k)))) {
				i++;
			} else if (bl.get(i) == Math.min(al.get(i), Math.min(bl.get(j), cl.get(k)))) {
				j++;
			} else {
				k++;
			}
		}
		String res = s.substring(start, end);
		return res;
	}

	public static void main(String[] args) {
		String s = "Thisisaverylongstringthathastobeoneofthebiggestoneofitskind";
		get(s, "long", "on", "verylong");
	}

}
