package main;

public class Player{
	Column column;
	String name;
	int score = 0;
	int nRolls = 3;
	public Player(String _name) {
		name = _name;
		column = new Column( name, false);
		column.getCell(CellOption.SUMMA).setValue(score);
		column.enableCells(false);
		column.getCell(CellOption.SUMMA).lock();
		column.getCell(CellOption.BONUS).lock();
		
	}

}
