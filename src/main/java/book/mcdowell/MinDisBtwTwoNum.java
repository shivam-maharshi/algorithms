package book.mcdowell;

/**
 * Find the minimum distance between two numbers. Given an unsorted array arr[]
 * and two numbers x and y, find the minimum distance between x and y in arr[].
 * The array might also contain duplicates. You may assume that both x and y are
 * different and present in arr[].
 * 
 * Link:
 * http://www.geeksforgeeks.org/find-the-minimum-distance-between-two-numbers/
 * 
 * @author shivam.maharshi
 */
public class MinDisBtwTwoNum {

	public static int get(int[] a, int x, int y) {
		int t = 0, i = 0, min = Integer.MAX_VALUE;
		
		for (int j = 0; j < a.length; j++) {
			if (a[j] == x || a[j] == y) {
				i = j;
				t = a[j];
				break;
			}
		}
		
		for (int j = i+1; j < a.length; j++) {
			if (a[j] == x || a[j] == y) {
				if (a[j] != t) {
					min = Math.min(min, j - i);
					t = a[j];
					i = j;
				} else {
					i = j;
				}
			}
		}
		System.out.println(min);
		return min;
	}

	public static void main(String[] args) {
		int[] a = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3};
		get(a, 3, 6);
	}

}
