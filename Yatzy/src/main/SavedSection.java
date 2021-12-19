package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class SavedSection {
	int posX = 40 ;
	int posY = 50;
	ArrayList<Die> dice;
	
	public SavedSection() {
		dice = new ArrayList<>();
	}
	
	
	public void render(Graphics2D g) {
		//g.setColor(Color.WHITE);
		//g.fillRect(posX, posY, 100, 250);
	}
}
