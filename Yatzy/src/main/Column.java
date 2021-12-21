package main;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Column extends JPanel{
	String name;
	int score;
	Cell[] cells;
	Die[] dice;
	CellOption[] cellOptions = new CellOption[] {
			CellOption.NAMN,
			CellOption.ETTOR,
			CellOption.TVÅOR,
			CellOption.TREOR,
			CellOption.FYROR,
			CellOption.FEMMOR,
			CellOption.SEXOR,
			CellOption.BONUS,
			CellOption.PAR,
			CellOption.TVÅ_PAR,
			CellOption.TRISS,
			CellOption.FYRTAL,
			CellOption.KÅK,
			CellOption.LITEN_STEGE,
			CellOption.STOR_STEGE,
			CellOption.CHANS,
			CellOption.YATZY,
			CellOption.SUMMA,		
	};
	
	public Column(String _name, boolean descriptionColumn) {
		name = _name;
		setLayout(new GridLayout(18, 0));
		cells = new Cell[18];
		cells[0] = new Cell(CellOption.NAMN, this);
		cells[0].setText(name);
		cells[0].setEnabled(false);
		cells[0].lock();
		
		add(cells[0]);
		
		
		
		for(int i=1; i<cells.length; i++) {
			Cell c = new Cell(cellOptions[i], this);
			add(c);
			cells[i] = c;
			if(descriptionColumn) {
				c.setText(cellOptions[i].label());
				c.setEnabled(false);
			}
		}
		
	}
	public Cell getCell(CellOption cellOption) {
		return cells[cellOption.index()];
	}
	
	public void enableCells(boolean b) {
		for(Cell c : cells) {
			if(!c.locked)
				c.setEnabled(b);
		}
	}
	public void updateDice(Die[] _dice) {
		dice = _dice;
	}
	public void diceReset() {
		for(Die d : dice) {
			d.value = 0;
		}
	}
	public void updateOptionValues(boolean reset) {
		if(reset)
			getCell(CellOption.SUMMA).setValue(CellOption.SUMMA.calculateScore(dice, this));
			getCell(CellOption.BONUS).setValue(CellOption.BONUS.calculateScore(dice, this));
		for(CellOption co : cellOptions) {
			Cell c = getCell(co);
			if(c.locked != true) {
				if(reset) {
					getCell(co).setValue(0);
				}else {
					getCell(co).setValue(co.calculateScore(dice, this));
				}
			}
		}
	}

}
