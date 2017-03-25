package com.flipkart.tictactoe;

public class TesterForHumanAndHuman {
	public static void main(String args[]){
		// For human vs Computer
		//Testcase 1
		TypeOfGame game = TypeOfGame.HUMAN_HUMAN;
		String board[][] = {
				{"_","_","_"},
				{"_","_","_"},
				{"_","_","_"}
		};
		String input[] = {
			"A1 0 0",
			"A2 1 0",
			"A1 0 1",
			"A2 1 1",
			"A1 0 2"
		};
		Solution solution = new Solution();
		solution.runGame(game, board, input);
		
		//testcase 2
		String board1[][] = {
				{"_","_","_"},
				{"_","R","_"},
				{"_","_","_"}
		};
		String input1[] = {
			"A1 0 0",
			"A2 1 0",
			"A1 0 1",
			"A2 1 2",
			
		};

		solution.runGame(game, board1, input1);
		
		
		
					
	}

}
