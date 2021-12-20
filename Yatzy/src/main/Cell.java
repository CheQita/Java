package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton{
	boolean locked = false;
	int value = 0;
	public Cell() {
		setValue(value);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!locked) {
					setValue(100);
					//skicka meddelande till Yatsy att det är nästa spelares tur
				}
			}
		});
	}
	
	public void setValue(int v) {
		value = v;
		setText(Integer.toString(value));
	}
	
	public void lock() {
		locked = true;
	}
	
}
