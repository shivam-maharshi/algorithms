package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Find all the Palindromic substrings of a given string.
 * 
 * Link:
 * http://www.geeksforgeeks.org/find-number-distinct-palindromic-sub-strings-
 * given-string/
 * 
 * Link: https://leetcode.com/discuss/interview-questions/microsoft
 * 
 * @author shivam.maharshi
 */
public class PrintAllPalindromicSubstrings {

	/*
	 * The idea is to simply pick every character and move both the sides till
	 * the characters are same on the end. If they are not, then you break of
	 * the loop because if the substring is not a palindrome than the bigger
	 * string will not be a plaindrome too. TimeComplexity: O(n^2). Brute force
	 * is O(n^3). Generation of all substring of a string is itself O(n^2),
	 * hence this is an optimal solution.
	 */
	public static Set<String> printAll(String s) {
		Set<String> res = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			StringBuilder sb = new StringBuilder();
			int j = i, k = i + 1;
			res.add(s.charAt(i) + "");
			for (int it = 0; it < 2; it++) {
				if (it == 1) {
					j = i - 1;
					k = i + 1;
					sb.setLength(0);
					sb.append(s.charAt(i));
				}
				while (j >= 0 && k < s.length()) {
					if (s.charAt(j) == s.charAt(k)) {
						sb.insert(0, s.charAt(j));
						res.add(sb.append(s.charAt(k)).toString());
						j--;
						k++;
					} else
						break;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		for (String s : printAll("abcbad"))
			System.out.println(s);
	}

}
