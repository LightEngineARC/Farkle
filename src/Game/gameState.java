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

	public static void game() {
		int[] dice = { 0, 0, 0, 0, 0, 0 };
		int playerScore = 0;
		int computerScore = 0;
		int runningScore = 0;
		boolean computerTurn = true;
		System.out.println("rolling the dice");
		dice = rollDice(dice);
		System.out.println("dice are the following:");
		System.out.println(dice);
		while (!winCondition()) {

			// TODO manage turns
			if (computerTurn) {
				System.out.println("computer plays");
			} else
				System.out.println("player turn");

			// start turn by rolling dice
			dice = rollDice(dice);
			if (scoring.scoreDice(dice) == 0) {
				System.out.println("FARKLE");
				computerTurn = resetTurn(computerTurn);
			}
			// TODO player selects dice and they are scored each time
			if (computerTurn) {
				computer.computerTurn(dice);
			}

			computerTurn = resetTurn(computerTurn);
		}
		// TODO game over here
	}

	private int bankPoints(int[] dice) {
		// TODO get dice that have been clicked
		// TODO score dice
		return scoring.scoreDice(dice);

	}

	private static boolean resetTurn(boolean computerTurns) {
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
	private static int[] rollDice(int[] dice2) {
		for (int i = 0; i < 6; i++) {
			if (dice2[i] != -1) {
				dice2[i] = (int) (Math.random() * 5 + 1);
			}
		}
		return dice2;
	}

	public static boolean winCondition() {
		return false;
		// TODO code win condition

	}

}
