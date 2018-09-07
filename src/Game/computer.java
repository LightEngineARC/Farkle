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

	private int[] chooseDice() {

		// TODO decide which dice to lock
		for (int i = 0; i < 6; i++) {
			if (this.dice[i] == 1 || this.dice[i] == 5) {
				diceToLock[i] = 1;
			}
			switch (this.dice[i]) {
			case 1:
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
				break;
			case 6:
				sets[5]++;
			}
			for (int j = 0; j < 6; j++) {
				if (sets[j] > 2) {
					for (int k = 0; k < 6; k++) {
						if (diceToLock[k] == j + 1) {
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
