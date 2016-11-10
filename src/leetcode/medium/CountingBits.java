package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/counting-bits/
 * 
 * @author shivam.maharshi
 */
public class CountingBits {
  
  public static void main(String[] args) {
    countBits(13);
  }

  public static int[] countBits(int num) {
    int[] r = new int[num + 1];
    r[0] = 0;
    if (num != 0) {
      r[1] = 1;

      int i = 2, p = 2, diff = 2;

      while (i <= num) {
        if (diff == 0) {
          p *= 2;
          diff = p;
        }
        r[i] = r[i - diff] + 1;
        diff--;
        i++;
      }

    }
    return r;
  }

}
