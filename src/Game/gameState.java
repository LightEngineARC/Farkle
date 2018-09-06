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
 ********************************************************/
package Game;

/**
 * @author Ashton
 *
 */
public class gameState {

	private int[] dice;
	private int playerScore = 0;
	private int computerScore = 0;
	private int runningScore = 0;
	private String turn = "User";

	public void game() {
		this.dice = rollDice(dice);
		while (!winCondition()) {
			// TODO manage turns.
			resetTurn();
		}

	}

	private int bankPoints(int[] dice) {
		// TODO get dice that have been clicked
		// TODO score dice
		return scoring.scoreDice(dice);

	}

	private void resetTurn() {
		// TODO reset GUI and advance game state

	}

	public int[] lockDice(int[] dice) {
		// TODO lock the dice on the GUI
		return dice;

	}

	// returns array with random numbers if the current number is not -1
	private int[] rollDice(int[] dice2) {
		for (int i = 0; i < 6; i++) {
			if (dice2[i] != -1) {
				dice2[i] = (int) (Math.random() * 5 + 1);
			}
		}
		return dice2;
	}

	public boolean winCondition() {
		return false;
		// TODO code win condition

	}

}
