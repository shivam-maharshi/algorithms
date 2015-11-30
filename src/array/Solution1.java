package array;

class Solution1 {
	public int solution(String S) {
		int res = -1;
		for(int i=0;i<S.length();i++) {
			for(int j=i+1;j<=S.length();j++) {
				if (isValid(S.substring(i, j))) {
					res = Math.max(res, j-i);
				}
			}
		}
		return res;
	}

	private boolean isValid(String s) {
		int[] a = new int[256];
		for(int i=0;i<s.length();i++) {
			a[s.charAt(i)]++;
		}
		boolean hasUpperCase = false;
		for(int i=65;i<=90;i++) {
			if(a[i]>0) {
				hasUpperCase = true;
				break;
			}
		}
		boolean hasNumber = false;
		for(int i=48;i<=57;i++) {
			if(a[i]>0) {
				hasNumber = true;
				break;
			}
		}
		return (hasUpperCase&&(!hasNumber));
	}

	public static void main(String[] args) {
		System.out.println(new Solution1().solution("a0bb"));
	}
}
