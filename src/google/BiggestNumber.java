package google;

/**
 * Calculate the biggest number that can be formed by taking an average of two
 * consecutive numbers in a given number.
 * 
 * @author shivam.maharshi
 */
public class BiggestNumber {

  public static int calculate(int x) {
    int res = x < 10 ? x / 2 : 0;
    int[] n = array(x, len(x));
    for (int i = 0; i < n.length - 1; i++) {
      int temp = val(n, 0, i, 0) * 10;
      temp += ((n[i] + n[i + 1]) / 2);
      temp = val(n, i + 2, n.length, temp);
      res = Math.max(temp, res);
    }
    return res;
  }

  public static int val(int[] a, int l, int h, int val) {
    int res = val;
    for (int i = l; i < h; i++) {
      res *= 10;
      res += a[i];
    }
    return res;
  }

  public static int len(int x) {
    int l = 0;
    while (x != 0) {
      l++;
      x /= 10;
    }
    return l;
  }

  public static int[] array(int x, int l) {
    int[] a = new int[l];
    int i = l - 1;
    while (x != 0) {
      a[i] = x % 10;
      x /= 10;
      i--;
    }
    return a;
  }

  public static int array(int[] a, int l, int h, int v) {
    int i = l, res = v;
    while (i < h) {
      res = v + a[i];
      res *= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(calculate(9));
  }

}
