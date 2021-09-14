package ticTacToe;
import java.util.Scanner;
import java.lang.Exception;

public class Game {
	private static Scanner inputNumber = new Scanner(System.in); //It is used for input from keyboard
	
	/**
	 * inputMode method will display message and input mode from keyboard.
	 * @return mode
	 */
	private static int inputMode() {
		System.out.println("\nInput 1 for One player and CPU mode:");
		System.out.println("Input 2 for Two players mode:");
		System.out.print("Input 3 for Exit:");
		int mode = inputNumber.nextInt();
		return mode;
	}
	
	public static void main(String[] args) {
		try {
			int mode = inputMode();
			if(mode == 3) {
				System.out.println("\nGame exit");
				System.exit(0);
			}
			TicTacToe game = new TicTacToe();
			while(true) {
				//print game board on the screen
				game.printBoard();
				System.out.print("\nPlayer1 sign:"+game.getPlayer1Sign());
				if(mode == 1) {
					System.out.println("\nCPU sign:"+game.getComputerSign());
				}
				else {
					System.out.println("\nPlayer2 sign:"+game.getPlayer2Sign());
				}
	
				System.out.print("Input row index for Player1[0-2]:");
				// input row position of the game board array for player 1
				int row = inputNumber.nextInt();
				System.out.print("Input column index for player1[0-2]:");
				// input column position of the game board array for player 1
				int col = inputNumber.nextInt();
	
				if(game.putSignForPlayer(row,col,game.getPlayer1Sign())) {
					char sign = game.gameOver();
					if(game.getPlayer1Sign() == sign) {
						game.printBoard();
						System.out.println("\nCongratulation!! Player 1 win the game");
						mode = inputMode();
						if(mode != 3) {
							game.clearCells();
							continue;
						}
						else {
							System.out.println("\nGame exit");
							System.exit(0);
						}
					}
					else if(!game.isAllCellFilled()){
						if(mode == 2) {
							boolean valid = false;
							do {
								game.printBoard();
								System.out.print("\nInput row index for Player2[0-2]:");
								// input row position of the game board array for player 2
								row = inputNumber.nextInt();
								System.out.print("Input column index for player2[0-2]:");
								// input row position of the game board array for player 2
								col = inputNumber.nextInt();
								valid = game.putSignForPlayer(row,col,game.getPlayer2Sign());
							}while(valid != true);
						}
	
						else if(mode == 1) {
							game.autoPutSignForComputer();
						}
						sign = game.gameOver();
						if(game.getComputerSign() == sign) {
							game.printBoard();
							if(mode == 1) {
								System.out.println("\nCongratulation !! CPU win the game");
							}
							else {
							 	System.out.println("\nCongratulation !! Player2 win the game");
							}
							mode = inputMode();
							if(mode != 3) {
								game.clearCells();
								continue;
							}
							else {
								System.out.println("\nGame exit");
								System.exit(0);
							}
						}
					}
					else {
						System.out.println("\nBoth loose the game!!");
						mode = inputMode();
						if(mode != 3) {
							game.clearCells();
							continue;
						}
						else {
							System.out.println("\nGame exit");
							System.exit(0);
						}
					}
				}
			}
		}
		catch(Exception e) {
		  System.out.println("\nGame exit " +  e.toString());
		}
	  }
}