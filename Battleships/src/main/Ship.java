package main;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Ship {
	ArrayList<Cell> cells;
	boolean destroyed = false;
	int length;
	ShipType type;
	public Ship(ShipType _type, Point _startPos, Point _direction, Grid grid) {
		length = _type.length() -1;
		cells = new ArrayList<>();
		for(int y=_startPos.y; y<=_startPos.y + (length*_direction.y); y++) {
			for(int x=_startPos.x; x<=_startPos.x + (length*_direction.x); x++) {
				Cell c = grid.cells[y][x];
				c.color = Color.gray;
				c.isShip = true;
				cells.add(c);
				
			}
			
		}
		
		type = _type;
		
	}
}
