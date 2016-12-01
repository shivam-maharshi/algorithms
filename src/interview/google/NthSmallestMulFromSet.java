package interview.google;

import java.util.TreeMap;

/**
 * Find the n-th smallest multiple given a set of numbers. For example, set =
 * {4, 6}, n = 6. The sequence is: 4, 6, 8, 12, 16, 18, etc... Answer is 18.
 * 
 * Link: http://www.careercup.com/question?id=5686055997014016
 * 
 * @author shivam.maharshi
 */
public class NthSmallestMulFromSet {

	// O(n*log(m)). M is size of set.
	public static int get(int[] set, int n) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int a : set) {
			map.put(a, a);
		}
		int num = 0;
		while (n > 0) {
			num = map.firstKey();
			int value = map.get(num);
			map.remove(num);
			if (!map.containsKey(num + value)) {
				map.put(num + value, value);
			} else {
				map.put(num + 2 * value, value);
			}
			n--;
		}
		System.out.println(num);
		return num;
	}

	public static void main(String[] args) {
		int[] set = { 2, 3 };
		get(set, 6);
	}

}
