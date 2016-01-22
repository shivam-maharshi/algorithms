package google;

/**
 * Add two big numbers using array.
 * 
 * Link: http://www.careercup.com/question?id=5631950045839360
 * 
 * @author shivam.maharshi
 */
public class BigNumAddUsingArray {

	public static int[] add(int[] a, int[] b) {
		int len = Math.max(a.length, b.length);
		int[] res = null;
		if (a.length == len) {
			res = addition(a, b);
		} else {
			res = addition(b, a);
		}
		printArr(res);
		return res;
	}

	private static void printArr(int[] res) {
		for (int n : res)
			System.out.print(n + " ");
	}

	private static int[] addition(int[] a, int[] b) {
		int[] res = new int[a.length + 1];
		int carry = 0;
		int i = a.length - 1;
		int j = b.length - 1;
		while (j >= 0) {
			int digitSum = a[i] + b[j] + carry;
			res[i + 1] = digitSum % 10;
			carry = digitSum / 10;
			i--;
			j--;
		}
		while (i >= 0) {
			int digitSum = a[i] + carry;
			res[i + 1] = digitSum % 10;
			carry = digitSum / 10;
			i--;
		}
		res[0] = carry;
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 9, 9, 2 };
		int[] b = { 0, 1, 3 };
		add(a, b);
	}

}
