package math;

/**
 * Given an array with stock prices, return the buying and selling prices to
 * maximize profits.
 * 
 * @author shivam.maharshi
 */
public class MaximizeStockProfit {

	public static StockTransaction getBestTransaction(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		int min = arr[0], max = arr[0], maxProfit = 0, finalMin = 0, finalMax = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				max = min;
			} else if (arr[i] > max) {
				max = arr[i];
				if (maxProfit < max - min) {
					maxProfit = max - min;
					finalMax = max;
					finalMin = min;
				}
			}
		}
		return new StockTransaction(finalMin, finalMax);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 100001, 101001, 100, 200, 1, 50, 100, 1000 };
		System.out.println(MaximizeStockProfit.getBestTransaction(arr));
	}

}

class StockTransaction {
	private int bPrice;
	private int sPrice;

	public StockTransaction(int bPrice, int sPrice) {
		super();
		this.bPrice = bPrice;
		this.sPrice = sPrice;
	}

	@Override
	public String toString() {
		return "StockTransaction [bPrice=" + bPrice + ", sPrice=" + sPrice + "]";
	}

}
