package sorting;

/**
 * Sort a given array using Quick sort.
 *
 * Link: http://geeksquiz.com/quick-sort/
 * 
 * @author shivam.maharshi
 */
public class QuickSort {

	public static int[] sort(int[] a) {
		sort(a, 0, a.length - 1);
		return a;
	}

	private static void sort(int[] a, int l, int h) {
		if (l < h) {
			// int p = lowPar(a, l, h);
			// int p = highPar(a, l, h);
			int p = midPar(a, l, h);
			sort(a, l, p - 1);
			sort(a, p + 1, h);
		}
	}

	// This is partitioning around the median element as pivot.
	private static int medPar(int[] a, int l, int h) {
		return 0;
	}
	
	// This is partitioning around mid element as pivot.
	private static int midPar(int[] a, int l, int h) {
		int pivot = l + ((h - l) / 2);
		int val = a[pivot];
		int i = l;
		int j = h;
		while (i < j) {
			if (a[i] < val) {
				i++;
			} else if (a[j] > val) {
				j--;
			} else {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		return i - 1;
	}

	// This is partitioning around the last element as pivot.
	private static int highPar(int[] a, int l, int h) {
		int pivot = h;
		int i = l;
		int j = l;
		while (j < h) {
			if (a[j] < a[pivot]) {
				swap(a, i, j);
				i++;
			}
			j++;
		}
		swap(a, i, j);
		return i;
	}

	// This is partitioning around the first element as pivot.
	private static int lowPar(int[] a, int l, int h) {
		int pivot = l;
		int i = l;
		int j = l + 1;
		while (j <= h) {
			if (a[pivot] > a[j]) {
				i++;
				swap(a, i, j);
			}
			j++;
		}
		swap(a, pivot, i);
		return i;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 4, 1, 5, 9, 2 };
		sort(a);
		for (int aa : a)
			System.out.print(aa + " ");
	}

}
