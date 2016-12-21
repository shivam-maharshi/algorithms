package interview.twitter;

/**
 * Mask phone numbers and email.
 * 
 * @author shivam.maharshi
 */
public class InfoMasking {

  public static void main(String[] args) {
    String[] a = { "P:(333)456-7890", "P:+1(333) 456-(78)(  9)(0 )" };
    print(a);
  }

  public static void print(String[] args) {
    StringBuilder sb = new StringBuilder();
    for (String s : args) {
      s = s.trim();
      if (s.startsWith("E"))
        maskEmail(s, sb);
      else
        maskPhone(s, sb);
    }
  }

  private static void maskEmail(String s, StringBuilder sb) {
    sb.setLength(0);
    s = s.split(":")[1].trim();
    String[] ss = s.split("@");
    sb.append(ss[0].charAt(0)).append("*****").append(ss[0].charAt(ss[0].length() - 1)).append("@").append(ss[1]);
    System.out.println("E:" + sb.toString());
  }

  private static void maskPhone(String s, StringBuilder sb) {
    sb.setLength(0);
    s = s.split(":")[1].trim();
    int count = 0;
    for (int i = s.length() - 1; i > -1; i--) {
      char c = s.charAt(i);
      if (((int) c >= 48 && (int) c <= 57)) {
        if (count < 4) {
          sb.append(c);
          count++;
        } else
          sb.append('*');
      } else if (c == '+') {
        sb.append(c);
      } else if ((c == '(' || c == ' ' || c == ')' || c == '-') && sb.length() > 3
          && sb.charAt(sb.length() - 1) != '-') {
        sb.append('-');
      }
    }

    if (sb.charAt(sb.length() - 1) == '-')
      sb.delete(sb.length() - 1, sb.length());

    System.out.println("P:" + sb.reverse().toString());

  }

}
