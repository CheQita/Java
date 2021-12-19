package main;

import java.awt.Color;
import java.awt.Graphics2D;

public class ScoreBoard {
	
	public static int colWidth = 85;
	public static int cellLength = 30;
	public static int colLength = 18*cellLength;
	Column[] cols;
	
	int posX = 550;
	int posY = 50;
	
	public ScoreBoard(String[] names) {
		cols = new Column[1+ names.length];
		Column options = new OptionsColumn("Namn: ", posX, posY);
		
		cols[0] = options;
		for(int i = 1; i < 1 + names.length; i++) {
			cols[i] = new Column(names[i-1], posX + (colWidth*i), posY);
		}
	}
	
	
	
	public void render(Graphics2D g) {
	g.setColor(Color.BLACK);
	g.fillRect(posX, posY, cols.length*colWidth, colLength);
	
	for(Column c : cols) {
		c.render(g);
	}
	}
	
}
