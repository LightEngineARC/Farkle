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

import java.util.Scanner;

/**
 * @author Ashton
 *
 */
public class gameState
{

	int[] dice =
	{ 0, 0, 0, 0, 0, 0 };
	int[] diceToggle =
	{ -1, -1, -1, -1, -1, -1 };

	int playerScore = 0;
	int computerScore = 0;
	int runningScore = 0;
	boolean computerTurn = false;
	computer computer;
	Scanner scanner = new Scanner(System.in);

	public gameState()
	{
		this.dice = this.rollDice();
		this.playerScore = 0;
		this.computerScore = 0;
		computer = new computer(dice, this.computerScore);

	}

	public void game()
	{

		System.out.println("rolling the first dice");
		this.dice = rollDice();
		while (!winCondition())
		{
			// TODO manage turns
			// start turn by rolling dice

			System.out.println("dice are the following:");
			System.out.println(this.printDice());
			if (computerTurn)
			{
				System.out.println("computer plays");
				this.dice = rollDice();
				// TODO add computer turn logic here

			} else
			{

				// TODO PLAYER TURN logic here

				System.out.println("player turn! enter the indeces of the die you want to toggle, or -1 to bank");
				this.dice = rollDice();

				if (scoring.scoreDice(dice) == 0)
				{
					System.out.println("farkle!");
					break;
				}

				int input = -1;
				do
				{

					input = scanner.nextInt();
					if (input != -1)
					{
						diceToggle[input] = dice[input];
					} else
					{
						bankPoints(diceToggle);
						computerTurn = true;
					}

					System.out.println("selection is worth " + scoring.scoreDice(this.diceToggle) + " points");
					if (scoring.scoreDice(dice) == 0)
					{
						computerTurn = true;
					}

				} while (!computerTurn);
				bankPoints(this.diceToggle);

			}
			computerTurn = resetTurn(computerTurn);
		}
		/*
		 * TODO player selects dice and they are scored each time if (computerTurn) {
		 * computer.computerTurn(); }
		 */

		computerTurn = resetTurn(computerTurn);
		System.out.println("rolling the dice again!");
	}

	// TODO game over here

	private void bankPoints(int[] dice)
	{
		// TODO get dice that have been clicked
		// TODO score dice
		if (computerTurn)
		{
			if (computerScore > 500 || scoring.scoreDice(dice) > 500)
			{
				computerScore = +scoring.scoreDice(dice);
			}
		} else
		{
			if (playerScore > 500 || scoring.scoreDice(dice) > 500)
			{
				playerScore = +scoring.scoreDice(dice);
			}
		}

	}

	private boolean resetTurn(boolean computerTurns)
	{
		if (computerTurns)
		{
			return false;
		} else
			return true;

	}

	public int[] lockDice(int[] dice)
	{
		// TODO lock the dice on the GUI
		return dice;

	}

	// returns array with random numbers if the current number is not -1
	public int[] rollDice()
	{
		for (int i = 0; i < 6; i++)
		{
			if (dice[i] != -1)
			{
				dice[i] = (int) (Math.random() * 6 + 1);
			}
		}
		return dice;
	}

	public boolean winCondition()
	{
		if (computerTurn)
		{
			if (computerScore >= 10000)
			{
				return true;
			}
		} else
		{
			if (playerScore >= 10000)
			{
				return true;
			}
		}
		return false;

	}

	public String printDice()
	{
		String theDice = "";
		for (int i = 0; i < 6; i++)
		{
			theDice = theDice + " " + dice[i] + "\n";
		}
		return theDice;

	}

	public int getDiceAtIndex(int index)
	{
		return this.dice[index];
	}

	/**
	 * @return the dice
	 */
	public int[] getDice()
	{
		return dice;
	}

	/**
	 * @param dice
	 *            the dice to set
	 */
	public void setDice(int[] dice)
	{
		this.dice = dice;
	}

	/**
	 * @return the playerScore
	 */
	public int getPlayerScore()
	{
		return playerScore;
	}

	/**
	 * @param playerScore
	 *            the playerScore to set
	 */
	public void setPlayerScore(int playerScore)
	{
		this.playerScore = playerScore;
	}

	/**
	 * @return the computerScore
	 */
	public int getComputerScore()
	{
		return computerScore;
	}

	/**
	 * @param computerScore
	 *            the computerScore to set
	 */
	public void setComputerScore(int computerScore)
	{
		this.computerScore = computerScore;
	}

	/**
	 * @return the runningScore
	 */
	public int getRunningScore()
	{
		return runningScore;
	}

	/**
	 * @param runningScore
	 *            the runningScore to set
	 */
	public void setRunningScore(int runningScore)
	{
		this.runningScore = runningScore;
	}

	/**
	 * @return the computerTurn
	 */
	public boolean isComputerTurn()
	{
		return computerTurn;
	}

	/**
	 * @param computerTurn
	 *            the computerTurn to set
	 */
	public void setComputerTurn(boolean computerTurn)
	{
		this.computerTurn = computerTurn;
	}

	public void toggleDice(int index)
	{
		if (dice[index] != -1)
		{
			if (diceToggle[index] == -1)
			{
				diceToggle[index] = dice[index];
			} else
			{
				diceToggle[index] = -1;
			}
		}

	}

	/**
	 * @return the diceToggle
	 */
	public int[] getDiceToggle()
	{
		return diceToggle;
	}

}
