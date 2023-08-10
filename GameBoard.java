

/**
 * Player.java class belong to BridgeBuilderAdv package
 */
package BridgeBuilderAdv;
/**
 * In placeToken method, I knew that the player can only place a token in an empty position and since we already have a method isPositionEmpty method that checks if the position is empty 
 * so then I call the method and if the position is empty, i initialize that position with the value of token. Then in isPositionEmpty method i needed to check if that position is empty 
 * and i knew that empty position is denoted by ‘.’ so if that position (board at that row and column) is ‘.’ return true meaning it is empty position otherwise return false meaning it isn’t empty position. 
 * Then in displayBoard method I used ASCII table as shown in zybooks to print out the column numbers since minimum size of table is 3, I started off with printing out A B C then since A is 65, B is 66, 
 * C is 67 and D is 68 so since i'm just printing out after C i set variable o 68 and increment it until column reaches last row minus 3 since first 3 columns already printed. 
 * Then to print row numbers I just iterated through the rows until the last row of the board and printed out row numbers before I printed out the positions in the board. 
 * However, when I did this I noticed that the grid seems a bit unorganized as row numbers greater than 1, their positions are shifted by 1 on the right a bit. 
 * O for them to look more aligned when row numbers are less than or equal to 0 i printed space on screen then the positions and for row numbers greater than 9 i printed no space, 
 * this way it looks more like a perfect grid with its alignment. Now, the checkForWinDirection method was wear I had most difficulty with, the diagonal bridge win was very easy for me to do 
 * since in diagonal the row and column would be same but for left to right bridge win it required me to set the count variable to 0 after the iteration of row so goes through same row 
 * then see of player has made their move in position and if the count is same length as size of board that means it has formed bridge through whole grid. 
 * Now, the bottom to up bridge was the hardest here but how I overcame this was by switching the row and column as in this case I wanted to go over the same column at different rows for bottom to top win. 
 * And the countTie method was challenging at first until I realized I can first find if it's empty then return false if it is empty since tie will occur for a full grid. 
 * And step taken for testing as I created the main class in gameboard class then I placed the tokens on the specified row and column and then I displayed the board and checked for the win direction 
 * by calling checkForWinDirection method.
 */
/**
 * This class represents the gameboard where the game will be played and the construction zone and includes methods for displaying the board and check the game status
 * @author skullar5
 *
 */
public class GameBoard {
	/**
	 * gameboard board (grid)
	 */
	private char[][] board;
	/**
	 * size of the board that user inputted (if user inputted 3, size of board is 3 by 3)
	 */
	private int size;
	
	/**
	 * Constructor creates board with given size and initializes all position with '.' indicating the board starts off with all empty positions
	 * @param size size of board
	 * @param board gameboard board
	 */
	public GameBoard(int size) {
		// initializing size and board to 2D char array with empty positions indicated by '.'
		this.size = size;
		board = new char[size][size];
		
		// iterate through each row and column of board and initialize empty position for each row and each column
		for(int row = 0; row < size; row++) {
			for(int col = 0; col < size; col++) {
				board[row][col] = '.';
			}
		}
	}
	
	/**
	 * placeToken method that places the given token  at the row and column on the gameboard that user specifies
	 * @param row rows of board
	 * @param col columns of board
	 * @param token given token 
	 */
	public void placeToken(int row, int col, char token) {
		// if the specified row and column is an empty position then place the token in that specified position
		if(isPositionEmpty(row,col)) {
			board[row][col] = token;
		}
		
	}
	
	/**
	 * isPositionEmpty method checks if the position the user specified is empty (indicated by '.') 
	 * @param row rows of board
	 * @param col columns of board
	 * @return true if specified position is empty otherwise false
	 */
	public boolean isPositionEmpty(int row, int col) {
		// if the specified row and col is denoted by '.' or is an empty position then return true, otherwise return false
		if(board[row][col] == '.') {
			return true;
			
		} else {
			return false;
		}
	}
	
	/**
	 * Accessor method to get the size of the board
	 * @return size of board
	 */
	public int getSize() {
		// get size of board
		return this.size;
	}
	
