package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.gameState;
import Game.scoring;

class gameStateTest
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

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
		// fail("Not yet implemented");
	}

}
