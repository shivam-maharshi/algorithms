package leetcode.competition;

public class NumberComplement {

  public static int findComplement(int num) {
    String n = Integer.toBinaryString(num);
    String s = "";
    for (char c : n.toCharArray()) {
      if (c == '0')
        s += '1';
      else
        s += '0';
    }
    return Integer.parseInt(s,2);
  }

}
