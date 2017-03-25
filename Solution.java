package com.flipkart.tictactoe;

public class Solution {
	
	
	/*
	 * Main API function
	 * **/
	public void runGame(TypeOfGame typeOfGame,String [][]board,String input[]){
		if(typeOfGame == TypeOfGame.HUMAN_COMPUTER){
			humanVsComputer(board, input);
		}
		else{
			humanVsHuman(board, input);
		}
	}
	//will return position for computer
	public String getPlayPositionForComputer(String board [][]){
		String index = "-1";
		outter : for(int i=0;i<board.length;i++){
			for(int j=0;j<board.length;j++){
				if(board[i][j].equals("_")){
					index = i+","+j;
					break outter;
				}
			}
		}
		return index;
	}
	
	
	
	/*
	 * Human vs computer
	 * **/
	public void humanVsComputer(String [][]board,String input[]){
		for(int i=0;i<input.length;i++){
			String data = input[i];
			String tempArr [] = data.split(" ");
			String type = tempArr[0];
			int row = Integer.parseInt(tempArr[1]);
			int col = Integer.parseInt(tempArr[2]);
			if(!board[row][col].equals("_")){
				System.out.println(" game Draw or :Error : invaild input : you are passing input position that is already filled.");
				printState(board);
				return;
			}
			//human play
			board[row][col] = "X";
			if(iswin(board, "X")){
				System.out.println("Human Win : X win");
				printState(board);
				return;
			}
			//computer play
			String computerInput = getPlayPositionForComputer(board);
			if(computerInput.equals("-1")){
				System.out.println("No position for computer");
				printState(board);
				return;
			}
			int cRow = Integer.parseInt(computerInput.split(",")[0]);
			int cCol = Integer.parseInt(computerInput.split(",")[1]);
			System.out.println("Computer position : " + computerInput);
			
			if(!board[cRow][cCol].equals("_")){
				
				System.out.println(" game Draw or :Error : invaild input : you are passing input position that is already filled.");
				printState(board);
				return;
			}
			
			board[cRow][cCol] = "O";
			if(iswin(board, "O")){
				System.out.println("Computer Win : O win");
				printState(board);
				return;
			}
			
		}
		System.out.println("game Ended : ++++++++");
	}
	
	
	
	/*
	 * Human vs human
	 * **/
	public void humanVsHuman(String [][]board,String input[]){
		for(int i=0;i<input.length;i++){
			String data = input[i];
			String tempArr [] = data.split(" ");
			String type = tempArr[0];
			if(type.equals("A1")){
				int row = Integer.parseInt(tempArr[1]);
				int col = Integer.parseInt(tempArr[2]);
				if(!board[row][col].equals("_")){
					System.out.println(" game Draw or :Error : invaild input : you are passing input position that is already filled.");
					printState(board);
					return;
				}
				//human play
				board[row][col] = "X";
				if(iswin(board, "X")){
					System.out.println("Human Win A1 : X win");
					printState(board);
					return;
				}
			}
			else{
				int row = Integer.parseInt(tempArr[1]);
				int col = Integer.parseInt(tempArr[2]);
				if(!board[row][col].equals("_")){
					System.out.println(" game Draw or :Error : invaild input : you are passing input position that is already filled.");
					printState(board);
					return;
				}
				//human play
				board[row][col] = "O";
				if(iswin(board, "O")){
					System.out.println("Human Win A2 : O win");
					printState(board);
					return;
				}
			}
			
			
			
		}
		System.out.println("game Ended : ++++++++");
	}
	//print state of the board
	public void printState(String board[][]){
		for(int i=0;i<board.length;i++){	
			for(int j=0;j<board.length;j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	/***
	 * 
	 * @param board
	 * @param str
	 * @return either str has won or not.
	 */
	public boolean iswin(String [][]board, String str){
		//check for first diagonal
		boolean flag = true;
		for(int i=0;i<board.length;i++){
			if(! (board[i][i].equals(str) || board[i][i].equals("R") ) ){
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("First Diagonal");
			return true;
		}
		//check for second diagonal
		flag = true;
		for(int i=0;i<board.length;i++){
			if(!  (board[i][board.length-1-i].equals(str) || board[i][board.length-1-i].equals("R") )  ){
				flag = false;
				break;
			}
		}
		if(flag){
			System.out.println("Second Diagonal");
			return true;
		}
		//check for each row
		flag = false;
		int row = -1;
		for(int i=0;i<board.length;i++){
			boolean flag1 = false;
			for(int j=0;j<board.length;j++){
				
				if(!  (board[i][j].equals(str) || board[i][j].equals("R") )  ){
					flag1 = true;
					
					
				}
				
				if(flag1 == false && j==board.length-1){
					row = i;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("in row : " + row );
			return true;
		}
		//check for each col
		int col = -1;
		flag = false;
		for(int i=0;i<board.length;i++){
			boolean flag1 = false;
			for(int j=0;j<board.length;j++){
				
				if(!  (board[j][i].equals(str) || board[j][i].equals("R") )  ){
					flag1 = true;
					
					
				}
				
				if(flag1 == false && j==board.length-1){
					col = i;
					flag = true;
					break;
				}
			}
		}
		if(flag){
			System.out.println("in col : " + col );
			return true;
		}
		
		
		return false;
	}

}
