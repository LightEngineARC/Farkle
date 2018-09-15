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
public class computer
{

	int[] dice =
	{ 0, 0, 0, 0, 0, 0 };
	int[] diceToLock =
	{ -1, -1, -1, -1, -1, -1 };
	int[] sets =
	{ 0, 0, 0, 0, 0, 0 };
	private int score;

	public computer(int[] dice, int score)
	{
		this.score = score;
		this.dice = dice;
	}

	public int[] chooseDice()
	{
		this.sets = new int[]
		{ 0, 0, 0, 0, 0, 0 };
		this.diceToLock = new int[]
		{ -1, -1, -1, -1, -1, -1 };

		// decide which dice to lock
		for (int i = 0; i < 6; i++)
		{
			if (this.dice[i] == 1 || this.dice[i] == 5)
			{
				diceToLock[i] = this.dice[i];
			}
			switch (this.dice[i])
			{
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

			if (sets[0] == 1 && sets[5] == 1 && sets[1] == 1 && sets[2] == 1 && sets[3] == 1 && sets[4] == 1)
			{
				for (int k = 0; k < 6; k++)
				{
					diceToLock[k] = this.dice[k];
				}
				System.out.println("Computer found a Run of Six!");
			}
			int doubleCount = 0;
			for (int t = 0; t < 6; t++)
			{
				if (sets[t] == 2)
				{
					doubleCount++;
				}
			}
			if (doubleCount == 3)
			{
				for (int k = 0; k < 6; k++)
				{
					diceToLock[k] = this.dice[k];
				}
				System.out.println("Computer found Three Pair!");
			}

		}
		for (int j = 0; j < 6; j++)
		{// loop through sets and look for values greater than 2
			if (sets[j] > 2)
			{
				System.out.println("computer found a set of " + sets[j] + " " + (j + 1) + "'s");
				for (int k = 0; k < 6; k++)
				{// loop through dice and check if the value of dice == int j +1
					if (dice[k] == (j + 1))
					{
						diceToLock[k] = this.dice[k];
					}
				}

			}
		}
		sets = new int[]
		{ 0, 0, 0, 0, 0, 0 };
		System.out.println("the computer locks: ");
		System.out.println(printLockedDice());

		return this.diceToLock;

	}

	public boolean toBank(int runningScore, int[] rolledDice, int computerScore)
	{
		int diceUsed = 0;
		if (computerScore == 0)
		{
			if (runningScore >= 500)
			{
				System.out.println("computer now has the points to bank: " + runningScore);
				return true;
			} else
			{
				System.out.println("Computer doesn't have the points to bank " + runningScore);
				return false;
			}

		}
		for (int i = 0; i < 6; i++)
		{
			if (rolledDice[i] < 0)
			{
				diceUsed++;
			}
		}
		if (diceUsed >= 3)
		{

			/*
			 * int decide = 0; decide = (int) (Math.random() * 2); if (decide > 0) {
			 * System.out.println("computer decides to bank"); return true; } else {
			 * System.out.println("computer decides to risk a roll"); return false; }
			 */
			return true;

		}
		System.out.println("Computer decided to roll");

		return false;

	}

	/**
	 * @param dice
	 *            the dice to set
	 */
	public void setDice(int[] dice)
	{
		this.dice = dice;
	}

	public String printLockedDice()
	{
		String toPrint = "";
		for (int s : this.diceToLock)
		{
			if (s != -1)
			{
				toPrint = toPrint + s + " ";
			} else
				toPrint = toPrint + "_ ";
		}
		return toPrint;
	}

}
