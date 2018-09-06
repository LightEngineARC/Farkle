package Game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class scoringTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHighScoreDice() {

		// Test scoring 6 of a kind
		int[] array = { 1, 1, 1, 1, 1, 1 };
		assertEquals(3000, scoring.scoreDice(array));

		// test array of 5 of a kind
		array[5] = -1;
		assertEquals(2000, scoring.scoreDice(array));

		// test array of 4 of a kind
		array[4] = -1;
		assertEquals(1000, scoring.scoreDice(array));

		// test array of 3 ONES
		array[3] = -1;
		assertEquals(300, scoring.scoreDice(array));

		// test array of 1-6
		array = new int[] { 1, 2, 3, 4, 5, 6 };
		assertEquals(1500, scoring.scoreDice(array));

		// test 4 of any number with pair
		array = new int[] { 1, 1, 6, 6, 6, 6 };
		assertEquals(1500, scoring.scoreDice(array));

	}

	@Test
	void testtriples() {

		// test array with two triples
		int[] array = new int[] { 1, 1, 1, 6, 6, 6 };
		assertEquals(2500, scoring.scoreDice(array));

		// test array with triple ONES
		array = new int[] { 1, 1, 1, -1, 6, 6 };
		assertEquals(300, scoring.scoreDice(array));

		// test array with triple TWOS
		array = new int[] { 2, 2, 2, -1, 6, 6 };
		assertEquals(200, scoring.scoreDice(array));

		// test array with triple THREES
		array = new int[] { 3, 3, 3, -1, 6, 6 };
		assertEquals(300, scoring.scoreDice(array));

		// test array with triple FOURS
		array = new int[] { 4, 4, 4, -1, 6, 6 };
		assertEquals(400, scoring.scoreDice(array));

		// test array with triple FIVES
		array = new int[] { 5, 5, 5, -1, 6, 6 };
		assertEquals(500, scoring.scoreDice(array));

		// test array with triple SIXES
		array = new int[] { -1, -1, 6, -1, 6, 6 };
		assertEquals(600, scoring.scoreDice(array));

	}

	@Test
	void testsingles() {
		// test 2 ONES
		int[] array = new int[] { 1, 1, -1, -1, -1, -1 };
		assertEquals(200, scoring.scoreDice(array));
		// Test single ONE
		array = new int[] { 1, -1, -1, -1, -1, -1 };
		assertEquals(100, scoring.scoreDice(array));
		// test single five
		array = new int[] { 5, -1, -1, -1, -1, -1 };
		assertEquals(50, scoring.scoreDice(array));
		// test two fives
		array = new int[] { 5, 5, -1, -1, -1, -1 };
		assertEquals(100, scoring.scoreDice(array));

	}

	@Test
	void testcombos() {
		// test combination of 5s and 1s
		int[] array = new int[] { 1, 1, 5, -1, -1, -1 };
		assertEquals(250, scoring.scoreDice(array));
		array = new int[] { 1, 1, 5, -1, 5, -1 };
		assertEquals(300, scoring.scoreDice(array));
		array = new int[] { 1, -1, 5, -1, 5, 5 };
		assertEquals(600, scoring.scoreDice(array));

	}

}
