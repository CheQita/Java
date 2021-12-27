package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ComputerPlayer extends Player{
	ArrayList<Cell> currentShip = new ArrayList<>();
	Point shipDir = null;
	public ComputerPlayer(Grid _playerGrid, Grid _opponentGrid, String _name) {
		super(_playerGrid, _opponentGrid, _name);
		grid.hideShips();
	}
	public Point getRandomDir() {
		int r = (int) (Math.random()*4);
		switch(r) {
		case 0:
			return new Point(0, 1);
		case 1:
			return new Point(1, 0);
		case 2:
			return new Point(0, -1);
		case 3:
			return new Point(-1, 0);
		default:
			return new Point(0, 0);
		}
	}
	public void guess() {
		Point guess;
	
		
		
		if(currentShip.size() == 0) {								//Om den inte har någon pågående båt att sänka
			while(true){
				guess = opponentGrid.getRandomPos();
				if(opponentGrid.getCell(guess).isDiscovered != true) {
					
					if(opponentGrid.guessCell(guess) == true) {			//Om den träffade en båt
						currentShip.add(opponentGrid.getCell(guess));
						guess();										//får en till gissning
					}
					opponentGrid.repaint();
					break;
				}
			}
		}
		else {
			Point dir;
			while(true) {
				
				dir = getRandomDir();
				if(shipDir != null) {
					 dir = shipDir;
				}
				Point pos = currentShip.get(currentShip.size()-1).pos;
				guess = new Point(pos.x + dir.x, pos.y + dir.y);
				if(opponentGrid.inBounds(guess.x, guess.y) && opponentGrid.getCell(guess).isDiscovered != true) {			//här måste jag reverse direction om den är out of bounds	
					if(opponentGrid.guessCell(guess)== true) {
						currentShip.add(opponentGrid.getCell(guess));
						opponentGrid.updateShips();
						
						if(opponentGrid.getShip(currentShip.get(0)).isDestroyed()) {
							currentShip.removeAll(currentShip);
							shipDir = null;
							break;
						}
						shipDir = dir;
						guess();						//Får en till gissning
					}else {
						if(shipDir != null) {			//reverse direction, reverse arraylist;
							dir.x = shipDir.x * -1;
							dir.y = shipDir.y * -1;
							Collections.reverse(currentShip);

						}
					}
					opponentGrid.repaint();
					break;
				}else {
					if(shipDir != null) {			//reverse direction, reverse arraylist;
						dir.x = shipDir.x * -1;
						dir.y = shipDir.y * -1;
						Collections.reverse(currentShip);
					}
				}
			}
		}
	}
}
