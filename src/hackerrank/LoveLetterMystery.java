package hackerrank;

public class LoveLetterMystery {
  
  public static void main(String[] args) {
    String[] l = new String[]{"abc", "abcba", "abcd"};
    int[] n = mystery(l);
    for (int nn : n)
      System.out.print(nn + " ");
  }

  public static int[] mystery(String[] letter) {
    int[] r = new int[letter.length];
    for (int i = 0; i < letter.length; i++) {
      int c = 0;
      String[] s = letter[i].split(" ");
      for (String ss : s)
        c += mystery(ss);
      r[i] = c;
    }
    return r;
  }

  public static int mystery(String s) {
    int l = 0, h = s.length() - 1;
    int r = 0;
    while (h > l) {
      r += diff(s.charAt(l), s.charAt(h));
      l++;
      h--;
    }
    return r;
  }

  public static int diff(char l, char h) {
    return Math.abs(((int) l) - ((int) h));
  }

}
