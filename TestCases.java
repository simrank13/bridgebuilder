package BridgeBuilderAdv;

public class TestCases {
	
	public static void main(String[] args) {
		GameBoard board = new GameBoard(3);
		Player player = new Player();
		Engineer engineer = new Engineer(true);
		boolean testPassed = true;
		
		System.out.print("Test case for GameBoard constructor: ");
		for(int i = 0; i < board.getSize(); i++) {
			for(int j = 0; j < board.getSize(); j++) {
				if(board.isPositionEmpty(i, j)) {
					testPassed = true;
				} else {
					testPassed = false;
				}
			}
		}
		if(testPassed) {
			System.out.println("test 1 passed");
		} else {
			System.out.println("test 1 failed");
		}
		
		System.out.print("Test case for GameBoard placeToken: ");
		for(int i = 0; i < board.getSize(); i++) {
			for(int j = 0; j < board.getSize(); j++) {
				board.placeToken(i, j, '+');
				if(player.getToken() == '+') {
					testPassed = true;
				} else {
					testPassed = false;
				}
			}
		}
		if(testPassed) {
			System.out.println("test 2 passed");
		} else {
			System.out.println("test 2 failed");
			
		}
		
		System.out.print("Test case for GameBoard isPositionEmpty: ");
		for(int i = 0; i < board.getSize(); i++) {
			for(int j = 0; j < board.getSize(); j++) {
				board.placeToken(i, j, '+');
				if(!board.isPositionEmpty(i, j)) {
					testPassed = true;
				} else {
					testPassed = false;
				}
			}
		}
		if(testPassed) {
			System.out.println("test 3 passed");
		} else {
			System.out.println("test 3 failed");
			
		}
		
		
	}
}
