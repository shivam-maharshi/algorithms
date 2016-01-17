package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question in VMWare.
 * 
 * @author shivam.maharshi
 */
public class Solution {

	static int MinimalCost(int n, String[] pairs) {
		int res = 0;
		int[] map = new int[n + 1];
		Arrays.fill(map, -1);
		Arrays.sort(pairs);
		for (String s : pairs) {
			String[] ss = s.split(" ");
			int a = Integer.valueOf(ss[0]);
			int b = Integer.valueOf(ss[1]);
			if (map[a] == -1) {
				map[a] = a;
				map[b] = a;
			} else {
				map[b] = map[a];
			}
		}

		List<Integer> count = new ArrayList<Integer>();
		boolean[] v = new boolean[n+1];

		for (int i = n - 1; i > 0; i--) {
			int c = 0;
			int index = 0;
			if (!v[i]) {
				v[i] = true;
				c++;
				index = i;
				while (index != -1 && index != map[index]) {
					c++;
					v[index] = true;
					index = map[index];
				}
				count.add(c);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!v[i]) {
				res++;
			}
		}
		for (int c : count) {
			res += Math.sqrt(c);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] s = new String[] { "1 2", "1 4" };
		MinimalCost(4, s);
	}

}
