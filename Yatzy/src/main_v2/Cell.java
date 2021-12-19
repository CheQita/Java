package main_v2;

import javax.swing.JButton;

public class Cell extends JButton{
	boolean locked = false;
	int value = 0;
	public Cell() {
		setValue(value);
	}
	
	public void setValue(int v) {
		value = v;
		setText(Integer.toString(value));
	}
	
	public void lock() {
		locked = true;
	}
	
}
