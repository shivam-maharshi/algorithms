package leetcode.medium;

import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 
 * @author shivam.maharshi
 */
public class M378_KthSmallestElementInASortedMatrix extends TestCase {

  @Test
  public static void test() {
    int[][] m = new int[][] { { 1, 5, 9 }, { 3, 6, 13 }, { 12, 13, 15 } };
    assertEquals(13, kthSmallest(m, 8));
    m = new int[][] { { 8, 9 }, { 9, 13 } };
    assertEquals(8, kthSmallest(m, 1));
    m = new int[][] { { 1, 3, 5 }, { 6, 7, 12 }, { 11, 14, 14 } };
    assertEquals(5, kthSmallest(m, 3));
  }

  // Done for square matrix.
  public static int kthSmallest(int[][] matrix, int k) {
    Queue<Row> q = new PriorityQueue<>();
    
    for (int i=0; i<matrix.length; i++)
      q.add(new Row(i, 0, matrix[i][0]));
    
    Row e = null; 
    while(k > 0) {
      k--;
      e = q.poll();
      if (e.c + 1 < matrix.length)
        q.add(new Row(e.r, e.c + 1, matrix[e.r][e.c + 1]));
    }
    return e.v;
  }

  private static class Row implements Comparable<Row> {
    int r;
    int c;
    int v;

    public Row(int r, int c, int v) {
      this.r = r;
      this.c = c;
      this.v = v;
    }

    @Override
    public int compareTo(Row o) {
      return this.v < o.v ? -1 : 1;
    }

  }

}
