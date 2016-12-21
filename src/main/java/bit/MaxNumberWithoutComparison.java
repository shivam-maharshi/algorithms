package bit;

/*
 * Find the max between two numbers without using the comparison operator.
 */

public class MaxNumberWithoutComparison {

	public static int max(int x, int y) {
		int z = x - y;
		int i = (z >> 31) & 0x1;
		int max = x - i * z;
		return max;
	}

	int flip(int a) {
		return 1 ^ a;
	}

	int sign(int a) {
		return a >> 31;
	}

	public static void main(String[] args) {
		System.out.println(max(10, 5));
	}

}
