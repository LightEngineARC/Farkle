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

}
