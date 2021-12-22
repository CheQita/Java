package main;

import java.awt.Point;

public class ComputerPlayer extends Player{
	
	public ComputerPlayer(Grid _grid, String _name) {
		super(_grid, _name);
		grid.hideShips();
	}
	
	public Point guess() {
		return grid.getRandomPos();
	}
}
