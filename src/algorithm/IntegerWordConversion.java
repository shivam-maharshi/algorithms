package algorithm;

import java.util.ArrayList;
import java.util.List;

public class IntegerWordConversion {
	static String[] digit = new String[] { " zero ", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine" };
	static String[] een = new String[] { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
			"seventeen", "eighteen", "nineteen" };
	static String[] second = new String[] { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy",
			"eighty", "ninety" };
	static String[] big = new String[] {"", " thousand ", " million ", " billion " };

	// Convert an integer to word.

	public static String convertWord(int val) {

		List<String> list = new ArrayList<String>();
		int inc = 0;
		while (val != 0) {
			list.add(big[inc]);
			inc++;
			convert(val % 1000, list);
			val = val / 1000;
		}

		String res = "";
		for (int i = list.size() - 1; i > -1; i--) {
			res += list.get(i);
		}
		return res;
	}

	public static void convert(int val, List<String> list) {
		String hund = "";
		if (val / 100 != 0) {
			hund = digit[val / 100] + " hundred and ";
		}
		val = val % 100;
		String dig = digit[val % 10];
		if (val / 10 == 0) {
			list.add(dig);
			list.add(hund);
			return;
		} else {
			if (!dig.equals("zero")) {
				list.add(dig);
			}
			if (val >= 10 && val % 100 <= 19) {
				list.add(een[val / 10]);
			} else {
				list.add(second[val / 10]);
			}
			list.add(hund);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(IntegerWordConversion.convertWord(123456789));
	}

}
