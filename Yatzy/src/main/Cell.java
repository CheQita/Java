package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main_v2.CellOption;

public class Cell extends JButton{
	int score = 0;
	int posX;
	int posY;
	int width;
	int length;
	String text;
	CellOption option;
	
	public Cell(int _posX, int _posY, int _width, int _length, CellOption _option) {
		posX = _posX;
		posY = _posY;
		width = _width -1;
		length = _length -1;
		option = _option;
		text = Integer.toString(score);
		super.setText(text);
		super.addActionListener(new ActionListener(){  
	    	  public void actionPerformed(ActionEvent e){ 
	    		System.out.println("hej");
		  		score++;
		  		text = Integer.toString(score);
		  		setText(text);
	          }
	      });   
		super.setBackground(Color.white);
		super.setBounds(posX, posY, width, length);
		Game.pane.add(this);
		Game.pane.revalidate();
		
	}
	
	public void render(Graphics2D g) {
		//g.setColor(new Color(255-score, 255-score, 255-score));
		//g.fillRect(posX, posY, width, length);
	}
}
