package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Interface extends JFrame{
	
	private static int frameWidth = 1000;
	private static int frameHeight = 800;
	
	private static Color backgroundColor = new Color(0, 100, 0);
	
	private static JFrame frame;
	static JPanel mainPanel;
	static JMenuBar menuBar;
	static JMenu options, help;
	static ScoreBoard scoreBoard;
	static DicePanel dicePanel;
	
	String[] players;
	public Interface(String[] _players) {
		players = _players;
		
		createFrame(frameWidth, frameHeight);
		createPanels();
		createMenuBar();
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	private void createFrame(int width, int height) {
		frame = new JFrame("Yatzy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		
		
	}
	private void createPanels() {
		mainPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		mainPanel.setLayout(layout);
		mainPanel.setSize(frameWidth, frameHeight);
		mainPanel.setBackground(backgroundColor);
		
		dicePanel = new DicePanel();
		mainPanel.add(dicePanel);
		scoreBoard = new ScoreBoard(players); 
		mainPanel.add(scoreBoard);
		
		

		frame.add(mainPanel);
		
	}
	private void createMenuBar() {
		menuBar = new JMenuBar();
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);
		options = new JMenu("Options");
		help = new JMenu("Help");
		
		menuBar.add(options);
		menuBar.add(help);
	
	}
	
	public void updateCurrentPlayer(Player p) {
		p.column.enableCells(true);
		dicePanel.updateCurrentPlayer(p);
	}

}
