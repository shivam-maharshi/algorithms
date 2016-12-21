package leetcode;

/**
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * @author shivam.maharshi
 */
public class SetMatrixZeroes {

  public static void main(String[] args) {
    int[][] m = new int[][] {{0,1,1,1,1,1}, {1,1,1,1,1,1}, {1, 1, 1, 1, 1, 1}};
    setZeroes(m);
  }

  /*
   * In place. Store whether first row or column needs to be set to zero, then
   * store the info for all other indexes in the first row and column to be set
   * to zero. Finally verify for the first row & column to be set to zero.
   */
  public static void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return;

    boolean frz = false, fcz = false;
    int m = matrix.length, n = matrix[0].length;

    for (int i = 0; i < m; i++)
      if (matrix[i][0] == 0) {
        fcz = true;
        break;
      }

    for (int i = 0; i < n; i++)
      if (matrix[0][i] == 0) {
        frz = true;
        break;
      }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }

    for (int i = 1; i < m; i++)
      if (matrix[i][0] == 0)
        for (int j = 0; j < n; j++)
          matrix[i][j] = 0;

    for (int i = 1; i < n; i++)
      if (matrix[0][i] == 0)
        for (int j = 0; j < m; j++)
          matrix[j][i] = 0;

    if (frz)
      for (int i = 0; i < n; i++)
        matrix[0][i] = 0;

    if (fcz)
      for (int i = 0; i < m; i++)
        matrix[i][0] = 0;

  }

}
