package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton{
	Color color = Color.white;
	boolean isHit = false;
	boolean isShip = false;
	Point pos;
	Grid grid;
	public Cell(Point _pos, Grid _grid) {
		pos = _pos;
		grid = _grid;
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				isHit = true;
				if(isShip) {
					grid.updateShips();
				}
				Point guess = Interface.players[1].guess();
				Interface.players[0].grid.cells[guess.y][guess.x].isHit = true;
				Interface.players[0].grid.repaint();
			}
		});
		//super.getActionListeners()[0].actionPerformed();
	}
	
	
	public Point getPos() {
		return pos;
	}
	@Override
	public void paintComponent(Graphics g) {
		if(isHit)
			color = Color.cyan;
		if(isHit && isShip) 
			color = Color.gray;
			
		g.setColor(color);		
		g.fillRect(3, 3, getWidth()- 6, getHeight() -6);
		if(isHit) {
			g.setColor(Color.red);
			if(isShip) {
				drawCross(g);
				
			}else {
				//g.fillOval(15, 15, getWidth()-30, getHeight()-30);
			}
		
		}
	}
	public void drawCross(Graphics g) {
		g.drawLine(4, 4, getWidth()-4, getHeight()-4);
		g.drawLine(4, getHeight()-4, getWidth()-4, 4);
	}
}
