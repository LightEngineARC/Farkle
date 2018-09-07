/********************************************************
 *
 *  Project :  Farkle
 *  File    :  PlayFarkle
 *  Name    :  Ashton Chatelain, Sam Smith
 *  Date    :  8/27/2018
 *
 *  Description : Manage the game of Farkle
 *
 *    1) What is the purpose of the code; what problem does the code solve.
 *
 *    2) What data-structures are used.
 *
 *    3) What algorithms, techniques, etc. are used in implementing the data structures.
 *
 *    4) What methods are implemented (optional).
 *
 ********************************************************/
package Game;

/**
 * @author Ashton Chatelain
 *
 */
public class PlayFarkle {

	/****************************************************
	 * Method : Main
	 *
	 * Purpose : run a game of Farkle
	 *
	 ****************************************************/
	public static void main(String[] args) {
		// TODO launch GUI here
		System.out.println("starting a new game of farkle");
		gameState aGame = new gameState();
		aGame.game();
	}

}
