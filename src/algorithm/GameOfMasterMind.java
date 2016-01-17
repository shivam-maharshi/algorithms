package algorithm;

import java.util.HashMap;
import java.util.Map;

/* 
 * 17.5 - Game of mastermind. Return the count of hits and pseudo hits.
 */
public class GameOfMasterMind {

	public static void printHitsAndPseudoHits(String guess, String solution) {
		// Contains solution matches. Will be added here in case of match.
		Map<Character, Boolean> sMap = new HashMap<Character, Boolean>();
		int len = guess.length(), hits = 0, pseudoHits = 0;
		for (int i = 0; i < len; i++) {
			if (guess.charAt(i) == solution.charAt(i)) {
				if (!sMap.containsKey(guess.charAt(i))
						|| (sMap.containsKey(guess.charAt(i)) && !sMap.get(guess.charAt(i)))) {
					sMap.put(guess.charAt(i), true);
					hits++;
				} 
			} else {
				sMap.put(solution.charAt(i), false);
			}
		}
		for (int i = 0; i < len; i++) {
			if (guess.charAt(i) != solution.charAt(i)) {
				if (sMap.containsKey(guess.charAt(i)) && !sMap.get(guess.charAt(i))) {
					sMap.put(guess.charAt(i), true);
					pseudoHits++;
				}
			}
		}
		System.out.println("Hits : " + hits + " , PseudoHits : " + pseudoHits);
	}

	public static void main(String[] args) {
		GameOfMasterMind.printHitsAndPseudoHits("RGBY", "GGRR");
	}
}
