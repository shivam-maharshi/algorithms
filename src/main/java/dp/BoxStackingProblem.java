package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a set of boxes find the maximum height that can be achieved by stacking
 * these boxes. The box above must be strictly smaller than the box below.
 * 
 * @author shivam.maharshi
 */
public class BoxStackingProblem {

  public static void main(String[] args) {
    int[][] box = { { 1, 2, 3 }, { 3, 4, 5 } };
    System.out.println(new BoxStackingProblem().stack(box));
  }

  // O(n^2). Can be improved to O(nLog(n)) with better LIS.
  public int stack(int[][] box) {
    // [height][length][width]
    int[][] b = new int[box.length * 3][3];
    for (int i = 0; i < box.length; i++) {
      b[3 * i] = box[i];
      b[3 * i + 1] = new int[] { box[i][2], box[i][0], box[i][1] };
      b[3 * i + 2] = new int[] { box[i][1], box[i][2], box[i][0] };
    }
    // O(nLog(n)).
    Arrays.sort(b, new BoxComp());

    int[] dp = new int[b.length];
    dp[0] = b[0][0];
    // LIS DP logic. - O(n^2).
    for (int i = 1; i < b.length; i++) {
      for (int j = 0; j < i; j++) {
        if (b[i][1] < b[j][1] && b[i][2] < b[j][2])
          dp[i] = Math.max(dp[i], b[i][0] + dp[j]);
        else
          dp[i] = Math.max(dp[i], b[i][0]); // Just itself.
      }
    }
    int height = 0;
    for (int i = 0; i < dp.length; i++)
      height = Math.max(height, dp[i]);
    return height;
  }

  class BoxComp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
      return o1[1] * o1[2] > o2[1] * o2[2] ? -1 : 1;
    }
  }

}
