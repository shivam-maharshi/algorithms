package array;

/**
 * Check whether a given string s can be converter to string t with maximum one
 * operation. It can be either Insertion, Deletion or Swapping.
 * 
 * Source: Cloud Era
 * 
 * @author shivam.maharshi
 */
public class ConvertStringSToT {

	public String solution(String S, String T) {
		if (S.equals(T)) {
			return "NOTHING";
		}
		if (Math.abs(S.length() - T.length()) >= 2) {
			return "IMPOSSIBLE";
		}
		int i = 0, j = 0;
		boolean alreadyDeleted = false;
		char c = '0';
		boolean deletionUnsuccessful = false;
		if (S.length() > T.length()) {
			while (i < S.length() && j < T.length()) {
				if (S.charAt(i) != T.charAt(j)) {
					if (alreadyDeleted) {
						deletionUnsuccessful = true;
						break;
					} else {
						c = S.charAt(i);
						i++;
						alreadyDeleted = true;
					}
				} else {
					i++;
					j++;
				}
			}
			if (!deletionUnsuccessful) {
				return "DELETE " + c;
			}
		} else if (S.length() < T.length()) {
			i = 0;
			j = 0;
			boolean alreadyInserted = false;
			boolean insertionUnsuccessful = false;
			while (i < S.length() && j < T.length()) {
				if (S.charAt(i) != T.charAt(j)) {
					if (alreadyInserted) {
						insertionUnsuccessful = true;
						break;
					} else {
						c = T.charAt(i);
						j++;
						alreadyInserted = true;
					}
				} else {
					i++;
					j++;
				}
			}
			if (!insertionUnsuccessful) {
				return "INSERT " + c;
			}
		}
		{
			// TODO: swapping
		}
		return "IMPOSSIBLE";
	}

}
