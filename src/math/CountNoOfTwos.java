package math;

/*
 *  Given a number n, count the number of two’s present till that number.
 */

// !! This does not work correctly. This has to be done again.
public class CountNoOfTwos {

	public static int countNoOfTwo(int n) {
		if (n < 2)
			return 0;
		if (n >= 2 && n < 10)
			return 1;
		int power = findPower(n);
		int ld = findLastDigit(n, power);
		int subProb = (int) (n % Math.pow(10, power));
		int res = countNoOfTwo(subProb);
		if (ld > 2) {
			res += Math.pow(10, power);
		} else if (ld == 2) {
			res += subProb + 1;
		}
		return res;
	}

	static int findPower(int n) {
		int power = 0;
		while (n / 10 != 0) {
			power++;
			n = n / 10;
		}
		return power;
	}

	static int findLastDigit(int n, int power) {
		return (int) (n / Math.pow(10, power));
	}

}
