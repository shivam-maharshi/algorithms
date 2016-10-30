package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/spiral-matrix/
 * 
 * @author shivam.maharshi
 */
public class SpiralMatrix {

  public static void main(String[] args) {
    List<Integer> l = spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } });
    for (int n : l)
      System.out.print(n + " ");
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> l = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return l;
    
    int r = matrix.length, c = matrix[0].length, x = 0, y = 0;
    
    while (r > 0 && c > 0) {
      if (r == 1) {
        // Go right only.
        for (int i = 0; i < c; i++)
          l.add(matrix[y][x++]);
        
        break;
      } else if (c == 1) {
        // Go down only.
        for (int j = 0; j < r; j++)
          l.add(matrix[y++][x]);
        
        break;
      }

      // Create circle.

      // Move right.
      for (int i = 0; i < c - 1; i++)
        l.add(matrix[y][x++]);

      // Move down.
      for (int i = 0; i < r - 1; i++)
        l.add(matrix[y++][x]);

      // Move left.
      for (int i = 0; i < c - 1; i++)
        l.add(matrix[y][x--]);

      // Move up.
      for (int i = 0; i < r - 1; i++)
        l.add(matrix[y--][x]);

      x++;
      y++;

      c -= 2;
      r -= 2;
    }

    return l;
  }

}
