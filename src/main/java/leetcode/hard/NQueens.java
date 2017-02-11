package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/n-queens/
 * 
 * @author shivam.maharshi
 */
public class NQueens extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, solveNQueens(1).size());
    assertEquals(0, solveNQueens(2).size());
    assertEquals(0, solveNQueens(3).size());
    assertEquals(2, solveNQueens(4).size());
    assertEquals(10, solveNQueens(5).size());
    assertEquals(92, solveNQueens(8).size());
    assertEquals(724, solveNQueens(10).size());
  }

  public static List<List<String>> solveNQueens(int n) {
    List<List<String>> r = new ArrayList<List<String>>();
    boolean[][] m = new boolean[n][n];
    get(m, 0, r);
    return r;
  }

  public static void get(boolean[][] a, int i, List<List<String>> r) {
    if (i == a.length) {
      add(a, r);
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

  public static void add(boolean[][] a, List<List<String>> l) {
    List<String> ll = new ArrayList<String>();
    for (int i = 0; i < a.length; i++) {
      String s = "";
      for (int j = 0; j < a.length; j++)
        s += a[i][j] ? "Q" : ".";
      ll.add(s);
    }
    l.add(ll);
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
