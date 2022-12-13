package leetcode;

import java.util.List;

public class PopList {
	public static void popLists(int[] c, List<Integer> n, List<Integer> cn) {
		if (c.length > 0) {
			n.add(c[0]);
			cn.add(1);
		}

		for (int i = 1; i < c.length; i++) {
			if (c[i - 1] == c[i]) {
				cn.set(cn.size() - 1, cn.get(cn.size() - 1) + 1);
			} else {
				n.add(c[i]);
				cn.add(1);
			}
		}
	}
}
