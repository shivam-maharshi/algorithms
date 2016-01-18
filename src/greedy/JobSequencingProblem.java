package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of jobs where every job has a deadline and associated profit
 * if the job is finished before the deadline. It is also given that every job
 * takes single unit of time, so the minimum possible deadline for any job is 1.
 * How to maximize total profit if only one job can be scheduled at a time.
 * 
 * Link:
 * http://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/
 * 
 * @author shivam.maharshi
 */
public class JobSequencingProblem {

	// TODO: Correct this Algo.
	public static int[] findMaxProfit(Job[] a) {
		int[] r = new int[findMaxDl(a) + 1];
		Arrays.fill(r, -1);
		Arrays.sort(a, new ProfitComparator());
		for (int i = 0; i < a.length; i++) {
			Job j = a[i];
			if (r[j.dl] == -1) {
				r[j.dl] = j.id;
			} else {
				int k = j.dl - 1;
				while (k >= 0) {
					if (r[k] == -1) {
						r[k] = j.id;
						break;
					}
					k--;
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		Job[] a = new Job[] { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 30), new Job(4, 1, 40) };
		int[] ids = JobSequencingProblem.findMaxProfit(a);
		System.out.println(Arrays.toString(ids));
	}

	private static int findMaxDl(Job[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i].dl > max) {
				max = a[i].dl;
			}
		}
		return max;
	}

}

class ProfitComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		return (o1.p > o2.p) ? -1 : 1;
	}

}

class Job {

	int id;
	int dl;
	int p;

	public Job(int id, int dl, int p) {
		this.id = id;
		this.dl = dl;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", dl=" + dl + ", p=" + p + "]";
	}

}