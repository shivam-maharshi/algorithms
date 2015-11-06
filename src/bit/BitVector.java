package bit;

/* 
 * Write the code for Bit Vector. It should present the functionality of setting and retrieving bit at index N.
 */

public class BitVector {

	private byte[] vector;

	public BitVector(int size) {
		int vectorSize = size / 8;
		if (size % 8 != 0) {
			vectorSize++;
		}
		this.vector = new byte[vectorSize];
	}

	// Gets the bit.
	public boolean getBit(int index) {
		if (index < 0 || index >= vector.length) {
			throw new IllegalArgumentException("Illegal argument passed.");
		}
		byte val = vector[index / 8];
		byte mod = (byte) (index % 8);
		return ((val & 1 << mod) >> mod == 1);
	}

	// Sets the bit.
	public void setBit(int index, boolean bit) {
		if (index < 0 || index >= vector.length) {
			throw new IllegalArgumentException("Illegal argument passed.");
		}
		byte prevVal = vector[index / 8];
		byte mod = (byte) (index % 8);
		if (bit) {
			vector[index / 8] = (byte) (prevVal | 1 << mod);
		} else {
			vector[index / 8] = (byte) (prevVal & (~(1 << mod)));
		}
	}
	
	public static void main(String[] args) {
		BitVector bv = new BitVector(1000001);
		System.out.println(bv.getBit(997));
		bv.setBit(997, true);
		System.out.println(bv.getBit(997));
		System.out.println(bv.getBit(998));
		System.out.println(bv.getBit(996));
	}

}