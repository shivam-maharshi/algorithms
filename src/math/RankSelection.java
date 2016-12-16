package math;

/**
 * Find the smallest i numbers from a list of n numbers.
 * 
 * TODO: Correct this.
 * 
 * @author shivam.maharshi
 */
public class RankSelection {

  // TODO: Correct this!
	public static int[] smallestNumbers(int[] arr, int num) {
		int[] s = new int[num];
		int pivot = partition(arr, num, 0, arr.length - 1);
		for (int i = 0; i < pivot; i++) {
			System.out.println(arr[i]);
			s[i] = arr[i];
		}
		return s;
	}

	static int partition(int[] arr, int num, int low, int high) {
		int pivot = (low + high) / 2;
		while (low <= pivot && pivot < high) {
			if (arr[low] > arr[pivot] && arr[high] < arr[pivot]) {
				swap(arr, low, high);
				low++;
				high--;
			}
			if (arr[low] < arr[pivot]) {
				low++;
			}
			if (arr[high] > arr[pivot]) {
				high--;
			}
		}

		while (low < pivot) {
			if (arr[low] > arr[pivot]) {
				swap(arr, low, pivot);
			}
		}

		while (high > pivot) {
			if (arr[high] < arr[pivot]) {
				swap(arr, high, pivot);
			}
		}

		if (pivot == num) {
			System.out.println("Partition : " + pivot);
			return pivot;
		}
		if (pivot < num) {
			return partition(arr, num - pivot, pivot + 1, high);
		} else {
			return partition(arr, num, low, pivot - 1);
		}
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 4, 6, 9, 1 };
		RankSelection.smallestNumbers(arr, 5);
	}

}
