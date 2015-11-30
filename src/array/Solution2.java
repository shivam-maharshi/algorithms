package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution2 {

	public int solution(String S) {
		String[] log = S.split("\n");
		int len = log.length;
		long[] dSec = new long[len];
		long[] num = new long[len];
		for (int i = 0; i < len; i++) {
			String l = log[i];
			String[] a = l.split(",");
			dSec[i] = getDuration(a[0]);
			num[i] = getNumber(a[1]);
		}
		Map<Long, Long> m = new HashMap<>();
		for (int i = 0; i < len; i++) {
			long n = num[i];
			long d = dSec[i];
			if (m.containsKey(n)) {
				long alreadyAdded = m.get(n);
				m.put(n, alreadyAdded + d);
			} else {
				m.put(n, d);
			}
		}
		long mostContactedNum = getExcusedNum(m);
		return calculateCost(dSec, num, mostContactedNum);
	}

	private int calculateCost(long[] dur, long[] num, long mcNum) {
		int cost = 0;
		for (int i = 0; i < dur.length; i++) {
			if (num[i] != mcNum) {
				if (dur[i] < 300) {
					cost += dur[i] * 3;
				} else {
					long mins = dur[i] / 60;
					if (dur[i] % 60 != 0) {
						mins++;
					}
					cost += mins * 150;
				}
			}
		}
		return cost;
	}

	private long getExcusedNum(Map<Long, Long> map) {
		long num = 0;
		long maxDur = 0;
		Set<Long> keys = map.keySet();
		for (Long key : keys) {
			if (map.get(key) > maxDur) {
				num = key;
				maxDur = map.get(key);
			} else if (map.get(key) == maxDur) {
				if (key < num) {
					num = key;
				}
			}
		}
		return num;
	}

	private long getNumber(String s) {
		String[] a = s.split("-");
		long n = 0;
		n += Integer.valueOf(a[0]);
		n *= 1000;
		n += Integer.valueOf(a[1]);
		n *= 1000;
		n += Integer.valueOf(a[2]);
		return n;
	}

	private long getDuration(String s) {
		String[] a = s.split(":");
		long sec = 0;
		sec += Integer.valueOf(a[0]) * 3600;
		sec += Integer.valueOf(a[1]) * 60;
		sec += Integer.valueOf(a[2]);
		return sec;
	}

	public static void main(String[] args) {
		System.out.println(new Solution2().solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090"));
	}

}
