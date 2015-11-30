package math;

/**
 * Given a number print the next big number using the same digits.
 * 
 * @author shivam.maharshi
 */
public class NextBigNumber {
	static int[] num;

	public static void getNext() {
		if (num == null) {
			System.out.println("Invalid input.");
			return;
		}
		if (num.length == 1) {
			System.out.println(num[0]);
			return;
		}
		int i = num.length - 2;
		outer: while (i >= 0) {
			for (int j = num.length - 1; j > i; j--) {
				if (num[i] < num[j]) {
					swap(i, j);
					break outer;
				}
				if (i == 0 && j == 1) {
					System.out.println("This is the maximum number.");
					return;
				}
			}
			i--;
		}
		int j = num.length - 1;
		++i;
		while (i < j) {
			swap(i, j);
			--j;
			++i;
		}

		printNum(num);
	}

	private static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private static void printNum(int[] num) {
		String res = "";
		for (int i = 0; i < num.length; i++) {
			res += num[i];
		}
		System.out.println(res);
	}

	public static void main(String[] args) {
		NextBigNumber.num = new int[] { 1, 2, 3, 4, 5 };
		int i = 120;
		while (i != 0) {
			--i;
			System.out.println(i);
			NextBigNumber.getNext();
		}
	}

}
