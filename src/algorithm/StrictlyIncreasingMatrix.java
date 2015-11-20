package algorithm;

/*
 * Find a number in a matrix that is strictly increasing, row and column wise. Print its location.
 */

public class StrictlyIncreasingMatrix {

	public static void findNum(int[][] arr, int num) {
		int row = 0;
		int col = arr[0].length - 1;
		while (col >= 0 && row < arr.length) {
			if (arr[row][col] == num) {
				System.out.println("Row : " + row + " , Col : " + col);
				return;
			} else if (num < arr[row][col]) {
				col--;
			} else {
				row++;
			}
		}
		System.out.println("Number not found.");
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2, 3, 4 }, { 50, 600, 7000, 8000 }, { 90, 1000, 11000, 12000 },
				{ 130, 1400, 15000, 16000 } };
		StrictlyIncreasingMatrix.findNum(arr, 15000);
	}

}
