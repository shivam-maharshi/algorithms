package leetcode;

/**
 * Link: https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * @author shivam.maharshi
 */
public class SpiralMatrixII {
  
  public static void main(String[] args) {
    int[][] m = generateMatrix(3);
    for (int[] mm : m)
      for (int nm : mm)
        System.out.print(nm + " ");
  }

  public static int[][] generateMatrix(int n) {
    int[][] m = new int[n][n];

    if (n == 0)
      return m;

    int cn = 1, r = n, c = n, x = 0, y = 0;

    while (r > 0 && c > 0) {

      // Move only right.
      if (r == 1) {
        for (int i = 0; i < c; i++)
          m[y][x++] = cn++;
        break;
      }
      
      // Move only down.
      if (c == 1) {
        for (int i = 0; i < r; i++)
          m[y++][x] = cn++;
        break;
      }

      // Move only right.
      for (int i = 0; i < c - 1; i++)
        m[y][x++] = cn++;
      
      
      for (int i = 0; i < r - 1; i++)
        m[y++][x] = cn++;
      
      for (int i = 0; i < c - 1; i++)
        m[y][x--] = cn++;
      
      for (int i = 0; i < r - 1; i++)
        m[y--][x] = cn++;
      
      x++;
      y++;
      r -= 2;
      c -= 2;
    }

    return m;
  }

}
