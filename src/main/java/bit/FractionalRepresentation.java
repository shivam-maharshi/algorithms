package bit;

import java.math.BigDecimal;

public class FractionalRepresentation {

	public static String representFractionalNumberInBinary(BigDecimal num) {
		
		BigDecimal one = new BigDecimal(1);
		BigDecimal zero = new BigDecimal(0);
		BigDecimal two = new BigDecimal(2);
		
		if (num.compareTo(one) == 0 || num.compareTo(one) == 1 || num.compareTo(zero) == -1) {
			return "Error";
		}
		StringBuilder sb = new StringBuilder();
		while (num.compareTo(zero) == 0 || num.compareTo(zero) == 1) {
			if (sb.length() >= 32) {
				return "Error";
			}
			num.multiply(two);
			if (num.compareTo(one) == 0 || num.compareTo(one) == 1) {
				num.subtract(one);
				sb.append("1");
			} else {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(FractionalRepresentation.representFractionalNumberInBinary(new BigDecimal(0.72)));
	}

}
