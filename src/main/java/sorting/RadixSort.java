package sorting;

/**
 * What if the elements are in range from 1 to n2? Radix Sort is the answer. In
 * linear time we can solve this. Here we have assumed the base as 10. For
 * linear time convert all the numbers into base n and then count sort them for
 * linear complexity.
 * 
 * Link: http://www.geeksforgeeks.org/radix-sort/
 * 
 * @author shivam.maharshi
 */
public class RadixSort {

	// For simplicity base is considered 10.
	public static int[] sort(int[] arr, int n) {
		int[][] a = convert(arr, n);
		int digit = a[0].length;
		// TODO:
		return null;
	}
	
	public static int[][] convert(int[] arr, int n) {
		int[][] a = new int[arr.length][(int) Math.log10(n)+1];
		for (int i = 0; i < a.length; i++) {
			int num = arr[i];
			int j = a[0].length - 1;
			while (num != 0) {
				a[i][j] = num % 10;
				num /= 10;
				j--;
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
		convert(arr, 802);
	}

}
