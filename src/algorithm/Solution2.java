package algorithm;

/**
 * Question in VMWare.
 * 
 * @author shivam.maharshi
 */
public class Solution2 {

	static String[] gridLand(String[] inp) {
		String[] res = new String[inp.length];
		for (int i = 0; i < inp.length; i++) {
			String[] s = inp[i].split(" ");
			int x = Integer.valueOf(s[0]);
			int y = Integer.valueOf(s[1]);
			int k = Integer.valueOf(s[2]);
			res[i] = getPath(x, y, k);
		}
		return res;
	}

	public static String getPath(int x, int y, int k) {
		String path = "";
		int hcount = x;
		int vcount = y;
		while (k > 0) {
			if (k > y) {
				k = k - y;
				path = "H" + path;
				hcount--;
			} else {
				for (int i = 0; i < y - k; i++) {
					path = "V" + path;
					vcount--;
				}
				path = "H" + path;
				hcount--;
				k=0;
			}
		}
		while (vcount > 0) {
			path = "V" + path;
			vcount--;
		}
		while (hcount > 0) {
			path = "H" + path;
			hcount--;
		}
		return path;
	}

	public static void main(String[] args) {
		String[] inp = new String[] { "2 2 2", "2 2 3" };
		gridLand(inp);
	}

}
