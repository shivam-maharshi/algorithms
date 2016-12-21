package hackerrank;

/**
 * Given the number of cuts as k, cut a given infinite cake into the maximum
 * pieces.
 * 
 * @author shivam.maharshi
 */
public class HalloweenParty {

  public static void main(String[] args) {
    int[] a = new int[] { 10000000 };
    int[] r = max_Chocolates(a);
    for (int rr : r)
      System.out.print(rr + " ");
  }

  public static int[] max_Chocolates(int[] arr) {
    int[] r = new int[arr.length];
    for (int i = 0; i < arr.length; i++)
      r[i] = max(arr[i]);

    return r;
  }

  public static int max(int n) {
    int x = n / 2;
    return (n - x) * x;
  }

}
