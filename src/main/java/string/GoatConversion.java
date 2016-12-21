package string;

/**
 * Convert a string where every word starting with a consonant should change to
 * its first character at last. For every word add a suffix character 'm' and
 * number of 'a' character equal to the rank of the word. Rank starting from 1.
 * 
 * @author shivam.maharshi
 */
public class GoatConversion {

  public static void main(String[] args) {
    System.out.println(convert("Goat         is           here"));
  }

  public static String convert(String s) {
    if (s == null || s.isEmpty())
      return null;
    StringBuilder sb = new StringBuilder();
    String suffix = "ma";
    char fc = isVowel(s.charAt(0)) ? '-': s.charAt(0);
    if (fc == '-')
      sb.append(s.charAt(0));
    int i = 1;
    while (i < s.length()) {
      if (s.charAt(i) == ' ') {
        if (fc != '-')
          sb.append(fc);
        
        i = getNext(s, i+1);
        if (i < s.length())
          fc = isVowel(s.charAt(i)) ? '-': s.charAt(i);
        else
          fc = '-';
        sb.append(suffix).append(" ");
        suffix += 'a';
      } else
        sb.append(s.charAt(i));
      i++;
    }
    
    if (fc!= '-')
      sb.append(fc);

    sb.append(suffix);
    return sb.toString();
  }
  
  public static int getNext(String s, int i) {
    while(i < s.length() && s.charAt(i)==' ')
      i++;
    return i;
  }
  
  public static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

}
