package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/burst-balloons/
 * 
 * @author shivam.maharshi
 */
public class BurstBalloon {

  public static void main(String[] args) {
    int[] a = { 3, 9, 5, 7 };
    System.out.println(a.length);
    List<Integer> list = new ArrayList<Integer>();
    for (int aa : a)
      list.add(aa);
    System.out.println(getMax(list));
  }

  /*
   * This works but has a complexity of O(n!). So it sucks and we must do DP to
   * improve complexity which will yield O(n^3) solution.
   */
  public static int getMax(List<Integer> list) {
    return getMax(list, -1);
  }

  public static int getMax(List<Integer> list, int b) {
    if (list.size() == 1)
      return list.get(0);

    int max = 0, temp = 0, element = 0;
    if (b != -1) { // Non start of recursion.
      max = getValue(list, b);
      element = list.get(b);
      list.remove(b);
    }

    for (int i = 0; i < list.size(); i++)
      temp = Math.max(temp, getMax(list, i));

    max = max + temp;

    if (b != -1)
      list.add(b, element);
    return max;
  }

  public static int getValue(List<Integer> list, int b) {
    int cost = list.get(b);
    if (b > 0)
      cost *= list.get(b - 1);
    if (b < list.size() - 1)
      cost *= list.get(b + 1);
    return cost;
  }

}
