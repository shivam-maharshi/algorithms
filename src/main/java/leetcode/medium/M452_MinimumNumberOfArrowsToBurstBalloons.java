package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link:
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 
 * @author shivam.maharshi
 */
public class M452_MinimumNumberOfArrowsToBurstBalloons extends TestCase {

  @Test
  public static void test() {
    assertEquals(2, findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
  }

  public static int findMinArrowShots(int[][] points) {
    int r = 0;
    Arrays.sort(points, new Comp());
    for (int i = 0; i < points.length;) {
      r++;
      int h = points[i][1];
      while (i < points.length && h >= points[i][0])
        h = Math.min(points[i++][1], h);
    }
    return r;
  }

  private static class Comp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
      return o1[0] < o2[0] ? -1 : 1;
    }
  }

}
