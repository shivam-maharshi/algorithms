package dp;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://www.interviewbit.com/problems/evaluate-expression-to-true/
 * Link:
 * http://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/
 * 
 * @author shivam.maharshi
 */
public class EvaluateExpressionToTrue extends TestCase {

  @Test
  public static void test() {
    assertEquals(1, cnttrue("T|T"));
    assertEquals(0, cnttrue("F|F"));
    assertEquals(1, cnttrue("T|F"));
    assertEquals(1, cnttrue("T&T"));
    assertEquals(0, cnttrue("F&F"));
    assertEquals(0, cnttrue("T&F"));
    assertEquals(0, cnttrue("T^T"));
    assertEquals(0, cnttrue("F^F"));
    assertEquals(1, cnttrue("T^F"));
    assertEquals(5, cnttrue("T^F|F&T"));
  }

  public static int cnttrue(String s) {
    if (s == null || s.isEmpty())
      return 0;
    String op = "", b = "";
    for (int i = 0; i < s.length(); i++) {
      b += i % 2 == 0 ? s.charAt(i) : "";
      op += i % 2 == 1 ? s.charAt(i) : "";
    }
    return countTrue(b, op);
  }

  public static int countTrue(String a, String o) {
    int l = a.length();
    int f[][] = new int[l][l], t[][] = new int[l][l];
    for (int i = 0; i < l; i++) {
      t[i][i] = a.charAt(i) == 'T' ? 1 : 0;
      f[i][i] = a.charAt(i) == 'F' ? 1 : 0;
    }
    for (int sub = 1; sub < l; ++sub) {
      for (int i = 0, j = sub; j < l; ++i, ++j) {
        t[i][j] = f[i][j] = 0;
        for (int g = 0; g < sub; g++) {
          int k = i + g, tik = t[i][k] + f[i][k], tkj = t[k + 1][j] + f[k + 1][j];
          char op = o.charAt(k);
          if (op == '&') {
            t[i][j] += t[i][k] * t[k + 1][j];
            f[i][j] += tik * tkj - t[i][k] * t[k + 1][j];
          } else if (op == '|') {
            f[i][j] += f[i][k] * f[k + 1][j];
            t[i][j] += tik * tkj - f[i][k] * f[k + 1][j];
          } else {
            t[i][j] += f[i][k] * t[k + 1][j] + t[i][k] * f[k + 1][j];
            f[i][j] += t[i][k] * t[k + 1][j] + f[i][k] * f[k + 1][j];
          }
          t[i][j] %= 1003;
          f[i][j] %= 1003;
        }
      }
    }
    return t[0][l - 1];
  }

}
