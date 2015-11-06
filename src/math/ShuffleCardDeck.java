package math;

/* 
 * Shuffle a deck of card with equal probability for all the cases. Assume pure random generator.
 */
public class ShuffleCardDeck {
	
	public static void shuffle ( int[] arr ) {
	  for ( int i=0; i < arr.length; i++ ) {
	    int j = rand (0, i);
	    int temp = arr [i];
	    arr [i] = arr [j];
	    arr [j] = temp;
	  }
	}

	public static int rand ( int low, int high ) {
	  return low + (int) ( Math.random() * ( high - low + 1) );
	}

}
