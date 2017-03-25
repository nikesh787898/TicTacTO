package com.flipkart.tictactoe;

public class Tester {
	public static void main(String args[]){
		// For human vs Computer
		//Testcase 1
		TypeOfGame game = TypeOfGame.HUMAN_COMPUTER;
		String board[][] = {
				{"_","_","_"},
				{"_","R","_"},
				{"_","_","_"}
		};
		String input[] = {
			"A 0 1",
			"A 0 1",
			"A 2 0"
		};
		Solution solution = new Solution();
		solution.runGame(game, board, input);
		
		//Testcase 2
		String board1[][] = {
				{"_","_","_"},
				{"_","","_"},
				{"_","_","R"}
		};
		String input1[] = {
			"A 0 0",
			"A 1 1",
			
		};
		solution = new Solution();
		solution.runGame(game, board1, input1);
		
		
		//Testcase 2
				String board2[][] = {
						{"_","_","_"},
						{"_","_","_"},
						{"_","_","_"}
				};
				String input2[] = {
					"A 2 0",
					"A 2 1",
					"A 1 1"
				};
				solution = new Solution();
				solution.runGame(game, board2, input2);				
	}

}
