package math;

/**
 * Find the contiguous array largest sum.
 * 
 * @author shivam.maharshi
 */
public class ContiguousArrayLargestSum {

	public static int contiguousArrayLargestSum(int[] arr) {
		int max = 0, total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
			max = Math.max(max, total);
			if (total < 0) {
				total = 0;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, -8, -1, 2, 4, -2, 3 };
		System.out.println(ContiguousArrayLargestSum.contiguousArrayLargestSum(arr));
	}

}
