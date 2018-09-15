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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ashton and Sam
 *
 */
public class gameState
{
	final Lock lock = new ReentrantLock();
	final Condition notEmpty = lock.newCondition();
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

	String cString;
	
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
	 * 
	 * @throws InterruptedException
	 */
	public void computerTurn() throws InterruptedException
	{
		if (!winCondition())
		{
			setComputerString("Computer Played");
			while (computerTurn)
			{
				if (scoring.scoreDice(this.dice) != 0)
				{
					System.out.println("computer rolls these dice: " + printDice());
					computer.setDice(dice);// give computer the dice
					diceToggle = computer.chooseDice();// update the diceToggle based on computer logic
					theAllToggle();

					// Decide to bank
					if (computer.toBank(runningScore + scoring.scoreDice(diceToggle), dice, this.computerScore))
					{
						System.out
								.println(
										"computer banks " + (runningScore + scoring.scoreDice(diceToggle)) + " points");
						computerScore = computerScore + runningScore + scoring.scoreDice(diceToggle);
						runningScore = 0;
						this.dice = new int[]
						{ 1, 1, 1, 1, 1, 1 };
						this.diceToggle = new int[]
						{ -1, -1, -1, -1, -1, -1 };
						this.rollDice();
						this.computerTurn = false;
					} else
					{
						this.runningScore = this.runningScore + scoring.scoreDice(diceToggle);
						System.out.println("computer procedes");
						this.rollDice();
					}
				} else
				{
					System.out.println(printDice());
					System.out.println("\nComputer FARKLE\n");
					GameGUI.lblComputerScore.setText("FARKLE");
					this.runningScore = 0;
					this.computerTurn = false;
					this.dice = new int[]
					{ 1, 1, 1, 1, 1, 1 };
					this.diceToggle = new int[]
					{ -1, -1, -1, -1, -1, -1 };
					this.rollDice();
				}
				if (!computerTurn && scoring.scoreDice(dice) == 0)
				{
					System.out.println("\nPlayer FARKLE on first roll\n");
					this.dice = new int[]
					{ 0, 0, 0, 0, 0, 0 };
					this.diceToggle = new int[]
					{ -1, -1, -1, -1, -1, -1 };
					this.computerTurn = true;
					this.rollDice();
				}
			}
			this.diceToggle = new int[]
			{ -1, -1, -1, -1, -1, -1 };
			this.dice = new int[]
			{ 0, 0, 0, 0, 0, 0 };
			this.rollDice();
			System.out.println(printDice());

		} else
		{
			System.out.println("We have a winner!");
		}

	}

	public void setComputerString(String s)
	{
		cString = s;
	}
	public String getComputerString()
	{
		return cString;
	}
	
	private void bankPoints(int[] dice)
	{
		// get dice that have been clicked
		// score dice
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

	public int[] lockDice(int[] dice)
	{
		// TODO lock the dice on the GUI
		return dice;

	}

	// returns array with random numbers if the current number is not -1 or all of
	// them if the dice are all used
	public void rollDice()
	{
		int used = 0;
		for (int i = 0; i < 6; i++)
		{
			if (dice[i] != -1)
			{
				dice[i] = (int) (Math.random() * 6 + 1);

			} else
				used++;
			if (used == 6)
			{
				this.dice = new int[]
				{ 0, 0, 0, 0, 0, 0 };
				rollDice();
			}
		}
	}

	public boolean winCondition()
	{
		if (computerScore >= 10000 || playerScore >= 10000)
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
		}
		return false;

	}

	public String printDice()
	{
		String theDice = "";
		for (int i = 0; i < 6; i++)
		{
			if (dice[i] > 0)
			{
				theDice = theDice + dice[i] + " ";
			} else
			{
				theDice = theDice + "_ ";
			}
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

	/**
	 * toggle all of the dice that need to be locked by the computer and if all are
	 * locked, reset them all
	 */
	public void theAllToggle()
	{
		int sum = 0;
		for (int i = 0; i < 6; i++)
		{
			if (this.diceToggle[i] > 0)
			{
				this.dice[i] = (-1);
			} else
				sum++;
		}
		if (sum == -6)
		{
			System.out.println("all dice used, computer gets to roll again");
			this.runningScore = this.runningScore + scoring.scoreDice(diceToggle);
			rollDice();
			System.out.println(printDice());
			this.diceToggle = new int[]
			{ -1, -1, -1, -1, -1, -1 };
		}
	}

}
