package math;

/**
 * Create a random number generator with equal probability from 1 to 7 using a
 * random number generator that gives number from 1 to 5.
 * 
 * Link: http://www.geeksforgeeks.org/generate-integer-from-1-to-7-with-equal-
 * probability/
 * 
 * @author shivam.maharshi
 */
public class Rand7FromRand5 {

  public static int rand_7() {
      int[][] vals = {
          { 1, 2, 3, 4, 5 },
          { 6, 7, 1, 2, 3 },
          { 4, 5, 6, 7, 1 },
          { 2, 3, 4, 5, 6 },
          { 7, 0, 0, 0, 0 }
      };

      int result = 0;
      while (result == 0)
      {
          int i = rand5();
          int j = rand5();
          result = vals[i-1][j-1];
      }
      return result;
  }

  public static int rand7() {
    int n = 5 * rand5() + rand5() - 5;
    while (n > 21) {
      n += 5 * rand5() + rand5() - 5;
    }
    return n % 7 + 1;
  }

  private static int rand5() {
    return (int) (5 * Math.random()) + 1;
  }

  public static void main(String[] args) {
    System.out.println(rand7());
    System.out.println(rand_7());
  }

}
