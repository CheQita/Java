package main_v2;

public class Yatsy {
	
	Interface i;
	static String[] playerNames;
	Player[] players;
	Player currentPlayer;
	public Yatsy(String[] _players) {
		i = new Interface(_players);
		players = Interface.scoreBoard.players;
		currentPlayer = players[(int)(Math.random()*players.length)];
		currentPlayer.column.enableCells(true);
		Interface.dicePanel.updateInfo(currentPlayer);
	}
	
	
	
	public static void main(String[] args) {
		playerNames = new String[] {"Simon", "Micke", "Hanna", "Matilda"};
		Yatsy game = new Yatsy(playerNames);
	}
}
