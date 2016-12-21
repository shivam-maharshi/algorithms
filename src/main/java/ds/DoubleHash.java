package ds;

/**
 * Represents a double hash function.
 * 
 * @author shivam.maharshi
 */
public class DoubleHash {

  private Hash h;

  public DoubleHash(long max) {
    this.h = new Hash(max);
  }

  /**
   * Calculates a 32 bit hash by using the 32 lower & upper bits of a 64 bit
   * hash.
   */
  public int getHash(long n, int mul) {
    long hash64 = h.getHash(n);
    return ((int) hash64) + mul * ((int) (hash64 >> 32));
  }

}
