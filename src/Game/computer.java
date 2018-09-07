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

	private void chooseDice() {
		// TODO decide which dice to lock

	}

	private boolean toBank() {

		return false;
		// TODO decide to bank if allowed

	}

	private void lockDice() {
		// TODO decide to lock die
	}

}
