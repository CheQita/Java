package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel{
	Player owner;
	boolean isPlayer;
	Cell [][] cells;
	ArrayList<Ship> ships;
	int posX, posY;
	int gridWidth = 10, gridHeight = 10;
	ShipType[] shipTypes = new ShipType[] {
			ShipType.CARRIER,
			ShipType.BATTLESHIP,
			ShipType.CRUISER,
			ShipType.SUBMARINE,
			ShipType.DESTROYER,
	};
	public Grid(int _posX, int _posY, int _cellSize, boolean _isPlayer) {	
		posX = _posX;
		posY = _posY;
		isPlayer = _isPlayer;
		setLayout(new GridLayout(gridWidth, gridHeight, -3, -3));
		setPreferredSize(new Dimension(_cellSize*10, _cellSize*10));
		setBackground(Color.BLACK);
		
		createCells();
		spawnShips();
	}
	public void hideShips() {
		for(Ship s : ships) {
			for(Cell c : s.cells) {
				c.color = Color.white;
			}
		}
	}
	public void createCells() {
		cells = new Cell[10][10];
		for(int y=0; y< 10; y++) {
			for(int x=0; x< 10; x++) {
				Cell cell = new Cell(new Point(x, y), this);
				cells[y][x] = cell;
				if(isPlayer) {
					cell.setEnabled(false);
				}
				add(cell);
			}
		}
	}
	
	public void reset() {
		removeAll();
		revalidate();
		repaint();
		createCells();
	}
	public Cell getCell(int x, int y) {
		return cells[y][x];
	}
	public Cell getCell(Point pos) {
		return cells[pos.y][pos.x];
	}
	
	public boolean guessCell(Point pos){
		Cell c = getCell(pos.x, pos.y);
		c.setHit();
		owner.totalShots++;
		if(c.isShip) {
			
			owner.shotsHit++;
			return true;
		}
		return false;
		
		
		
	}
	public Point getRandomPos() {
		int x = (int) (Math.random() * gridWidth);
		int y = (int) (Math.random() * gridHeight);
		return new Point(x, y);
	}
	
	public Point getRandomDir() {
		if(Math.random() > 0.5) {
			return new Point(1, 0);		
		}else {
			return new Point(0, 1);
		}
	}
	
	public void spawnShips() {
		ships = new ArrayList<>();
		Point startPos, dir;
		for(ShipType st : shipTypes) {
			while(!shipDeployable(st, startPos = getRandomPos(), dir = getRandomDir()))
				continue;															
			ships.add(new Ship(st, startPos, dir, this));
			
		}
		
	}
	
	public boolean shipDeployable(ShipType type, Point startPos, Point dir) {
		int length = type.length();
		for(int y=startPos.y; y<=startPos.y + (length*dir.y); y++) {
			for(int x=startPos.x; x<=startPos.x + (length*dir.x); x++) {
				if(inBounds(x, y)) {
					for(Ship s : ships) {	
						if(getSurroundingCells(s.cells).contains(getCell(x, y))) {
							return false;
						}
					}
						
				}else {
					return false;
				}
			
			}
		}
		return true;
		
	}
	
	public boolean inBounds(int x, int y) {
		if((0<= x && x < 10) && (0<= y && y < 10)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Cell> getSurroundingCells(ArrayList<Cell> _cells) {
		ArrayList<Cell> surroundingCells = new ArrayList<>();
		for(Cell c1 : _cells) {
			Point pos = c1.getPos();
			for(int y= pos.y-1; y<= pos.y+1; y++) {
				for(int x=pos.x-1; x<=pos.x+1; x++) {
					if(inBounds(x, y)) {
						//cells[y][x].color = Color.ORANGE;
						if(!surroundingCells.contains(getCell(x, y)))
							surroundingCells.add(getCell(x, y));
					}
				}
			}
			
		}
		for(Cell c : _cells) {
			c.color = Color.gray;
		}
		return surroundingCells;
	}
	
	public void updateShips() {
		for(Ship s : ships) {
			if(s.isDestroyed()) {
				s.destroyed = true;
				for(Cell c : getSurroundingCells(s.cells)) {
					c.isDiscovered = true;
					repaint();
				}
				
			}
		}
	}
	public Ship getShip(Cell cell) {
		for(Ship s : ships) {
			if(s.cells.contains(cell)) {
				return s;
			}
		}
		return null;
	}
}