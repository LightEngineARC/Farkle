/********************************************************
 *
 *  Project :  Farkle
 *  File    :  scoring.java
 *  Name    :  Ashton Chatelain Sam SMith
 *  Date    :  
 *
 *  Description : (Narrative description, not code)
 *
 *    1) This class takes an int array and returns an int that is the best point value
 *
 *    2) It uses the array and loops through to check for scoring criteria
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 ********************************************************/
package Game;

import java.util.Arrays;

/**
 * @author Ashton
 *
 */
public class scoring {
	// accept an array of dice and out put best score

	public static int scoreDice(int[] diceRecieved) {
		int score = 0;
		Arrays.sort(diceRecieved);

		// stores number of times each number is rolled
		int multiRollArray[] = { 0, 0, 0, 0, 0, 0 };

		// count of each number to find multiple rolls
		for (int i = 0; i < 6; i++) {
			switch (diceRecieved[i]) {
			case 1:
				multiRollArray[0]++;
				break;
			case 2:
				multiRollArray[1]++;
				break;
			case 3:
				multiRollArray[2]++;
				break;
			case 4:
				multiRollArray[3]++;
				break;
			case 5:
				multiRollArray[4]++;
				break;
			case 6:
				multiRollArray[5]++;
				break;
			default:
				break;
			}
		}

		// check for the high value situations and cascade through lower options
		for (int j = 0; j < 6; j++) {
			if (multiRollArray[j] == 6) {
				score = 3000;
			} else if (multiRollArray[j] == 5) {
				score = 2000;
				// check for singles
				score = checkSingles(j, diceRecieved, score);
			} else if (multiRollArray[j] == 4) {
				score = 1000;
				// check for a double for an extra 500 points
				for (int k = 0; k < 6; k++) {
					if (multiRollArray[k] == 2) {
						score = score + 500;
					}
				}
				if (score < 1500) {
					score = checkSingles(j, diceRecieved, score);
				}
			}
			if (multiRollArray[j] == 3) {
				// check for ones and fives.
				if (j != 0) {
					for (int m = 0; m < 6; m++) {
						if (diceRecieved[m] == 1) {
							score = score + 100;
						}
					}
				} else if (j != 4) {
					for (int m = 0; m < 6; m++) {
						if (diceRecieved[m] == 5) {
							score = score + 50;
						}
					}
				}

				switch (j) {
				case 0:
					score += 300;
					break;
				case 1:
					score += 200;
					break;
				case 2:
					score += 300;
					break;
				case 3:
					score += 400;
					break;
				case 4:
					score += 500;
					break;
				case 5:
					score += 600;
					break;

				}

			}
		}

		// check for 1-6 straight.
		if (diceRecieved[0] == 1 && diceRecieved[1] == 2 && diceRecieved[2] == 3 && diceRecieved[3] == 4
				&& diceRecieved[4] == 5 && diceRecieved[5] == 6)

		{
			score = 1500;

		}
		// check for two triplets
		int tripCount = 0;
		for (int k = 0; k < 6; k++) {
			if (multiRollArray[k] == 3) {
				tripCount++;
			}
		}
		if (tripCount == 2) {
			score = 2500;
		}

		// check for 3 pair
		int pairCount = 0;
		for (int l = 0; l < 6; l++) {
			if (multiRollArray[l] == 2) {
				pairCount++;
			}
		}
		if (pairCount == 3) {
			score = 1500;
		}
		// check for ones and fives.
		if (score < 300) {
			for (int m = 0; m < 6; m++) {
				if (diceRecieved[m] == 1) {
					score = score + 100;
				} else if (diceRecieved[m] == 5) {
					score = score + 50;
				}
			}
		}

		return score;

	}

	private static int checkSingles(int j, int[] diceRecieved, int score) {
		// TODO Auto-generated method stub
		if (j != 0 && j != 4) {
			for (int n = 0; n < 6; n++) {
				if (diceRecieved[n] == 5) {
					score += 50;
				} else if (diceRecieved[n] == 1) {
					score += 100;
				}
			}
		}
		return score;

	}
}
