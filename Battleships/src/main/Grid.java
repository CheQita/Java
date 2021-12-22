package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel{
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
	public Grid(int _posX, int _posY, int _cellSize) {	
		posX = _posX;
		posY = _posY;
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
				if(inBounds(new Point(x, y))) {
					for(Ship s : ships) {	
						if(getSurroundingCells(s.cells).contains(cells[y][x])) {
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
	public boolean inBounds(Point pos) {
		if((0<= pos.x && pos.x < 10) && (0<= pos.y && pos.y < 10)) {
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
					if(inBounds(new Point(x, y))) {
						//cells[y][x].color = Color.ORANGE;
						if(!surroundingCells.contains(cells[y][x]))
							surroundingCells.add(cells[y][x]);
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
					c.isHit = true;
					repaint();
				}
				
			}
		}
	}
}