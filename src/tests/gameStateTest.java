package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import Game.gameState;
import Game.scoring;

class gameStateTest
{

	@Test
	void testToggleDice()
	{
		int[] dice =
		{ -1, -1, -1, -1, -1, 1 };
		gameState aGame = new gameState();
		aGame.setDice(dice);
		aGame.toggleDice(5);
		assertEquals(100, scoring.scoreDice(aGame.getDiceToggle()));
		aGame.toggleDice(5);
		assertEquals(0, scoring.scoreDice(aGame.getDiceToggle()));
	}

	@Test
	void testGetDiceToggle()
	{
		int[] dice =
		{ -1, -1, -1, -1, -1, -1 };
		gameState aGame = new gameState();
		assertEquals(dice[0], aGame.getDiceToggle()[0]);
		assertEquals(dice[1], aGame.getDiceToggle()[1]);
		assertEquals(dice[2], aGame.getDiceToggle()[2]);
		assertEquals(dice[3], aGame.getDiceToggle()[3]);
		assertEquals(dice[4], aGame.getDiceToggle()[4]);
		assertEquals(dice[5], aGame.getDiceToggle()[5]);
	}

	@Test
	void testGetDiceAtIndex()
	{
		int[] dice =
		{ -1, 1, 2, 3, 6, -1 };
		gameState aGame = new gameState();
		aGame.setDice(dice);
		assertEquals(-1, aGame.getDiceAtIndex(0));
		assertEquals(1, aGame.getDiceAtIndex(1));
		assertEquals(2, aGame.getDiceAtIndex(2));
		assertEquals(3, aGame.getDiceAtIndex(3));
		assertEquals(6, aGame.getDiceAtIndex(4));
		assertEquals(-1, aGame.getDiceAtIndex(5));

	}

}
