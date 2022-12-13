package leetcode;

public class IntegerValue {
	public boolean isIntLessThanMax(int res, int cValue) {
		if (res < Integer.MAX_VALUE / 10)
			return true;
		else if (res == Integer.MAX_VALUE / 10) {
			if (cValue == 9 || cValue == 8 || cValue == 7)
				return false;
			else
				return true;
		}
		return false;
	}

	public boolean isIntMoreThanMin(int res, int cValue) {
		if (res < Integer.MAX_VALUE / 10)
			return true;
		else if (res == Integer.MAX_VALUE / 10) {
			if (cValue == 9 || cValue == 8)
				return false;
			else
				return true;
		}
		return false;
	}
}