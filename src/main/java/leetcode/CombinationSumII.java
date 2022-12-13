package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/combination-sum-ii/
 * 
 * @author shivam.maharshi
 */
public class CombinationSumII {

	public static void main(String[] args) {
		int[] c = new int[] { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> l = combinationSum2(c, 8);
		print(l);
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		PopList pop = new PopList();
		Arrays.sort(candidates);
		List<Integer> n = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		pop.popLists(candidates, n, c);
		List<List<Integer>> l = new ArrayList<List<Integer>>();
		getCombinations(n, c, target, 0, l, new ArrayList<Integer>());
		return l;
	}
	
	public static void print(List<List<Integer>> l) {
		for (List<Integer> ll : l) {
			for (Integer n : ll) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	public static void getCombinations(List<Integer> n, List<Integer> c, int t, int i, List<List<Integer>> l,
			List<Integer> res) {
		if (t == 0) {
			l.add(new ArrayList<>(res));
			return;
		}

		for (int j = i; j < n.size(); j++) {
			if (t >= n.get(j)) {
				res.add(n.get(j));
				c.set(j, c.get(j) - 1);
				if (c.get(j) > 0)
					getCombinations(n, c, t - n.get(j), j, l, res);
				else
					getCombinations(n, c, t - n.get(j), j + 1, l, res);
				c.set(j, c.get(j) + 1);
				res.remove(res.size() - 1);
			} else
				return;
		}
	}

}
