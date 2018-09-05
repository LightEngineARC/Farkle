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
		int multiRollArray[] = { 0, 0, 0, 0, 0, 0 };

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
				System.out.println("not a valid die number");
				break;
			}

		}

		return score;

	}
}
