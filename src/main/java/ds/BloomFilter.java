package ds;

import org.junit.Test;

import bit.BitVector;
import junit.framework.TestCase;

/**
 * Link:
 * https://www.javacodegeeks.com/2014/07/how-to-use-bloom-filter-to-build-a-large-in-memory-cache-in-java.html
 * 
 * @author shivam.maharshi
 */
public class BloomFilter extends TestCase {

  private BitVector bv;
  private DoubleHash dh;
  private int k;

  // TestCase class needs default constructor.
  public BloomFilter() {
  }

  public BloomFilter(int capacity, float p) {
    // Bit vector size = -nLog(p)/(Log(2)^2)
    // TODO: Correct this!
    int size = (int) (-capacity * Math.log(p) / (Math.log(2) * Math.log(2)));
    bv = new BitVector(size);
    // # of hash functions = (n/m)*Log(2)
    this.k = (int) ((size / capacity) * Math.log(2));
    this.dh = new DoubleHash(size);
  }

  /**
   * Can return false with 100% precision but true with a false positive
   * probability of p.
   */
  public boolean isPresent(int num) {
    return bv.getBit(num);
  }

  /**
   * Adds the number to this bloom filter by setting bit at k indexes which are
   * equal to the k different hash values by k hash functions.
   */
  public void add(int num) {
    for (int i = 1; i <= k; i++) {
      bv.setBit(dh.getHash(num, i), true);
    }
  }

  @Test
  public static void testIsAbsentWorksWithFullPrecision() {
    BloomFilter bf = new BloomFilter(10, 0.1F);
    assertEquals(false, bf.isPresent(0));
    assertEquals(false, bf.isPresent(1));
    assertEquals(false, bf.isPresent(2));
    assertEquals(false, bf.isPresent(3));
    assertEquals(false, bf.isPresent(4));
    assertEquals(false, bf.isPresent(5));
    assertEquals(false, bf.isPresent(6));
    assertEquals(false, bf.isPresent(7));
    assertEquals(false, bf.isPresent(8));
    assertEquals(false, bf.isPresent(9));
  }
  
  

}