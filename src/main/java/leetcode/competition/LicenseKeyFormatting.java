package leetcode.competition;

public class LicenseKeyFormatting {

  public static String licenseKeyFormatting(String S, int K) {
    String s = S.toUpperCase();
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c != '-')
        sb.append(c);
    }
    int l = sb.length();
    for (int i = l - K; i > 0; i -= K)
      sb.insert(i, '-');
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(licenseKeyFormatting("2-4A0r7-4k", 1));
  }

}
