
/**
 * Engineer.java class belong to BridgeBuilderAdv package
 */
package BridgeBuilderAdv;
// import the random class 
import java.util.Random;

/**
 * This class represents the computer-controlled player and the rival engineer and includes the methods for marking its move based on selected difficulty level and blocking player's path
 *
 */
public class Engineer {
	/*
	 * token represents engineers move
	 */
	private char token;
	/*
	 * boolean variable hardmode set true when user choose difficulty level 2 but set false if user chooses difficulty level 1
	 */
	private boolean hardMode;
	
	/**
	 * Constructor creates token that will be representing engineers move and show a '0' sign wherever engineer has made their move and the hardMode indicating if user chose hard mode or easy mode
	 * @param hardMode boolean Variable for hard mode of game
	 */
	public Engineer(boolean hardMode) {
		// initialize the token and set the hardMode
		this.token = '0';
		this.hardMode = hardMode;
		
	}
	
	/**
	 * makeMove method which based on the difficulty level(hardMode), makes move on gamebaord at position determined by Engineeer's strategy: 
	 * in easy mode, engineer will select a random empty position and in hard mode, engineer selects next player's last position or if row is full, selects topmost empty position in same column and if full then selects left  to the players move and if that is full then down of players move
	 * @param board gamboard grid
	 * @param playerLastRow row of player's last position
	 * @param playerLastCol column of player's last position
	 */
	public void makeMove(GameBoard board, int playerLastRow, int playerLastCol) {
		// Either the game is in easy mode or hard mode needs a random move
		// if the user chooses difficulty level of 2 (hardmode is set as true) and if hardmode is set true then 
		if(hardMode) {
			// iterate starting from the column to the right of the player's last position until the last column in the board
			// then if that position is empty place a token ('0') in that position and end the turn
			for(int right = playerLastCol + 1; right < board.getSize(); right++) {
				
				if(board.isPositionEmpty(playerLastRow, right)) {
					board.placeToken(playerLastRow, right, this.token);
					return;
				}
			}
			// iterate through rows until the row of player's last position then 
			// if that position is empty place a token ('0') in that position and end the turn
			for(int top = 0; top < playerLastRow; top++) {
				
				if(board.isPositionEmpty(top, playerLastCol)) {
					board.placeToken(top,  playerLastCol, this.token);
					return;
				}
			}
			
			// iterate starting row below the row of the player's last position until the last row of the board then 
			//// if that position is empty place a token ('0') in that position and end the turn
			for(int down = playerLastRow + 1; down < board.getSize(); down++) {
				
				if(board.isPositionEmpty(down, playerLastCol)) {
					board.placeToken(down, playerLastCol, this.token);
					return;
				}
			}
			
			// iterate starting from the column to the left of the column of player's last position and until that column number is greater than or equal to 0 then
			// if that position is empty place a token ('0') in that position and end the turn
			for(int left = playerLastCol -1; left >= 0; left--) {
				
				if(board.isPositionEmpty(playerLastRow, left)) {
					board.placeToken(playerLastRow, left, this.token);
					return;
				}
			
			}

			//System.out.println("END OF HARD MODE if statement");
		
		}

		
		
		// Create random object to make random moves on grid
		
		Random random = new Random();
		
		//Initialize isFound variable as false which represents the empty position and while isFound is false (meaning the empty slot isnt found)
		//go through grid to find the empty position from 0 to board.getSize() - 1 then
		//once empty position has been found set it as true (since its found)
		boolean isFound = false;
		while (isFound == false) {
			// initialize row and column to be random position
			int row = random.nextInt(board.getSize());
			int col = random.nextInt(board.getSize());
			
			// if position is empty then place token '0' there and set isFound as true since empty position has been found
			if(board.isPositionEmpty(row, col)) {
				board.placeToken(row, col, this.token);
				isFound = true;
			}
		}
		
	}
	/**
	 * Accessor method to get engineer's token
	 * @return engineer's token
	 */
	public char getToken() {
		//get engineer's token 
		return this.token;
	}
	
	
	/*
	public static void main(String [] args) {
		
		GameBoard board = new GameBoard(3);
		Player p = new Player();
		Engineer e = new Engineer(true);
		
		System.out.println("Display Board: ");
		
		board.placeToken(2, 2, '+');
		board.placeToken(1, 1, '+');
		board.placeToken(0, 1, '0');
		board.placeToken(0, 2, '0');
		board.placeToken(1, 2, '+');
		board.placeToken(2, 0, '+');
		
		board.placeToken(2, 1, '+');
		e.makeMove(board, 2, 1);
		
		//board.placeToken(1, 2, '0');
		//board.placeToken(1, 1, '+');

//		board.placeToken(0, 2, '+');
//		board.placeToken(2, 0, '0');
//		board.placeToken(2, 1, '+');
//		board.placeToken(2, 2, '+');
//		board.placeToken(1, 0, '0');
//		board.placeToken(1, 1, '+');
		//System.out.println("BEFORE:");
		board.displayBoard();
		
		//e.makeMove(board, 1, 1);
		//System.out.println("AFTER:");
		//board.displayBoard();
	}*/
}
