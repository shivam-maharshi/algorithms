package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * 
 * @author shivam.maharshi
 */
public class ReconstructOriginalDigitsFromEnglish extends TestCase {

  @Test
  public static void test() {
    assertEquals("012", originalDigits("owoztneoer"));
    assertEquals("45", originalDigits("fviefuro"));
    assertEquals("00", originalDigits("zerozero"));
  }

  public static String originalDigits(String s) {
    int[] a = new int[26];
    int[] r = new int[10];
    for (char c : s.toCharArray())
      a[c - 'a']++;

    int c = a['z' - 'a'];
    for (int i = 0; i < c; i++) {
      r[0]++;
      a['z' - 'a']--;
      a['e' - 'a']--;
      a['r' - 'a']--;
      a['o' - 'a']--;
    }

    c = a['w' - 'a'];
    for (int i = 0; i < c; i++) {
      r[2]++;
      a['t' - 'a']--;
      a['w' - 'a']--;
      a['o' - 'a']--;
    }

    c = a['x' - 'a'];
    for (int i = 0; i < c; i++) {
      r[6]++;
      a['s' - 'a']--;
      a['i' - 'a']--;
      a['x' - 'a']--;
    }
    
    c = a['u' - 'a'];
    for (int i = 0; i < c; i++) {
      r[4]++;
      a['f' - 'a']--;
      a['o' - 'a']--;
      a['u' - 'a']--;
      a['r' - 'a']--;
    }
    
    c = a['g' - 'a'];
    for (int i = 0; i < c; i++) {
      r[8]++;
      a['e' - 'a']--;
      a['i' - 'a']--;
      a['g' - 'a']--;
      a['h' - 'a']--;
      a['t' - 'a']--;
    }
    
    // More
    
    c = a['t' - 'a'];
    for (int i = 0; i < c; i++) {
      r[3]++;
      a['t' - 'a']--;
      a['h' - 'a']--;
      a['r' - 'a']--;
      a['e' - 'a']--;
      a['e' - 'a']--;
    }
    
    c = a['f' - 'a'];
    for (int i = 0; i < c; i++) {
      r[5]++;
      a['f' - 'a']--;
      a['i' - 'a']--;
      a['v' - 'a']--;
      a['e' - 'a']--;
    }

    c = a['s' - 'a'];
    for (int i = 0; i < c; i++) {
      r[7]++;
      a['s' - 'a']--;
      a['e' - 'a']--;
      a['v' - 'a']--;
      a['e' - 'a']--;
      a['n' - 'a']--;
    }
    
    c = a['o' - 'a'];
    for (int i = 0; i < c; i++) {
      r[1]++;
      a['o' - 'a']--;
      a['n' - 'a']--;
      a['e' - 'a']--;
    }

    c = a['i' - 'a'];
    for (int i = 0; i < c; i++) {
      r[9]++;
      a['n' - 'a']--;
      a['i' - 'a']--;
      a['n' - 'a']--;
      a['e' - 'a']--;
    }

    String res = "";
    for (int i = 0; i < 10; i++) {
      while (r[i] > 0) {
        r[i]--;
        res += i;
      }
    }

    return res;
  }

}
