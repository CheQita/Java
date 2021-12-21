package main;

public class Yatsy {
	
	static Interface i;
	static String[] playerNames;
	static Player[] players;
	static int currentPlayerId;
	public Yatsy(String[] _players) {
		i = new Interface(_players);
		players = Interface.scoreBoard.players;
		currentPlayerId = (int)(Math.random()*players.length);
		
		i.updateCurrentPlayer(players[currentPlayerId]);

	}
	
	
	
	public static void main(String[] args) {
		playerNames = new String[] {"Simon", "Hanna", "Matilda"};
		Yatsy game = new Yatsy(playerNames);
	}



	public static void nextPlayer() {
		currentPlayerId = (currentPlayerId +1) % players.length;
		players[currentPlayerId].nRolls = 3;
		i.updateCurrentPlayer(players[currentPlayerId]);
		i.dicePanel.diceReset();
		
	}
}
