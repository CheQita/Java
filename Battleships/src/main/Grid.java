package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel{
	JButton [][] cells;
	int posX, posY;
	public Grid(int _posX, int _posY, int _cellSize) {	
		posX = _posX;
		posY = _posY;
		setLayout(new GridLayout(10, 10, -3, -3));
		setPreferredSize(new Dimension(_cellSize*10, _cellSize*10));
		setLocation(_posX+1000, _posY);
		setBackground(Color.BLACK);
		
		cells = new JButton[10][10];
		for(int y=0; y< 10; y++) {
			for(int x=0; x< 10; x++) {
				Cell cell = new Cell();
				cells[y][x] = cell;
				add(cell);
			}
		}
	}
}
