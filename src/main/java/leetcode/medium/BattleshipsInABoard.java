package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/battleships-in-a-board/
 * 
 * @author shivam.maharshi
 */
public class BattleshipsInABoard {

  public static int countBattleships(char[][] board) {
    if (board == null || board.length == 0)
      return 0;

    int c = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'X') {
          c++;
          board[i][j] = '.';
          uv(board, i, j);
        }
      }
    }
    return c;
  }

  public static void uv(char[][] b, int y, int x) {
    int i = y + 1, j = x + 1;
    while (i < b.length) {
      if (b[i][x] == 'X') {
        b[i][x] = '.';
        i++;
      } else
        break;
    }

    while (j < b[0].length) {
      if (b[y][j] == 'X') {
        b[y][j] = '.';
        j++;
      } else
        break;
    }
  }

}
