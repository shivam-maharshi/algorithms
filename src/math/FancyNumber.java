package math;

import java.util.HashMap;

// Find if a number is fancy. A number is fancy when it is rotated by 180 degrees and it still remains the same.
public class FancyNumber {

	private static HashMap<Integer, Integer> fancyMap = new HashMap<>();

	private static void init() {
		fancyMap.put(0, 0);
		fancyMap.put(1, 1);
		fancyMap.put(6, 9);
		fancyMap.put(8, 8);
		fancyMap.put(9, 6);
	}

	public static boolean isFancy(int num) {
		init();
		int n = num;
		int revNum = 0;
		while (n != 0) {
			revNum *= 10;
			revNum += n % 10;
			n = n / 10;
		}
		System.out.println("RevNum : " + revNum);
		while (num != 0) {
			if (fancyMap.get(num % 10) == null || fancyMap.get(num % 10) != revNum % 10)
				return false;
			num /= 10;
			revNum /= 10;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(FancyNumber.isFancy(121));
	}

}
