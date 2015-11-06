package bit;

public class NextMinMax {

	/*
	 * Get the next max and min numbers with the same number of bit counts for 1
	 * or 0.
	 */
	public static void printNextMaxAndMin(int n) {

		int a = n, b = n;
		int firstZero = 0, nextOne = 0, firstOne = 0, nextZero = 0;

		while (a != 0) {
			if (a % 2 == 0)
				break;
			firstZero++;
			a = a >> 1;
		}

		while (a != 0) {
			if (a % 2 == 1)
				break;
			nextOne++;
			a = a >> 1;
		}

		nextOne = nextOne + firstZero;

		while (b != 0) {
			if (b % 2 == 1)
				break;
			firstOne++;
			b = b >> 1;
		}

		while (b != 0) {
			if (b % 2 == 0)
				break;
			nextZero++;
			b = b >> 1;
		}

		nextZero = nextZero + firstOne;

		System.out.println("Next Max : " + Integer.toBinaryString(swapBits(n, firstOne, nextZero)));
		System.out.println("Next Min : " + Integer.toBinaryString(swapBits(n, nextOne, firstZero)));
	}

	public static int swapBits(int n, int one, int zero) {
		int oneValue = (int) Math.pow(2, one);
		int zeroValue = (int) Math.pow(2, zero);
		return n - oneValue + zeroValue;
	}

	public static void main(String[] args) {
		NextMinMax.printNextMaxAndMin(Integer.valueOf("101", 2));
	}

}
