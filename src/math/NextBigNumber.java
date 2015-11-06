package math;

// Given a number print the next big number using the same digits.
public class NextBigNumber {
	static int[] num;

	public static void getNext() {
		int fIndex = 0;
		for (int i = num.length - 2; i <= 0; i--) {
			if (num[i] < num[i + 1]) {
				fIndex = i;
			}
		}
		for (int i = num.length - 1; i > fIndex; i--) {
			if (num[i] > num[fIndex]) {
				swap(i, fIndex);
			}
		}
		int i = num.length - 1;
		int j = fIndex+1;
		while (i > j) {
			swap(i,j);
			i--;
			j++;
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
		NextBigNumber.getNext();
	}

}
