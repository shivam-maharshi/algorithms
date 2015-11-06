package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Print all the possible valid combinations of parenthesis for a given N pair.
 */
public class PossibleParenthesisCombination {

	public static void printAllValidComb(int N, int openCount, int closeCount, List<String> set, String s) {
		if (openCount > N || closeCount > N || closeCount > openCount) {
			return;
		}
		if (openCount == N && closeCount == N) {
			set.add(s);
			return;
		}
		if (openCount < N) {
			s += "(";
			printAllValidComb(N, openCount + 1, closeCount, set, s);
		}
		if (closeCount < N && closeCount <= openCount) {
			s += ")";
			printAllValidComb(N, openCount, closeCount + 1, set, s);
		}
	}

	public static void main(String[] args) {
		List<String> set = new ArrayList<String>();
		PossibleParenthesisCombination.printAllValidComb(3, 1, 0, set, "(");
		for (String s : set) {
			System.out.println(s);
		}
	}

}
