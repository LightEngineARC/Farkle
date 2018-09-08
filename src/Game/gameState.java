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
	boolean computerTurn = true;
	computer computer;
	Scanner scanner = new Scanner(System.in);

	public gameState()
	{
		rollDice();
		this.playerScore = 0;
		this.computerScore = 0;
		computer = new computer(dice, this.computerScore);

	}

	/**
	 * Method : computerTurn
	 *
	 * Purpose : give the machines a chance at victory
	 *
	 * Parameters : none.
	 *
	 * Returns : void
	 */
	public void computerTurn()
	{
		if (computerTurn && scoring.scoreDice(this.dice) != 0)
		{
			computer.setDice(dice);
			computer.chooseDice();
		}

	}

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
	public void rollDice()
	{
		for (int i = 0; i < 6; i++)
		{
			if (dice[i] != -1)
			{
				dice[i] = (int) (Math.random() * 6 + 1);
			}
		}
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

	public int getToggleDiceAtIndex(int index)
	{
		return this.diceToggle[index];
	}

	public void setToggleDiceAtIndex(int index, int number)
	{
		this.diceToggle[index] = number;
	}

	public void setDiceAtIndex(int index, int number)
	{
		this.dice[index] = number;
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

	/**
	 * @param diceToggle
	 *            the diceToggle to set
	 */
	public void setDiceToggle(int[] diceToggle)
	{
		this.diceToggle = diceToggle;
	}

}
