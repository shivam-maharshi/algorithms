package algorithm;

// Assumes uniform distribution of numbers. Gives average case O(log(log(n))). Given numbers are sorted too.
public class InterpolationSearch {

	public static int interpolationSearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		int mid;

		while (arr[high] != arr[low] && key >= arr[low] && key <= arr[high]) {
			mid = low + (key - arr[low]) * ((high - low) / (arr[high] - arr[low]));

			if (arr[mid] < key)
				low = mid + 1;
			else if (key < arr[mid])
				high = mid - 1;
			else
				return mid;
		}

		if (key == arr[low])
			return low;
		else
			return -1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 7, 9, 15, 20 };
		System.out.println(InterpolationSearch.interpolationSearch(arr, 7));
	}

}
