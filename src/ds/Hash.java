package data.structures;

/**
 * Represents a hash function.
 * 
 * @author shivam.maharshi
 */
public class Hash {

  private long max;

  public Hash(long max) {
    this.max = max;
  }

  // A very naive hash function.
  public long getHash(long n) {
    return n % max;
  }

}
