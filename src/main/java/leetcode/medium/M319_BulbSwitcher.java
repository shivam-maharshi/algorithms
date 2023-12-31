package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/bulb-switcher
 * 
 * @author shivam.maharshi
 */
public class M319_BulbSwitcher {

  /*
   * Any number with even number of factors will be off at the end. Since
   * factors exists in pairs (1,n), (2, n/2)..etc. Hence only the numbers that
   * are perfect squares till n will be on by the end.
   */
  public static int bulbSwitch(int n) {
    return (int)Math.sqrt(n);
  }

}
