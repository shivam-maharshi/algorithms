package recursion;

public class CountDecoding {

	public static int countDecoding(int[] digit, int n) {

		int res = 0;

		if (n == 0 || n == 1) {
			return 1;
		}

		res = countDecoding(digit, n - 1);

		if (digit[n] < 2 || (digit[n] == 2 && digit[n - 1] < 7)) {
			res += countDecoding(digit, n - 2);
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(CountDecoding.countDecoding(new int[] { 4,3,2,1 }, 3));
	}

}
