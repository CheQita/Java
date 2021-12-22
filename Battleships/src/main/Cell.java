package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton{
	Color color;
	boolean isHit = false;
	boolean isShip = false;
	Point pos;
	public Cell(Point _pos) {
		pos = _pos;
		color = Color.WHITE;
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				isHit = true;
			}
		});
	}
	
	
	public Point getPos() {
		return pos;
	}
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);	
		g.fillRect(3, 3, getWidth()- 6, getHeight() -6);
		if(isHit) {
			g.setColor(Color.red);
			if(isShip) {
				drawCross(g);
				
			}else {
				g.fillOval(15, 15, getWidth()-30, getHeight()-30);
			}
		
		}
	}
	public void drawCross(Graphics g) {
		g.drawLine(4, 4, getWidth()-4, getHeight()-4);
		g.drawLine(4, getHeight()-4, getWidth()-4, 4);
	}
}
