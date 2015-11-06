package bit;

public class BitManipulation {

	/*
	 * There are two 32 bit number - n and m. Two integers j and i where j > i.
	 * Insert m into n between these bit positions j and i.
	 */
	public static int insertNumber(int n, int m, int j, int i) {
		int mask = (int) (Math.pow(2, j - i + 1) - 1);
		mask = ~(mask << 2);
		m = m << i;
		return (n & mask) | m;
	}

	public static void main(String[] args) {
		int n = Integer.valueOf("10000001000", 2);
		int m = Integer.parseInt("11011", 2);
		int res = BitManipulation.insertNumber(n, m, 5, 1);
		System.out.println(Integer.toBinaryString(res));
	}

}
