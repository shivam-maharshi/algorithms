package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string, print all permutations of it in sorted order. For example, if
 * the input string is “ABC”, then output should be “ABC, ACB, BAC, BCA, CAB,
 * CBA”.
 * 
 * Link: http://www.geeksforgeeks.org/lexicographic-permutations-of-string/
 * 
 * @author shivam.maharshi
 */
public class StringPermutationLexicographicalOrder {

	public static void print(String s) {
		char[] c = s.toCharArray();
	}

	public static void printString(List<String> list, char[] c, int index) {
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (s.length() == c.length - 1) {
				System.out.println(s + c[index]);
				return;
			}
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("");
		compilateion
	}

}
