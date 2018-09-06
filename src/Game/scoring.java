/********************************************************
 *
 *  Project :  <Name of project|assignment>
 *  File    :  <Name of source code file>
 *  Name    :  Ashton Chatelain
 *  Date    :  <Date created (project due date)>
 *
 *  Description : (Narrative description, not code)
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *
 *    2) What data-structures are used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 *    4) What methods are implemented (optional).
 *
 *  Changes :  <Description|date of modifications>
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
	int score = 0;
	int[] dice = new int[6];

	public int scoreDice(int[] diceRecieved) {
		// TODO score the dice
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
				System.out.println("die locked");
				break;
			}
		}

		// check for the high value situations and cascade through lower options
		for (int j = 0; j < 6; j++) {
			if (multiRollArray[j] == 6) {
				score = 3000;
			} else if (multiRollArray[j] == 5) {
				score = 2000;
			} else if (multiRollArray[j] == 4) {
				score = 1000;
				// check for a double for an extra 500 points
				for (int k = 0; k < 6; k++) {
					if (multiRollArray[k] == 2) {
						score = score + 500;
					}
				}
			}
			if (multiRollArray[j] == 3) {

				switch (multiRollArray[j]) {
				case 0:
					score = 300;
					break;
				case 1:
					score = 200;
					break;
				case 2:
					score = 300;
					break;
				case 3:
					score = 500;
					break;
				case 4:
					score = 500;
					break;
				case 5:
					score = 600;
					break;

				}
			}
		}

		// check for 1-6 straight.
		if (diceRecieved[0] == 1 && diceRecieved[1] == 2 && diceRecieved[2] == 3 && diceRecieved[3] == 4
				&& diceRecieved[4] == 5 && diceRecieved[5] == 6) {
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

		return score;

	}
}
