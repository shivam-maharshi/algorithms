package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Search pattern naively with worst case complexity O(m*(n-m+1)).
 * 
 * Link:
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-
 * searching/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternNaive {

	public static List<Integer> match(String s, String p) {
		List<Integer> pl = new ArrayList<Integer>();
		int start = 0, i = 0, j = 0;
		if (s.length() >= p.length()) {
			while (start <= s.length() - p.length()) {
				if (s.charAt(i) == p.charAt(j)) {
					if (j == p.length() - 1) {
						pl.add(start);
						j = 0;
						start++;
						i = start;
					}
					i++;
					j++;
				} else {
					j = 0;
					start++;
					i = start;
				}
			}
		}
		return pl;
	}

	public static void main(String[] args) {
		List<Integer> pl = SearchPatternNaive.match("abcdefabcdgrabcdgr", "abcdgr");
		for (int p : pl)
			System.out.println("Pattern at : " + p);
	}

}
