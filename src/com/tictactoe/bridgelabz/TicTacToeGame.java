package com.tictactoe.bridgelabz;

import java.util.Random;
import java.util.Scanner;

/*
 * @Discription - a game in which two players alternately put X and O in game board  of a figure.
 *  formed by two vertical lines crossing two horizontal lines and each tries to get a row of three X or three O.
 *  
 */
public class TicTacToeGame {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		char[][] gameBoard = {{' ', ' ', ' '},
				 	      {' ', ' ', ' '}, 
				 	      {' ', ' ', ' '}};
		
		printBoard(gameBoard);
		
		while (true) {
			playerTurn(gameBoard, scanner);
			if (isGameFinished(gameBoard)){
				break;
			}
			printBoard(gameBoard);
			
			computerTurn(gameBoard);
			if (isGameFinished(gameBoard)){
				break;
			}
			printBoard(gameBoard);
		}
		scanner.close();
	}


	private static boolean isGameFinished(char[][] gameBoard) {
		
		if (win(gameBoard, 'X')) {	
			printBoard(gameBoard);
			System.out.println("Player wins!");
			return true;
		}
		
		if (win(gameBoard, 'O')) {	
			printBoard(gameBoard);
			System.out.println("Computer wins!");
			return true;
		}
		
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(gameBoard);
		System.out.println("The game ended in a tie!");
		return true;
	}

/* 
 * if the we get three Xs the player win othewise condition is false then compter win.
 */
	private static boolean win (char[][] gameBoard, char index) {
		if ((gameBoard[0][0] == index && gameBoard [0][1] == index && gameBoard [0][2] == index) ||
			(gameBoard[1][0] == index && gameBoard [1][1] == index && gameBoard [1][2] == index) ||
			(gameBoard[2][0] == index && gameBoard [2][1] == index && gameBoard [2][2] == index) ||
			
			(gameBoard[0][0] == index && gameBoard [1][0] == index && gameBoard [2][0] == index) ||
			(gameBoard[0][1] == index && gameBoard [1][1] == index && gameBoard [2][1] == index) ||
			(gameBoard[0][2] == index && gameBoard [1][2] == index && gameBoard [2][2] == index) ||
			
			(gameBoard[0][0] == index && gameBoard [1][1] == index && gameBoard [2][2] == index) ||
			(gameBoard[0][2] == index && gameBoard [1][1] == index && gameBoard [2][0] == index) ) {
			return true;
		}
		return false;
	}

/*
 * 
 */
	private static void computerTurn(char[][] gameBoard) {
		Random rand = new Random();
		int computerMove;
		while (true) {
			computerMove = rand.nextInt(9) + 1;
			if (isValidMove(gameBoard, Integer.toString(computerMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + computerMove);
		placeMove(gameBoard, Integer.toString(computerMove), 'O');
	}


	private static boolean isValidMove (char[][] board, String position) {
		switch(position) {
			case "1":
				return (board[0][0] == ' ');
			case "2":
				return (board[0][1] == ' ');
			case "3":
				return (board[0][2] == ' ');
			case "4":
				return (board[1][0] == ' ');
			case "5":
				return (board[1][1] == ' ');
			case "6":
				return (board[1][2] == ' ');
			case "7":
				return (board[2][0] == ' ');
			case "8":
				return (board[2][1] == ' ');
			case "9":
				return (board[2][2] == ' ');
			default:
				return false;
		}
	}

/*
 * @Description- to check player move is valid or not.
 */
	private static void playerTurn(char[][] gameBoard, Scanner scanner) {
		String playerTurn;
		while (true) {
			System.out.println("Where would you like to play? (1-9)");
			playerTurn = scanner.nextLine();
			if (isValidMove(gameBoard, playerTurn)){
				break;
			} else {
				System.out.println(playerTurn + " is not a valid move.");
			}
		}
		placeMove(gameBoard, playerTurn, 'X');
	}

/*
 * @Description- put X and O in game board  of a figure formed by two vertical lines
 *  crossing two horizontal lines and each tries to get a row of three X or three O
 *  to check placeamove.
 *  
 */
	private static void placeMove(char[][] gameBoard, String position, char index) {
		switch(position) {
			case "1":
				gameBoard[0][0] = index;
				break;
			case "2":
				gameBoard[0][1] = index;
				break;
			case "3":
				gameBoard[0][2] = index;
				break;
			case "4":
				gameBoard[1][0] = index;
				break;
			case "5":
				gameBoard[1][1] = index;
				break;
			case "6":
				gameBoard[1][2] = index;
				break;
			case "7":
				gameBoard[2][0] = index;
				break;
			case "8":
				gameBoard[2][1] = index;
				break;
			case "9":
				gameBoard[2][2] = index;
				break;
			default:
				System.out.println(":(");
		}
	}

	
	/*
	 *  printing game board with empty space
	 */
	
	private static void printBoard(char[][] gameBoard) {
		System.out.println(gameBoard[0][0] + "|" +  gameBoard[0][1] + "|" +  gameBoard[0][2] );
		System.out.println("-+-+-");
		System.out.println(gameBoard[1][0] + "|" +  gameBoard[1][1] + "|" +  gameBoard[1][2] );
		System.out.println("-+-+-");
		System.out.println(gameBoard[2][0] + "|" +  gameBoard[2][1] + "|" +  gameBoard[2][2] );
	}
	
}
  