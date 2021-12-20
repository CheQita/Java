package main;

public class Player{
	Column column;
	String name;
	int score = 100;
	int nRolls = 3;
	public Player(String _name) {
		name = _name;
		column = new Column( name, false);
		column.getCell(CellOption.SUMMA).setValue(score);
		column.enableCells(false);
		
	}

}
