package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/surrounded-regions/
 * 
 * @author shivam.maharshi
 */
public class SurroundedRegions extends TestCase {

  @Test
  public static void test() {
    char[][] c = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
        { 'X', 'O', 'X', 'X' } };
    solve(c);
    assertEquals('X', c[1][1]);
    assertEquals('X', c[1][2]);
    assertEquals('X', c[2][2]);
    assertEquals('O', c[3][1]);
  }

  public static void solve(char[][] board) {
    if (board == null || board.length == 0)
      return;
    boolean[][] v = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      parse(board, v, i, 0);
      parse(board, v, i, board[0].length - 1);
    }
    for (int i = 0; i < board[0].length; i++) {
      parse(board, v, 0, i);
      parse(board, v, board.length - 1, i);
    }
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if (!v[i][j] && board[i][j] == 'O')
          board[i][j] = 'X';
  }

  public static void parse(char[][] a, boolean[][] v, int i, int j) {
    if (!v[i][j] && a[i][j] == 'O') {
      v[i][j] = true;
      if (i < a.length - 1)
        parse(a, v, i + 1, j);
      if (j < a[0].length - 1)
        parse(a, v, i, j + 1);
      if (i > 1)
        parse(a, v, i - 1, j);
      if (j > 1)
        parse(a, v, i, j - 1);
    }
  }

}
