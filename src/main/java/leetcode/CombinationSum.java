package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/combination-sum/
 * 
 * @author shivam.maharshi
 */
public class CombinationSum {

	public static void main(String[] args) {
		PrintCombination print = new PrintCombination();
		int[] c = new int[] { 2, 3, 6, 7 };
		List<List<Integer>> l = combinationSum(c, 7);
		print.print(l);
	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		getCombinations(candidates, target, 0, l, new ArrayList<Integer>());
		return l;
	}

	public static void getCombinations(int[] c, int t, int i, List<List<Integer>> l, List<Integer> res) {
		if (t == 0) {
			l.add(new ArrayList<>(res));
			return;
		}

		for (int j = i; j < c.length; j++) {
			if (t >= c[j]) {
				res.add(c[j]);
				getCombinations(c, t - c[j], j, l, res);
				res.remove(res.size() - 1);
			} else
				return;
		}
	}

}
