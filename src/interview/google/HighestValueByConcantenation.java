package interview.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of integers find the highest value that can be formed by
 * concantenating them.
 * 
 * Link: http://www.careercup.com/question?id=5723915160649728
 * 
 * @author shivam.maharshi
 */
public class HighestValueByConcantenation {

	public static void getHighest(int[] a) {
		List<Integer> list = new ArrayList<>();
		for (int aa : a)
			list.add(aa);
		Collections.sort(list, new ConComp());
		for (int aa : list)
			System.out.print(aa);
	}

	public static void main(String[] args) {
		// int[] a = {9, 918, 917};
		int[] a = { 1, 112, 113 };
		getHighest(a);
	}

}

class ConComp implements java.util.Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		while (o1 != 0) {
			l1.add(o1 % 10);
			o1 = o1 / 10;
		}
		while (o2 != 0) {
			l2.add(o2 % 10);
			o2 = o2 / 10;
		}
		int i = l1.size() - 1;
		int j = l2.size() - 1;
		while (i >= 0 && j >= 0) {
			if (l1.get(i) > l2.get(j))
				return -1;
			else if (l1.get(i) < l2.get(j))
				return 1;
			i--;
			j--;
		}
		if (i != -1) {
			int lastDigit = l1.get(i + 1);
			while (i >= 0) {
				if (l1.get(i) < lastDigit)
					return 1;
				else if (l1.get(i) > lastDigit)
					return -1;
				i--;
			}
		}
		if (j != -1) {
			int lastDigit = l2.get(j + 1);
			while (j >= 0) {
				if (l2.get(j) < lastDigit)
					return -1;
				else if (l2.get(j) > lastDigit)
					return 1;
				j--;
			}
		}
		return 0;
	}

}
