

/**
 * Player.java class belong to BridgeBuilderAdv package
 */
package BridgeBuilderAdv;

/**
 * This class represents the user-controlled player , containing methods for making (marking) moves on the grid of the size user inputted and calculate scores
 */
public class Player {
	/**
	 * token represents player's move
	 */
	private char token;
	/*
	 * score represents scores of player's wins
	 */
	private int score;
	
	/**
	 * Constructor creates token that will be representing players move and show a + sign wherever player has made their move and the score that calculates its scores of wins
	 * @param token token is player's move on grid
	 * @param score player's score stores score of their wins
	 */
	public Player() {
		// set token as + sign so that when and wherever player makes move, it puts a + on that position 
		this.token = '+';
		// set the score as 0
		this.score = 0;
	}
	

	/**
	 * makeMove method which places the player's token on the game board grid at the user's inputted row and column
	 * @param board gameboard grid
	 * @param row rows in gameboard grid
	 * @param col columns in gameboard grid
	 */
	public void makeMove(GameBoard board, int row, int col) {
		// if the position user inputted is empty ('.') set then place the token on that position
		if(board.isPositionEmpty(row, col)) {
			board.placeToken(row, col, token);
		}
		
	}
	/**
	 * Accessor method to get the token of the player
	 * @return token of player
	 */
	public char getToken() {
		// get the player's token
		return this.token;
	}
	
	/**
	 * Accessor method to get the player's current score
	 * @return current score of player
	 */
	public int getScore( ) {
		// get the player's current score
		return this.score;
	}
	
	/**
	 * addScore method that increases the player's score by the specific increment according to the users win 
	 * (add score by 5 if user has made a bridge from left to right, 7 for brigde formed from bottom to top and 
	 * 10 for a top left to bottom right diagonal bridge formed and 1 if the round is tied (meaning grid is full))
	 * @param increment score incremented by certain amount
	 */
	public void addScore(int increment) {
		// increases the score by 1 if grid is full and round is tied, by 5 for a left to right bridge formed across the grid, 
		//by 7 for bottom to top bridge and by 10 for top left to bottom right diagonal bridge
		score += increment;
	}
}
