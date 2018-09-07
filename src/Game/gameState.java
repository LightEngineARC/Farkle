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

	int[] dice = { 0, 0, 0, 0, 0, 0 };

	int playerScore = 0;
	int computerScore = 0;
	int runningScore = 0;
	boolean computerTurn = true;

	public gameState() {
		this.dice = this.rollDice();
		this.playerScore = 0;
		this.computerScore = 0;

	}

	public void game() {

		System.out.println("rolling the first dice");
		this.dice = rollDice();
		System.out.println("dice are the following:");
		System.out.println(this.printDice());

		while (!winCondition()) {

			// TODO manage turns

			this.dice = rollDice();
			System.out.println("dice are the following:");
			System.out.println(this.printDice());
			if (computerTurn) {
				System.out.println("computer plays");
			} else
				System.out.println("player turn");

			// start turn by rolling dice
			dice = rollDice();
			if (scoring.scoreDice(dice) == 0) {
				System.out.println("FARKLE");
				computerTurn = resetTurn(computerTurn);
			}
			// TODO player selects dice and they are scored each time
			if (computerTurn) {
				computer.computerTurn(dice);
			}

			computerTurn = resetTurn(computerTurn);
			System.out.println("rolling the dice again!");
		}
		// TODO game over here
	}

	private int bankPoints(int[] dice) {
		// TODO get dice that have been clicked
		// TODO score dice
		return scoring.scoreDice(dice);

	}

	private boolean resetTurn(boolean computerTurns) {
		if (computerTurns) {
			return false;
		} else
			return true;

	}

	public int[] lockDice(int[] dice) {
		// TODO lock the dice on the GUI
		return dice;

	}

	// returns array with random numbers if the current number is not -1
	private int[] rollDice() {
		for (int i = 0; i < 6; i++) {
			if (dice[i] != -1) {
				dice[i] = (int) (Math.random() * 6 + 1);
			}
		}
		return dice;
	}

	public boolean winCondition() {
		return false;
		// TODO code win condition

	}

	public String printDice() {
		String theDice = "";
		for (int i = 0; i < 6; i++) {
			theDice = theDice + " " + dice[i] + "\n";
		}
		return theDice;

	}

}
