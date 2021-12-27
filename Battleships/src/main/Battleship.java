package main;

public class Battleship {
	Interface i;
	String[] playerNames = new String[] {"Simon", "Datorn"};
	public Battleship() {

		i = new Interface(playerNames);
	}
	
	public static void main(String[] args) {
		Battleship game = new Battleship();
		
		
	}

}
