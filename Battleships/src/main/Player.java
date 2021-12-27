package main;

public abstract class Player {

	Grid grid;
	Grid opponentGrid;
	String name;
	int totalShots, shotsHit;
	public Player(Grid _playerGrid, Grid _opponentGrid, String _name) {
		grid = _playerGrid;
		opponentGrid = _opponentGrid;
	}
	public double getHitPercentage() {
		return (double)shotsHit/(double)totalShots;
	}
	
	protected abstract void guess();
	
	
	//initGrid method?
}
