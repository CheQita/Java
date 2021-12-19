package main;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Player {			//Ha Column hos player ist�llet?
	String name;
	int nThrows = 3;
	
	ArrayList<Die> dice;
	SavedSection savedSection;
	
	public Player(String _name) {
		name = _name;
		dice = new ArrayList<>();
		savedSection = new SavedSection();
		for(int i=0; i<5; i++) {
			dice.add(new Die(i+1, 150 + (i* 50), 50, this));
			
		}
		showDice(false);
	}
	
	public void rollDice() {
		nThrows--;
		for(Die d : dice) {
			d.roll();
		}
	}
	
	public void showDice(boolean show) {
		for(Die d : dice) {
			d.setVisible(show);
		}
	}
	
	
}
