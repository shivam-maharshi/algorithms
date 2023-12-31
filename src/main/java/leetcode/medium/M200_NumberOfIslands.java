package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/number-of-islands
 * 
 * @author shivam.maharshi
 */
public class M200_NumberOfIslands extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
        { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
    assertEquals(3, numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
        { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
  }

  public static int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;
    int[] r = new int[1];
    boolean[][] v = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++)
      for (int j = 0; j < grid[0].length; j++)
        parse(grid, v, i, j, r, false);
    return r[0];
  }

  public static void parse(char[][] a, boolean[][] v, int i, int j, int[] r, boolean counted) {
    if (i < 0 || j < 0 || i >= v.length || j >= v[0].length || v[i][j])
      return;
    if (!v[i][j]) {
      v[i][j] = true;
      if (a[i][j] == '1') {
        if (!counted) {
          r[0]++;
          counted = true;
        }
        parse(a, v, i + 1, j, r, counted);
        parse(a, v, i, j + 1, r, counted);
        parse(a, v, i - 1, j, r, counted);
        parse(a, v, i, j - 1, r, counted);
      }
    }
  }

}
