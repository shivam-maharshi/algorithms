package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/reverse-integer
 * 
 * @author shivam.maharshi
 */
public class M7_ReverseInteger {
  
  public int reverse(int x) {
    int num = Math.abs(x);
    Long res = new Long(0);
    while(num!=0) {
      res = 10 * res + num % 10;
      num = num/10;
    }
    if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
      return 0;
    return x < 0 ? -1 * res.intValue() : res.intValue();
  }
  
  public static void main(String[] args) {
    System.out.println(new M7_ReverseInteger().reverse(-123));
  }

}
