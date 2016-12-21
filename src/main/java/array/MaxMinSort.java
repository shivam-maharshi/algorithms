package array;

/**
 * Sort an array in the maximum and minimum form. Hence an array like
 * 1,2,3,4,5,6,7 should become 7,1,6,2,5,3,4. Doing this with auxiliary space is
 * trivial. Hence do it in space.
 * 
 * Link: http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 * 
 * @author shivam.maharshi
 */
public class MaxMinSort {

	public static void sort(int[] a) {
		int len = a.length;
		int j = 0;
		for (int i=0; i < len; i++) {
			int temp = a[i];
			while (temp > 0) {
				if (i < len / 2)
					j = 2 * i + 1;
				else
					j = (len - 1 - i) * 2;
				if(i==j) {
					a[i]=-temp;
					break;
				}
				swap(temp, a[j]);
				a[j] = -1*a[j];
				i=j;
			}
		}
		for (int n : a)
			System.out.print(n + " ");
	}
	
	public static void swap(int temp, int a) {
		int swap = a;
		temp = a;
		a = swap;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		sort(a);
	}

}
