package main;

public class ScoreBoard {
	Player player;
	
	public ScoreBoard(Player _player) {
		player = _player;
		
	}
	
	public void printScoreBoard() {
		System.out.print("Spelare:|");
		System.out.printf(player.name);
		System.out.println();
		System.out.println("-".repeat(15));
	}
}
