package main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScoreBoard {
	Player player;
	Map<String , Integer> scores;
	String[] cellNames = new String[] {
			"ETTOR",
			"TVÅOR",
			"TREOR",
			"FYROR",
			"FEMMOR",
			"SEXOR",
			"BONUS",
			"PAR",
			"TRISS",
			"TVÅ PAR",
			"FYRTAL",
			"LITEN STEGE",
			"STOR STEGE",
			"KÅK",
			"CHANS",
			"YATSY",
			"SUMMA"
			
	};
	public ScoreBoard(Player _player) {
		player = _player;
		scores = new LinkedHashMap<>();
		for(String cellName : cellNames) {
			scores.put(cellName, 0);
		}
	}
	
	public int columnWidth() {
		return "LITEN STEGE".length();
	}
	public void printHorisontalDivider() {
		System.out.print("-".repeat(columnWidth()));
		System.out.print("+");
		System.out.print("-".repeat(columnWidth()));
		System.out.println();
	}
	public void setScore(String s, int a) {
		scores.put(s, a);

	}
	public void printScoreBoard() {
		System.out.printf("%" + columnWidth() + "s", "SPELARE");
		System.out.printf("|" + player.name);
		System.out.println();
		printHorisontalDivider();
		for(String cellName : scores.keySet()) {
			System.out.printf("%" + columnWidth() + "s", cellName);
			System.out.println("|" + scores.get(cellName));
			printHorisontalDivider();
		}
		
	}
}
