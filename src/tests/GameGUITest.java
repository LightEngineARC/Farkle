package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.GameGUI;

class GameGUITest
{

	@BeforeEach
	void setUp() throws Exception
	{
	}

	@Test
	void testTheToggler()
	{

	}

	@Test
	void testChangeIcon()
	{
		assertEquals("/Game/images/die-red-1b.png", GameGUI.changeIcon(1, "1."));
		assertEquals("/Game/images/die-red-1.png", GameGUI.changeIcon(1, "1b."));

		assertEquals("/Game/images/die-red-2b.png", GameGUI.changeIcon(2, "2."));
		assertEquals("/Game/images/die-red-2.png", GameGUI.changeIcon(2, "2b."));

		assertEquals("/Game/images/die-red-3b.png", GameGUI.changeIcon(3, "3."));
		assertEquals("/Game/images/die-red-3.png", GameGUI.changeIcon(3, "3b."));

		assertEquals("/Game/images/die-red-4b.png", GameGUI.changeIcon(4, "4."));
		assertEquals("/Game/images/die-red-4.png", GameGUI.changeIcon(4, "4b."));

		assertEquals("/Game/images/die-red-5b.png", GameGUI.changeIcon(5, "5."));
		assertEquals("/Game/images/die-red-5.png", GameGUI.changeIcon(5, "5b."));

		assertEquals("/Game/images/die-red-6b.png", GameGUI.changeIcon(6, "6."));
		assertEquals("/Game/images/die-red-6.png", GameGUI.changeIcon(6, "6b."));

		assertEquals("Should be the same", GameGUI.changeIcon(-1, "Should be the same"));

		assertEquals("", GameGUI.changeIcon(11, ""));

	}

}
