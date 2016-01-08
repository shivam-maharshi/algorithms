package math;

/**
 * 
 * Draw a circle without floating point arithmetic. Given a radius of a circle,
 * draw the circle without using floating point arithmetic
 * 
 * Link: http://geeksquiz.com/draw-circle-without-floating-point-arithmetic/
 * 
 * @author shivam.maharshi
 */
public class DrawCircle {

	public static void draw(double radius) {
		for (double x = 0; x < 2 * radius + 1; x++) {
			for (double y = 0; y < 2 * radius + 1; y++) {
				if (Math.sqrt(((radius - x) * (radius - x)) + ((radius - y) * (radius - y))) <= radius) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		draw(10);
	}

}
