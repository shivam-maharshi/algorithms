package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Link: https://leetcode.com/problems/decode-string
 * 
 * @author shivam.maharshi
 */
public class M394_DecodeString extends TestCase {

  @Test
  public static void test() {
    assertEquals("aaabcbc", decodeString("3[a]2[bc]"));
    assertEquals("abcabccdcdcdef", decodeString("2[abc]3[cd]ef"));
    assertEquals("accaccacc", decodeString("3[a2[c]]"));
    assertEquals("", decodeString(""));
    assertEquals("a", decodeString("1[a]"));
    assertEquals("abcddcddbcddcddabcddcddbcddcdd", decodeString("2[a2[b2[c2[d]]]]"));
    assertEquals("abcdefghijklmn", decodeString("1[a1[b1[c1[d1[e1[f1[g1[h1[i1[j1[k1[l1[m1[n1]]]]]]]]]]]]]]"));
  }
  
  public static String decodeString(String s) {
    return get(s, new MutableInteger(0), 1);
  }

  public static String get(String o, MutableInteger i, int num) {
    String s = "";
    String n = "";
    while (i.v < o.length()) {
      char c = o.charAt(i.v);
      if (c >= '0' && c <= '9') {
        n += c;
      } else if (c == '[') {
        i.incr();
        s += get(o, i, Integer.valueOf(n));
        n = "";
      } else if (c == ']') {
        break;
      } else {
        s += c;
      }
      i.incr();
    }
    String r = "";
    for (int j = 0; j < num; j++)
      r += s;

    return r;
  }
  
  static class MutableInteger {
    int v;
    
    public MutableInteger(int v) {
      this.v = v;
    }
    
    public void incr() {
      this.v++;
    }
  }

}
