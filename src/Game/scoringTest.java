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
	void testScoreDice() {

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
		assertEquals(1000, scoring.scoreDice(array));

	}

}
