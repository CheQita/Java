package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Cell extends JButton{
	boolean locked = false;
	int value = 0;
	CellOption cellOption;
	Column col;
	public Cell(CellOption _cellOption, Column _col) {
		col = _col;
		cellOption = _cellOption;
		setValue(value);
		setBackground(new Color(0, 100, 0));
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!locked) {
					setValue(cellOption.calculateScore(col.dice, col));	
					lock();
					setEnabled(false);
					col.diceReset();
					col.updateOptionValues(true);
					col.enableCells(false);
					Yatsy.nextPlayer();
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
