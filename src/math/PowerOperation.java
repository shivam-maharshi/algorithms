package math;

/**
 * Write power operation without using multiplication or division.
 * 
 * Link:
 * http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication
 * -and-division/
 * 
 * @author shivam.maharshi
 */
public class PowerOperation {

  public static int get(int n, int pow) {
    int a = n;
    int b = n;
    for (int i = 1; i < pow; i++) {
      for (int j = 1; j < n; j++) {
        a += b;
      }
      b = a;
    }
    System.out.println(a);
    return a;
  }

  /*
   * Converges logarithmically. To avoid using multiplication operator, just run
   * a for loop with addition.
   */
  public static int pow(int n, int pow) {
    if (n == 1 || pow == 0)
      return 1;
    if (pow == 1)
      return n;
    else if (pow % 2 == 0)
      return pow(n * n, pow / 2);
    else
      return n * pow(n * n, (pow - 1) / 2);
  }

  public static void main(String[] args) {
    PowerOperation.get(5, 6);
    System.out.println(pow(5, 6));
  }

}
