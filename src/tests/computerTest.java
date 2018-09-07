package tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Game.computer;

/**
 * @author iamsp
 *
 */
class computerTest {

	/****************************************************
	 * Method : NAME
	 *
	 * Purpose : DESCRIPTION
	 *
	 * Parameters : type - description number_of_elements - the number of elements
	 * in the type
	 *
	 * Returns : What does it return
	 *
	 ****************************************************/
	@BeforeEach
	void setUp() throws Exception {
	}

	/****************************************************
	 * Method : NAME
	 *
	 * Purpose : DESCRIPTION
	 *
	 * Parameters : type - description number_of_elements - the number of elements
	 * in the type
	 *
	 * Returns : What does it return
	 *
	 ****************************************************/
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Game.computer#computerTurn()}.
	 */
	@Test
	void chooseDice() {
		int[] dice = { 1, 1, 2, 2, 2, 5 };
		computer comp = new computer(dice, 0);
		dice = comp.chooseDice();
		assertEquals(dice[0], 1);
		assertEquals(dice[1], 1);
		assertEquals(dice[2], 1);
		assertEquals(dice[3], 1);
		assertEquals(dice[4], 1);
		assertEquals(dice[5], 1);

	}

	@Test
	void chooseDiceNoScore() {
		int[] dice = { 2, 3, 4, 6, 2, 4 };
		computer comp = new computer(dice, 0);
		dice = comp.chooseDice();
		assertEquals(dice[0], -1);
		assertEquals(dice[1], -1);
		assertEquals(dice[2], -1);
		assertEquals(dice[3], -1);
		assertEquals(dice[4], -1);
		assertEquals(dice[5], -1);

	}

	@Test
	void chooseDiceBigSet() {
		int[] dice = { 2, 2, 2, 3, 3, 3 };
		computer comp = new computer(dice, 0);
		dice = comp.chooseDice();
		assertEquals(dice[0], 1);
		assertEquals(dice[1], 1);
		assertEquals(dice[2], 1);
		assertEquals(dice[3], 1);
		assertEquals(dice[4], 1);
		assertEquals(dice[5], 1);

	}

}
