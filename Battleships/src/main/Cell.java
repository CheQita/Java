package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton{
	Color color;
	public Cell() {
		color = Color.WHITE;
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				color = Color.red;
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(color);
		g.fillRect(3, 3, getWidth()- 6, getHeight() -6);
		
	}
}
