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

 ********************************************************/
package Game;

/**
 * @author Ashton
 *
 */
public class computer {

	int[] dice = { 0, 0, 0, 0, 0, 0 };
	int[] diceToLock = { -1, -1, -1, -1, -1, -1 };
	int[] sets = { 0, 0, 0, 0, 0, 0 };
	private int score;

	public computer(int[] dice, int score) {
		this.score = score;
		this.dice = dice;
	}

	public void computerTurn() {
		while (!toBank()) {
			chooseDice();
		}
	}

	public int[] chooseDice() {

		// TODO decide which dice to lock
		for (int i = 0; i < 6; i++) {
			if (this.dice[i] == 1 || this.dice[i] == 5) {
				diceToLock[i] = 1;
			}
			switch (this.dice[i]) {
			case 1:
				sets[0]++;
				break;
			case 2:
				sets[1]++;
				break;
			case 3:
				sets[2]++;
				break;
			case 4:
				sets[3]++;
				break;
			case 5:
				sets[4]++;
				break;
			case 6:
				sets[5]++;
			default:
				break;
			}
			for (int j = 0; j < 6; j++) {// loop through sets and look for values greater than 2
				if (sets[j] > 2) {
					System.out.println("sets at " + j + " > 2");
					for (int k = 0; k < 6; k++) {// loop through dice and check if the value of dice == int j +1
						if (dice[k] == (j + 1)) {
							diceToLock[k] = 1;
						}
					}

				}
			}

		}

		return this.diceToLock;

	}

	private boolean toBank() {
		if (this.score == 0) {
		}

		return false;
		// TODO decide to bank if allowed

	}

	public boolean isItLocked(int index) {
		// TODO decide to lock die
		if (this.diceToLock[index] == 1) {
			return true;
		} else
			return false;
	}

}
