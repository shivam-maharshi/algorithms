package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii
 * 
 * @author shivam.maharshi
 */
public class M240_SearchA2DMatrixII extends TestCase {

  @Test
  public void test() {
    assertEquals(true, searchMatrix(new int[][] { { 0 } }, 0));
    assertEquals(false, searchMatrix(new int[][] { { 0 } }, 1));
    assertEquals(true, searchMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 7));
    assertEquals(true, searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
        { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 7));
    assertEquals(false, searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
        { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 20));
    assertEquals(false, searchMatrix(null, 7));
    assertEquals(false, searchMatrix(new int[][] { {} }, 7));
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    int r = 0, c = matrix[0].length - 1;
    while (r < matrix.length && c > -1) {
      if (matrix[r][c] == target)
        return true;
      else if (matrix[r][c] > target)
        c--;
      else
        r++;
    }
    return false;
  }

}
