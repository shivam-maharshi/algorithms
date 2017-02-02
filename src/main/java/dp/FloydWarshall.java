package dp;

/**
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * 
 * @author shivam.maharshi
 */
public class FloydWarshall {

  public static void main(String[] args) {
    get(new int[][] { { 0, 5, Integer.MAX_VALUE, 10 }, { Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
        { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 1 },
        { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } });
  }

  public static int[][] get(int[][] g) {
    int r[][] = new int[g.length][g.length];
    for (int i = 0; i < g.length; i++)
      for (int j = 0; j < g.length; j++)
        r[i][j] = g[i][j];
    for (int k = 0; k < g.length; k++)
      for (int i = 0; i < g.length; i++)
        for (int j = 0; j < g.length; j++)
          if (g[i][j] > g[i][k] + g[k][j])
            r[i][j] = g[i][k] + g[k][j];
    print(r);
    return r;
  }

  public static void print(int[][] r) {
    for (int[] rr : r) {
      for (int n : rr)
        System.out.print(n + " ");
      System.out.println();
    }
  }

}
