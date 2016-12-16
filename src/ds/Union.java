package data.structures;

/**
 * Standard representation of a Union data structure.
 * 
 * @author shivam.maharshi
 */
public class Union {
	int[] a;

	public Union(int n) {
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}
	}

	public boolean isConnected(int n1, int n2) {
		return getParent(n1) == getParent(n2);
	}

	public void connect(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);
		int pMin = Math.min(p1, p2);
		int pMax = Math.max(p1, p2);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == pMax) {
				a[i] = pMin;
			}
		}
	}

	private int getParent(int id) {
		return a[id];
	}

}
