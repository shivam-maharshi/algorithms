package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/search-a-2d-matrix
 * 
 * @author shivam.maharshi
 */
public class M74_SearchA2DMatrix {

  public static boolean searchMatrix(int[][] matrix, int target) {
    int i = matrix.length - 1, j = 0;
    while (i>-1 && j<matrix[0].length) {
      if (matrix[i][j] == target)
        return true;
      else if (matrix[i][j] > target) {
        i--;
        j = 0;
      } else
        j++;
    }
    return false;
  }

}
