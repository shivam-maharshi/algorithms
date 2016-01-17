package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question in VMWare.
 * 
 * @author shivam.maharshi
 */
public class Solution3 {

	static int[] Circles(int distance, int[] radius, int[] cost) {

		class Prop implements Comparable<Prop> {
			int radius;
			int cost;
			int index;

			Prop(int radius, int cost, int index) {
				this.radius = radius;
				this.cost = cost;
				this.index = index;
			}

			@Override
			public int compareTo(Prop o) {
				if(this.cost < o.cost) {
					return -1;
				} else if (this.cost == o.cost) {
					if (this.radius > o.radius) {
						return -1;
					} else if (this.radius==o.radius) {
						if(this.index < o.index) {
							return -1;
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				} else {
					return 1;
				}
			}

		}

		List<Prop> list = new ArrayList<Prop>();

		for (int i = 0; i < radius.length; i++) {
			list.add(new Prop(radius[i], cost[i], i));
		}

		Collections.sort(list);

		int[] res = new int[radius.length];
		
		for (int i = 0; i < list.size(); i++) {
			Prop p1 = list.get(i);
			for (int j = 0; j < list.size(); j++) {
				Prop p2 = list.get(j);
				if(p1.radius + p2.radius >= distance) {
					res[p1.index] = p2.index+1;
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {

	}

}