	/**
	 *  displayBoard method that prints the gameboard on the console, including row and column numbers
	 */
	public void displayBoard() {
		
		// to print out the column numbers, ASCII values from ASCII table is used
		// in ASCI, A is 65, B is 66, C is 67 and ASCII increases by 1 until Z is 90 (since the max size of the grid is 26 so the column will go until z which is 90 in ASCII)
		// Since the minimum size of the grid is 3, print out A B C then iterate through the row until the row isnt the specified size - 3  and print out the alphabet and increment the alphabet's ascii value 1
		// this will cause the alphabets to print out for the number of column numbers and until the row hasnt reached the specific size - 3
		System.out.print("   A B C");
		char alphaOrder = 68; // ASCII value for D is 68
		for (int column = 0; column < size - 3; column++) {
			System.out.print(" " + alphaOrder);
			alphaOrder++;
		}
		// prints new line
		System.out.println();
	
		// iterate through each row until the size of the board (it reaches the last row in board) and print the row numbers
		// if the row is less than or equal to 9 then print a space else if row number is greater than 9 then print no space => This will cause the grid to become more aligned and not causing the row numbers greater than 9 to be shifted by the right by 1 and be well aligned
		// then iterate through the column until the size of the board (it reaches the last column in board) and print out the board's row and columns printing out the gameboard
		// T
		for(int row = 0; row < size; row++) {
			System.out.print(row + " ");
			if(row <= 9) {
				System.out.print(" ");
			}else if (row > 9) {
				System.out.print("");
			}
			for(int col = 0; col < size; col++) {
				System.out.print(board[row][col] + " ");
			}
			// prints a new line
			System.out.println();
			
			
			
		}
	}
	
	/**
	 * checkForWinDirection method checks if the player has won the game in the directions: left to right, bottom to top, and diagonally
	 * @param player
	 * @return 1 for left to right, 2 for bottom to top and 3 for diagonally
	 */
	public int checkForWinDirection(Player player) {
		
		// initialize countLeftRight variable as 0 which will store the number of positions that will be used to form the left to right bridge
		int countLeftRight = 0;
		// iterate through the row until the last row of the board and then reset the count as 0 so the row remains the same 
		// then iterate through the column until it reaches the last column of the board then if at the position, the move is the player's token '+' representing that if player had made their move on that position
		// then increment the count by 1 and if the count reaches the size of the board meaning it has formed the bridge then return 1 for creating a left to right bridge
		for(int row = 0; row < size; row++) {
			countLeftRight = 0;
			
			for(int col = 0; col < size; col++) {
				if(board[row][col] == player.getToken()) {
					countLeftRight++;
					
					if(countLeftRight == size) {
						return 1;
					}
				}
			}
		}
		
		// initialize countBottomTop variable as 0 which will store the number of positions that will be used to form the bottom to up bridge
		int countBottomTop = 0;
		// iterate through the row until the last row of the board and then reset the count as 0 so the row remains the same 
		// then iterate through the column until it reaches the last column of the board then if at the position, the move is the player's token '+' representing that if player had made their move on that position
		// then increment the count by 1 and if the count reaches the size of the board meaning it has formed the bridge then return 2 for creating a bottom to up bridge
		for(int row = 0 ; row < size ; row++) {
			countBottomTop = 0;

			for(int col = 0; col < size ; col++) {
				// switch the row number with column number so that it goes through the same column just different rows to find if the player has made a bottom to up bridge
				if(board[col][row] == player.getToken()) {
					countBottomTop++;
					
					if(countBottomTop == size) {
						return 2;
					}
				}
				
			}
		}

		// initialize countDiagonal variable as 0 which will store the number of positions that will be used to form the diagonal bridge
		int countDiagonal = 0;
		// iterate through the row until the last row of the board and since its diagonal the row number will be same as column number
		// so if board at the same column number as the row number has been marked '+' showing that player has made their move on that position 
		/// then increment the count by 1 and if the count reaches the size of the board meaning it has formed the bridge then return 3 for creating a diagonal bridge
		for(int row = 0; row < size; row++) {
			
			if(board[row][row] == player.getToken()) {
				countDiagonal++;
				
				if(countDiagonal == size) {
					return 3;
				}
			}
			
		}
		// else if no left to right, bottom to up, diagonal bridge formed then return 0
		return 0;
	}
	/**
	 * checkForTie method to check if the gameboard is full and if so indicate it is a tie
	 * @return true if full and false if not full (or empty)
	 */
	public boolean checkForTie() {
		// iterate through the row and columns of the board until it reaches the last row and the last column of the board
		// then any of the positions (row and columns) are empty then return false 
		// otherwise return true
		for(int row = 0; row < size; row++) {
			
			for(int col = 0; col < size; col++) {
				
				if(isPositionEmpty(row, col)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//
	//  + + 0
	//  0 + +
	//  0 + +
	//
	
	/*public static void main(String [] args) {
		
		GameBoard board = new GameBoard(4);
		Player p = new Player();
		
		System.out.println("Display Board: ");
		board.displayBoard();
		//board.isPositionEmpty(1, 1);
		board.placeToken(0, 0, '+');
		board.placeToken(0, 1, '+');
		board.placeToken(0, 2, '+');
		board.placeToken(0, 3, '+');
		board.placeToken(1, 2, '+');
		board.placeToken(3, 2, '+');
		board.placeToken(2, 2, '+');
		board.placeToken(1, 1, '+');
		board.placeToken(3, 3, '+');
		
		
		
		board.displayBoard();
		System.out.println("Win direction: " + board.checkForWinDirection(p));
		
		
		
	}*/

}
