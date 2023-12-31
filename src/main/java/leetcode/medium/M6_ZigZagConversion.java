package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/zigzag-conversion
 * 
 * @author shivam.maharshi
 */
public class M6_ZigZagConversion {

  public String convert(String s, int numRows) {
    if(numRows==1)
      return s;
    if(numRows==2) {
      String f ="", b = "";
      for(int i=0;i<s.length();i++) {
        if(i%2==0)
          f += s.charAt(i);
        else
          b += s.charAt(i);
      }
      return f+b;
    }
    String res = "";
    int jump =  2*numRows - 2;
    // First row.
    for(int i=0; i<s.length(); i += jump)
      res += s.charAt(i);
    // Rows in middle.
    for(int i=1; i<numRows-1; i++) {
      for(int j=i; j<s.length(); j += jump) {
        res += s.charAt(j);
        int nextPos = j + 2*numRows - 2*(i+1);
        if (nextPos < s.length())
          res += s.charAt(nextPos);
      }
    }
    // Last row.
    for(int i=numRows-1; i<s.length(); i += jump)
      res += s.charAt(i);
    
    return res;
  }
  
  public static void main(String[] args) {
    System.out.println(new M6_ZigZagConversion().convert("PAYPALISHIRING", 5));
  }
  
}
