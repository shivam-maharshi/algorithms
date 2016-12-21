package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/game-of-life/
 * 
 * @author shivam.maharshi
 */
public class GameOfLife {

  public static void main(String[] args) {
    gameOfLife(new int[][] { { 1, 1, 0, 1, 0, 1 },
                             { 1, 0, 0, 1, 0, 0 },
                             { 0, 0, 0, 0, 1, 0 },
                             { 1, 0, 1, 0, 0, 0 },
                             { 0, 1, 0, 1, 0, 0 } });
  }

  public static void gameOfLife(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int n = getLiveNeighbors(board, i, j);
        if ((n == 2 || n == 3) && (board[i][j] & 1) == 1)
          board[i][j] = 3; // Set next bit.
        else if (n == 3 && (board[i][j] & 1) == 0)
          board[i][j] = 2; // Set next bit.
      }
    }
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        board[i][j] = board[i][j] >> 1;
  }

  public static int getLiveNeighbors(int[][] b, int r, int c) {
    int n = 0;
    n += isValid(b, r + 1, c) && (b[r + 1][c] & 1) == 1 ? 1 : 0;
    n += isValid(b, r + 1, c + 1) && (b[r + 1][c + 1] & 1) == 1 ? 1 : 0;
    n += isValid(b, r + 1, c - 1) && (b[r + 1][c - 1] & 1) == 1 ? 1 : 0;
    n += isValid(b, r, c + 1) && (b[r][c + 1] & 1) == 1 ? 1 : 0;
    n += isValid(b, r, c - 1) && (b[r][c - 1] & 1) == 1 ? 1 : 0;
    n += isValid(b, r - 1, c) && (b[r - 1][c] & 1) == 1 ? 1 : 0;
    n += isValid(b, r - 1, c - 1) && (b[r - 1][c - 1] & 1) == 1 ? 1 : 0;
    n += isValid(b, r - 1, c + 1) && (b[r - 1][c + 1] & 1) == 1 ? 1 : 0;
    return n;
  }

  public static boolean isValid(int[][] b, int r, int c) {
    return r > -1 && r < b.length && c > -1 && c < b[0].length;
  }

}
