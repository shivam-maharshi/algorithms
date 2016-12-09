package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/evaluate-division/
 * 
 * @author shivam.maharshi
 */
public class EvaluateDivision extends TestCase {

  @Test
  public static void test() {
    String[][] equations = { { "a", "b" }, { "b", "c" } };
    double[] values = new double[] { 2.0, 3.0 };
    String[][] queries = { { "b", "c" } };
    print(calcEquation(equations, values, queries));
  }

  public static void print(double[] a) {
    for (double d : a)
      System.out.print(d + ", ");
  }

  public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    double[] r = new double[queries.length];
    Map<String, Node> g = constructGraph(equations, values);
    for (int i = 0; i < queries.length; i++) {
      r[i] = g.get(queries[i][0]) == null || g.get(queries[i][1]) == null ? -1
          : solve(g.get(queries[i][0]), g.get(queries[i][1]), g);
    }
    return r;
  }

  private static double solve(Node s, Node e, Map<String, Node> g) {
    if (s == e)
      return 1;

    s.v = true;
    double res = -1;
    for (String n : s.n.keySet()) {
      Node adj = g.get(n);
      if (adj != null && !adj.v) {
        double r = solve(adj, e, g);
        if (r != -1) {
          res = r * s.n.get(n);
          break;
        }
      }
    }
    s.v = false;
    return res;
  }

  private static Map<String, Node> constructGraph(String[][] e, double[] v) {
    Map<String, Node> g = new HashMap<>();
    for (int i = 0; i < e.length; i++) {
      if (!g.containsKey(e[i][0]))
        g.put(e[i][0], new Node());

      if (!g.containsKey(e[i][1]))
        g.put(e[i][1], new Node());

      if (!g.get(e[i][0]).n.containsKey(e[i][1]))
        g.get(e[i][0]).n.put(e[i][1], v[i]);

      if (!g.get(e[i][1]).n.containsKey(e[i][0]))
        g.get(e[i][1]).n.put(e[i][0], 1 / v[i]);
    }
    return g;
  }

  private static class Node {
    Map<String, Double> n;
    boolean v;

    public Node() {
      this.n = new HashMap<>();
      this.v = false;
    }
  }

}
