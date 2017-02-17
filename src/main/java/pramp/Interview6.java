package pramp;

/**
 * Given a matrix with 1 signifying a land and 0 the water, find the number of
 * islands. You can only move horizontal and vertical not diagonally.
 * 
 * @author shivam.maharshi
 */
public class Interview6 {

  private static int[][] c = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

  public static void main(String[] args) {
    String pramp = "Practice Makes Perfect";
    System.out.println(pramp);

  }

  public static int getIslands(int[][] a) {
    if (a == null || a.length == 0 || a[0].length == 0)
      return 0;
    int[] r = new int[1];
    boolean[][] v = new boolean[a.length][a[0].length];
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        dfs(a, v, r, i, j, false);
      }
    }
    return r[0];
  }

  public static void dfs(int[][] a, boolean[][] v, int[] r, int i, int j, boolean isCounted) {
    if (i < 0 || j < 0 || i >= a.length || j >= a[0].length)
      return;
    if (a[i][j] == 1 && !v[i][j] && !isCounted) {
      r[0]++;
      isCounted = true;
    }

    v[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int x = i + c[k][0], y = j + c[k][1];
      dfs(a, v, r, x, y, isCounted);
    }

  }

}
