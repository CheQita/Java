package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class ScoreBoard extends JPanel{
	static int cellWidth = 100, cellHeight = 40;
	static String[] names;
	static Column[] cols;
	static Player[] players;
	int nPlayers;
	public ScoreBoard(String[] _players) {
		names = _players;
		nPlayers = _players.length;
		setLayout(new GridLayout(0, nPlayers+1));
		setPreferredSize(new Dimension(cellWidth*(nPlayers+1), cellHeight*16));
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setBackground(new Color(0, 50, 0));
		
		createPlayers();
			
	}
	public void createPlayers() {
		cols = new Column[nPlayers];
		players = new Player[nPlayers];
		add(new Column("Spelare:", true));
		for(int i=0; i< nPlayers; i++) {
			Player p = new Player(names[i]);
			players[i] = p;
			add(p.column);
		}
	}
}
