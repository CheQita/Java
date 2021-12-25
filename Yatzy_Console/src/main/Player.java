package main;

public class Player {
	String name;
	ScoreBoard scoreBoard;
	public Player(String _name) {
		name = _name;
		createScoreBoard();
	}
	public void createScoreBoard() {
		scoreBoard = new ScoreBoard(this);
		scoreBoard.setScore("SUMMA", 100);
	}
	
	public void showScoreBoard() {
		scoreBoard.printScoreBoard();
	}
}