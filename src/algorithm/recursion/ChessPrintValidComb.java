package algorithm.recursion;

import java.util.Arrays;

/* 
 * Print all possible combination of a chess board such that no two queens are on the same row, column or diagonal.
 */

public class ChessPrintValidComb {

	public static void printAllWays(int[] rows, int curRow) {
		if (curRow == 8) {
			printCombination(rows);
			Arrays.fill(rows, 0);
		} else {
			for (int col = 0; col < 8; col++) {
				if (isValidMove(rows, curRow, col)) {
					rows[curRow] = col;
					printAllWays(rows, ++curRow);
				}
			}
		}
	}

	public static void printCombination(int[] rows) {
		for (int i = 0; i < rows.length; i++) {
			System.out.print("(" + i + "," + rows[i] + ")");
		}
		System.out.println("");
	}

	public static boolean isValidMove(int[] rows, int curRow, int col) {
		boolean flag = true;
		for (int i = 0; i < curRow; i++) {
			if ((rows[i] == col) || Math.abs(curRow - i) == Math.abs(rows[i] - col)) {
				return false;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		int[] rows = new int[8];
		for (int i = 0; i < 8; i++) {
			ChessPrintValidComb.printAllWays(rows, i);
			Arrays.fill(rows, 0);
		}
	}

}
