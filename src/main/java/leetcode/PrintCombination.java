package leetcode;

import java.util.List;

public class PrintCombination {
	public static void print(List<List<Integer>> l) {
		for (List<Integer> ll : l) {
			for (Integer n : ll) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
