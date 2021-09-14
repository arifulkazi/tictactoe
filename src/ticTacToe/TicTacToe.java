package ticTacToe;

import java.util.Random;

public class TicTacToe {
	private final int NUMBER_OF_ROWS = 3; //This is number of rows the ticTacToe board
	private final int NUMBER_OF_COLS = 3; //This is number of columns the ticTacToe board
	private final char player1Sign = 'X'; //X sigh is used for player1 on the ticTacToe board
	private final char computerSign = 'O'; //0 sigh is used for CPU on the ticTacToe board
	private final char player2Sign = 'O'; //0 sigh is used for player1 on the ticTacToe board
	
	private char [][] gameBoard; //This is used to store the symbols of the board
	private Random mRandom; //This is used to generate random number for CPU player.	
	
	/**
	 * TicTacToe constructor
	 */
	public TicTacToe() {
		//Allocate two dimension array for ticTacToe board 
		gameBoard = new char[NUMBER_OF_ROWS][NUMBER_OF_ROWS];
		//Initialize ticTacToe board. 
		clearCells();
		mRandom = new Random();
	}
	
	/**
	 * getPlayer1Sign method will return the player1 sign.
	 * @return player1Sign
	 */
	public char getPlayer1Sign() {
		return player1Sign;
	}
	
	/**
	 * getComputerSign method will return the CPU sign.
	 * @return computerSign 
	 */
	public char getComputerSign() {
		return computerSign;
	}
	
	/**
	 * getPlayer2Sign method will return the player1 sign.
	 * @return player2Sign
	 */
	public char getPlayer2Sign() {
		return player2Sign;
	}
	
	/**
	 * autoPutSignForComputer method will automatically put the sign into the board for CPU
	 */
	public void autoPutSignForComputer() {
		int row = mRandom.nextInt(3);
		int col = mRandom.nextInt(3);
		
		while(gameBoard[row][col] != ' ') {
			row = mRandom.nextInt(3);
			col = mRandom.nextInt(3);
		}
		gameBoard[row][col] = computerSign;
	}
	
	/**
	 * putSignForPlayer method will put the sign into gameBoard[row][col] position for the player.
	 * @param row  Row position of the game board 2D array.
	 * @param col  Row position of the game board 2D array.
	 * @param sign Put sign on gameBoard[row][col] position.
	 * @return true if successfully put the sign otherwise false return;
	 */
	public boolean putSignForPlayer(int row, int col,char sign) {
		if(row >=0 && row < NUMBER_OF_ROWS) {
			if(col >= 0 && col < NUMBER_OF_COLS){
				if(gameBoard[row][col] != ' ') {
					System.out.println("Already sign exists in["+ row + "][" + col +"]. Please try another cell");
					return false;
				}
				gameBoard[row][col] = sign;
			}
			else {
				System.out.println("Invalid column number");
				return false;
			}
		}
		else {
			System.out.println("Invalid row number");
			return false;
		}
		return true;
	}
	
	
	/**
	 * isAllCellFilled method will check whether all position of gameBoard 2D array  filled or not.
	 * @return true if cells are available otherwise false returned;
	 */
	public boolean isAllCellFilled() {
		 for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			 for(int j = 0; j < NUMBER_OF_COLS; j++) {
				 if(gameBoard[i][j] == ' ') {
					 return false;
				 }
		     }
	    }
		return true;
	}
	
	/**
	 * clearCells method will initialize all the position of gameBoard 2D array into empty space
	 */
	public void clearCells() {
		 for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			 for(int j = 0; j < NUMBER_OF_COLS; j++) {
				 gameBoard[i][j] = ' ';
				 
		     }
	    }
	}
	
	/**
	 * gameOver method will check whether game is completed or not according to the rule.
	 * Detail game rule: https://en.wikipedia.org/wiki/Tic-tac-toe
	 * @return true if cells are available otherwise false returned;
	 */
	public char gameOver(){
		//Check all the rows whether game is completed or not
		for(int i = 0; i<  NUMBER_OF_ROWS; i++) {
			if ((gameBoard[i][0] == gameBoard[i][1]) &&
			      (gameBoard[i][1] == gameBoard[i][2]) &&
				  (gameBoard[i][0] != ' ')) {
				return gameBoard[i][0];
		    }
	     }
		
		//Check all the columns whether game is completed or not
		for(int j = 0;  j<  NUMBER_OF_COLS; j++) {
			if ((gameBoard[0][j] == gameBoard[1][j]) &&
			      (gameBoard[1][j] == gameBoard[2][j]) &&
				  (gameBoard[0][j] != ' ')) {
				return gameBoard[0][j];
		    }
	     }
		
		//Check diagonally whether game is completed or not
		if ((gameBoard[0][0] == gameBoard[1][1]) &&
			      (gameBoard[1][1] == gameBoard[2][2]) &&
				  (gameBoard[0][0] != ' ')) {
				return gameBoard[0][0];
		}
		if ((gameBoard[0][2] == gameBoard[1][1]) &&
			      (gameBoard[1][1] == gameBoard[2][0]) &&
				  (gameBoard[0][2] != ' ')) {
				return gameBoard[0][2];
		}
		return ' ';
	}
	
	/**
	 * Print 2D array game board on the screen
	 */
	public void printBoard() {
		String strBoard = "";
		for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			for(int j = 0; j < NUMBER_OF_COLS; j++) {
				if(j == NUMBER_OF_COLS-1)
					strBoard += " " + gameBoard[i][j] ;
				else
					strBoard += " " + gameBoard[i][j] + " |";
			}
			if(i != NUMBER_OF_ROWS-1)
				strBoard += "\n---+---+---\n";
		}
		System.out.print(strBoard);
	}
}