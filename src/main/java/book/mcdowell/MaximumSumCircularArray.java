package book.mcdowell;

/**
 * Find the maximum sum in the given circular array.
 * 
 * Link: http://www.geeksforgeeks.org/maximum-contiguous-circular-sum/
 * 
 * @author shivam.maharshi
 */
public class MaximumSumCircularArray {

	public static int circularArrayMaximumSum(int[] arr, int m) {

		int max = 0, sum = 0, first = 0, len = arr.length, next = m;

		if (len <= m) {
			for (int i = 0; i < len; i++) {
				sum += arr[i];
			}
			return sum;
		}

		for (int i = 0; i < m; i++) {
			sum += arr[i];
		}

		for (int i = m; i < len + m - 1; i++) {
			sum = sum - arr[first % len] + arr[next % len];
			if (sum > max) {
				max = sum;
			}
			first = i - m + 1;
			next = i + 1;
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(circularArrayMaximumSum(new int[] { 12, 0, 1, 5, 40, 2, 3, 10, 15, 12 }, 3));
	}

}
