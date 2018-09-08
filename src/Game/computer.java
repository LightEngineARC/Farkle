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

		// TODO decide which dice to lock
		for (int i = 0; i < 6; i++)
		{
			if (this.dice[i] == 1 || this.dice[i] == 5)
			{
				diceToLock[i] = this.dice[i];
				System.out.println("computer chooses a " + this.dice[i]);
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
			for (int j = 0; j < 6; j++)
			{// loop through sets and look for values greater than 2
				if (sets[j] > 2)
				{
					System.out.println("computer found a set of " + (j + 1) + "'s");
					for (int k = 0; k < 6; k++)
					{// loop through dice and check if the value of dice == int j +1
						if (dice[k] == (j + 1))
						{
							diceToLock[k] = this.dice[k];
							System.out.println("computer locks a " + this.dice[k]);
						}
					}

				}
			}

		}
		System.out.println("computer has finished checking this set");

		return this.diceToLock;

	}

	public boolean toBank(int runningTotal, int[] rolledDice, int score)
	{
		int diceUsed = 0;
		if (this.score == 0)
		{
			if (runningTotal >= 500)
			{
				System.out.println("computer now has the points to bank");
				return true;
			} else
			{
				System.out.println("Computer doen't have the points to bank");
				return false;
			}

		}
		for (int i = 0; i < 6; i++)
		{
			if (rolledDice[i] > 1)
			{
				diceUsed++;
			}
		}
		if (diceUsed >= 3)
		{
			int decide = 0;
			decide = (int) (Math.random() * 2);
			if (decide > 0)
			{
				System.out.println("computer decides to bank");
				return true;
			} else
			{
				System.out.println("computer decides to risk a roll");
				return false;
			}

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

}
