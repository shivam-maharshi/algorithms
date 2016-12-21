package sorting;

/**
 * Return the indices m, n of the array, which when sorted, the whole array will
 * be sorted. Minimize m & n.
 * 
 * Link:
 * http://www.geeksforgeeks.org/minimum-length-unsorted-subarray-sorting-which-
 * makes-the-complete-array-sorted/
 * 
 * @author shivam.maharshi
 */
public class IndicesToSortCompleteArray {

	public static Indices findIndicesToSort(int[] arr) {
		Indices indices = findUnsortedMiddleArray(arr);
		if (indices.higher == 0 && indices.lower == 0)
			return indices;
		Indices result = new Indices(0, 0);
		int max = findMax(arr, indices);
		int min = findMin(arr, indices);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > min) {
				result.lower = i;
				break;
			}
		}
		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] < max) {
				result.higher = j;
				break;
			}
		}
		return result;
	}

	public static Indices findUnsortedMiddleArray(int[] arr) {
		int lowMax = Integer.MIN_VALUE, highMin = Integer.MAX_VALUE, i = 0, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] >= arr[j] || (arr[i] < lowMax && arr[j] > highMin) || lowMax > highMin) {
				return new Indices(i, j);
			} else {
				if (arr[i] < lowMax) {
					highMin = arr[j];
					j--;
				} else {
					lowMax = arr[i];
					i++;
				}
			}
		}
		return new Indices(0, 0);
	}

	static int findMax(int[] arr, Indices indices) {
		int max = Integer.MIN_VALUE;
		for (int i = indices.lower; i <= indices.higher; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	static int findMin(int[] arr, Indices indices) {
		int min = Integer.MAX_VALUE;
		for (int i = indices.lower; i <= indices.higher; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
		System.out.println(IndicesToSortCompleteArray.findIndicesToSort(arr));
	}

}

class Indices {
	int lower;
	int higher;

	public Indices(int lower, int higher) {
		this.lower = lower;
		this.higher = higher;
	}

	@Override
	public String toString() {
		return "Indices [lower=" + lower + ", higher=" + higher + "]";
	}

}
