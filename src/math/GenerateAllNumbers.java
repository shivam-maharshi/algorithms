package math;

import java.util.Arrays;

/**
 *  Generate all numbers using the same digit as in the given numbers.
 * 
 * @author shivam.maharshi
 */
public class GenerateAllNumbers {

	public static void generate(int[] num) {
		generateRec(num, 0);
	}

	private static void generateRec(int[] num, int index) {
		if (index == num.length)
			return;
		generateRec(num, index+1);
		for (int i = index+1; i < num.length; i++) {
			int[] swapped = swap(num, index, i);
			generateRec(swapped, index+1);
		}
	}

	private static void printNum(int[] num) {
		String res = "";
		for (int i = 0; i < num.length; i++) {
			res += num[i];
		}
		System.out.println(res);
	}

	private static int[] swap(int[] num, int i, int j) {
		int[] arr = Arrays.copyOf(num, num.length);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return arr;
	}

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3 };
		GenerateAllNumbers.generate(num);
	}

}
