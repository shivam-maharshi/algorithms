package leetcode.competition;

import java.util.ArrayList;
import java.util.List;

public class MagicalString {

  public static void main(String[] args) {
    System.out.println(magicalString(17));
  }

  public static int magicalString(int n) {
    if (n <= 0)
      return 0;
    if (n < 3)
      return 1;
    List<Integer> l = new ArrayList<>();
    l.add(1);
    l.add(2);
    l.add(2);
    int i = 2, v = 1;
    while (l.size() < n) {
      if (l.get(i) == 2) {
        l.add(v);
        l.add(v);
      } else {
        l.add(v);
      }
      i++;
      v = v == 1 ? 2 : 1;
    }
    int r = 0;
    for (i = 0; i < n; i++) {
      if (l.get(i) == 1)
        r++;
    }
    return r;
  }

}
