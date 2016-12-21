package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Un-concatenate a given string sentence to add spaces such that words
 * separated by spaces are present in a given dictionary. One exception is nouns
 * like names won't be present in the dictionary, but they must be separated
 * too. Un-concatenate the input in a way that minimizes the count of the
 * unknown characters present in a sentence.
 * 
 * @author shivam.maharshi
 */
public class StringUnconcatenation {

  static public int getMin(String sentence, Map<String, Void> dict) {    
    return getMin(sentence, dict, 0, 1);
  }
  
  static public int getMin(String s, Map<String, Void> d, int l, int h) {
    if ( l > s.length() )
      return 0;
    if (h > s.length() && l <= s.length())
      return h - l-1;
  
    if ( d.containsKey( s.substring( l, h ) ) )
      return getMin(s, d, h, h + 1);
    
    return Math.min( h - l + getMin( s, d, h, h + 1 ), getMin( s, d, l, h + 1 ) );
    
  }
  
  public static void main(String[] args) {
    System.out.println("abc".substring(1, 2));
    Map<String, Void> d = new HashMap<String, Void>();
    d.put("good", null);
    d.put("boy", null);
    d.put("is", null);
    d.put("a", null);
    System.out.println(getMin("timisajimgoodboys", d));
  }

}
