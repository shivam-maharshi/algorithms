package leetcode.hard;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/n-queens-ii
 * 
 * @author shivam.maharshi
 */
public class H52_NQueensII extends TestCase {

  @Test
  public static void test() {
    assertEquals(0, totalNQueens(0));
    assertEquals(1, totalNQueens(1));
    assertEquals(0, totalNQueens(2));
    assertEquals(0, totalNQueens(3));
    assertEquals(2, totalNQueens(4));
    assertEquals(10, totalNQueens(5));
    assertEquals(92, totalNQueens(8));
    assertEquals(724, totalNQueens(10));
  }

  public static int totalNQueens(int n) {
    int[] r = new int[1];
    boolean[][] m = new boolean[n][n];
    get(m, 0, r);
    return r[0];
  }

  public static void get(boolean[][] a, int i, int[] r) {
    if (i == a.length) {
      r[0]++;
      return;
    }
    for (int j = 0; j < a.length; j++) {
      if (isValidMove(a, i, j)) {
        a[i][j] = true;
        get(a, i + 1, r);
        a[i][j] = false;
      }
    }
  }

  public static boolean isValidMove(boolean[][] a, int row, int col) {
    int n = a.length;
    for (int i = 0; i < n; i++)
      if (a[row][i] || a[i][col])
        return false;
    for (int i = 0; i < n; i++) {
      if ((isValid(n, row + i, col - i) && a[row + i][col - i]) || (isValid(n, row - i, col + i) && a[row - i][col + i])
          || (isValid(n, row - i, col - i) && a[row - i][col - i])
          || (isValid(n, row + i, col + i) && a[row + i][col + i]))
        return false;
    }
    return true;
  }

  public static boolean isValid(int n, int row, int col) {
    return row > -1 && col > -1 && row < n && col < n;
  }

}
