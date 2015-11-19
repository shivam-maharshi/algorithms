package array;

// Given an array reverse the consecutive positive numbers between -ve numbers.
public class ReversePositiveNumbers {

	public static int[] reverse(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		int i = 0, j = 1;
		while (j < arr.length) {
			if (arr[j] <= 0) {
				if (i != j - 1) {
					if(arr[i]<=0) {
						i++;
					}
					reverse(arr, i, j-1);
				}
				/*
				 * Print it or whatever because the array has already been
				 * reversed.
				 */
				i = ++j;
			}
			j++;
		}
		return arr;
	}

	private static void reverse(int[] arr, int i, int j) {
		while (j > i) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, 8, 9, -2, 6, 10, 13, 4, 5, -9, 0, -2 };
		ReversePositiveNumbers.reverse(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
