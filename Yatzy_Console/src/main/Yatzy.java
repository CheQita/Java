package main;

import java.util.Scanner;

public class Yatzy {
	
	public static Player[] players;
	public static Player currentPlayer;
	public int playerTurn;
	
	public static Die[] dice = new Die[5];
	
	
	static Scanner input = new Scanner(System.in);
	
	public Yatzy(String[] names) {
		createPlayers(names);
		createDice();
	}

	public void createPlayers(String[] names) {
		players = new Player[names.length];
		for(int i=0; i<players.length; i++) {
			players[i] = new Player(names[i]);
		}
		
		playerTurn = (int) (Math.random() * players.length);
		
	}
	
	public void createDice() {
		for(int i=0; i<dice.length; i++) {
			dice[i] = new Die();
		}
	}
	
	public void clearConsole() {
		
	}
	
	public void rollDice() {
		for(Die d : dice) {
			d.roll();
		}
	}
	
	
	public void printMenu(){
		int choice;
		System.out.println("1. Rulla tärningarna");
		System.out.println("2. Visa poängen");
		while(true) {
			choice = input.nextInt();
			switch(choice) {
				case 1:
					rollDice();
				case 2:
					currentPlayer.showScoreBoard();
				
			}
		}
		
	}
	
	public void nextPlayer() {
		playerTurn = (playerTurn + 1) % players.length;
	}
	
	public void start() {
		currentPlayer = players[playerTurn];
		System.out.println("Nu är det " + currentPlayer.name + "'s tur!");
		currentPlayer.scoreBoard.printScoreBoard();
		printMenu();
		
	}
	public static void main(String[] args) {
		String[] names = new String[] {"Hanna", "Matilda"};
		Yatzy game = new Yatzy(names);
		game.start();
		
	}
}
