package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N balloons, if you burst ith balloon you get Ai−1∗Ai∗Ai+1 coins and
 * then (i-1)th and (i+1)th balloons become adjacent. Find maximum number of
 * coins you can gather. Assume that we have extra 1 at left most and right most
 * positions. (don't take in answer just for boundary positions). Hence if we
 * have left or right boundary positions we multiply 1.
 * 
 * Link: http://www.careercup.com/question?id=5719829237465088
 * 
 * @author shivam.maharshi
 */
public class BurstBaloons {

	public static int maxValue(int[] a) {
		int res = 0;
		List<Integer> list = new ArrayList<>();
		for (int num : a)
			list.add(num);
		while (list.size() > 3) {
			int min = getMinValue(list);
			int index = findIndexOfValue(list, min);
			if (!(index > 0 && index < (list.size() - 1))) {
				index = getMaxProductIndex(list);
			}
			res += list.get(index - 1) * list.get(index) * list.get(index + 1);
			list.remove(index);
		}
		res += list.get(0) * list.get(1) * list.get(2) + list.get(0) * list.get(2) + Math.max(list.get(0), list.get(2));
		System.out.println(res);
		return res;
	}

	private static int getMaxProductIndex(List<Integer> list) {
		int index = 0;
		int maxProd = Integer.MIN_VALUE;
		for (int i = 1; i < list.size() - 1; i++) {
			if (list.get(i - 1) * list.get(i) * list.get(i + 1) > maxProd) {
				maxProd = list.get(i - 1) * list.get(i) * list.get(i + 1);
				index = i;
			}
		}
		return index;
	}

	private static int getMinValue(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int num : list)
			if (num < min)
				min = num;
		return min;
	}

	private static int findIndexOfValue(List<Integer> list, int num) {
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) == num)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 8, 5, 6, 9, 3, 0, 2, 4, 1, 7 };
		// int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		maxValue(a);
	}

}
