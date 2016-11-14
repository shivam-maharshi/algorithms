package math;

/**
 * Print all the possible combination of how a number can be broken as sum of 1,
 * 2 or 3. Ordering is important.
 * 
 * Link:
 * http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication
 * -and-division/
 * 
 * @author shivam.maharshi
 */
public class PrintAllNumberCombination {

  public static void print(int n, String s) {
    if (n == 0)
      System.out.println(s);
    if (n < 0)
      return;
    print(n - 1, s + "  " + 1);
    print(n - 2, s + "  " + 2);
    print(n - 3, s + "  " + 3);
  }

  public static void main(String[] args) {
    PrintAllNumberCombination.print(4, "");
  }

}
