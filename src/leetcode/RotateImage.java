package leetcode;

/**
 * Link: https://leetcode.com/problems/rotate-image/
 * 
 * @author shivam.maharshi
 */
public class RotateImage {
  
  public static void main(String[] args) {
    int[][] m = {{1,2}, {3,4}};
    rotate(m);
  }

  public static void rotate(int[][] matrix) {
    swapAcrossHorizontalAxis(matrix);
    transpose(matrix);
  }

  public static void swapAcrossHorizontalAxis(int[][] m) {
    int l = 0, h = m.length - 1;
    while (l < h) {
      for (int i = 0; i < m.length; i++) {
        int temp = m[l][i];
        m[l][i] = m[h][i];
        m[h][i] = temp;
      }
      l++;
      h--;
    }
  }

  public static void transpose(int[][] m) {
    for (int i = 0; i < m.length; i++) {
      for (int j = i; j < m.length; j++) {
        int temp = m[i][j];
        m[i][j] = m[j][i];
        m[j][i] = temp;
      }
    }
  }

}
