package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider a situation where all characters of pattern are different. Can we
 * modify the original Naive String Matching algorithm so that it works better
 * for these types of patterns.
 * 
 * Link:
 * http://www.geeksforgeeks.org/pattern-searching-set-4-a-naive-string-matching-
 * algo-question/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternNaiveOptimized {

	public static List<Integer> match(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				if (j == p.length() - 1) {
					list.add(i - p.length() + 1);
					j = 0;
				} else {
					j++;
				}
				i++;
			} else {
				if (j == 0)
					i++;
				else
					j = 0;
			}
		}
		for (int index : list)
			System.out.println("Pattern at : " + index);
		return list;
	}

	public static void main(String[] args) {
		match("ABCEABCDABCEABCD", "ABCD");
	}

}
