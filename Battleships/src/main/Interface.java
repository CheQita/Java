package main;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Interface extends JFrame{
	
	private static int frameWidth = 1200;
	private static int frameHeight = 800;
	
	private static JFrame frame;
	static JPanel mainPanel, gridPanel_1, gridPanel_2;
	static JMenuBar menuBar;
	static JMenu options, help;
	static JMenuItem restart;
	
	static String[] playerNames;
	static Player[] players;
	static JLabel player1Stats, player2Stats;
	
	
	static int cellSize = 50;
	static int gridSize = cellSize*10;
	
	public Interface(String[] _playerNames){
		playerNames = _playerNames;
		createFrame(frameWidth, frameHeight);
		createPanels();
		createMenuBar();
		createRandomizeButton();
		createStatisticLabels();
		
		
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	private void createFrame(int width, int height) {
		frame = new JFrame("Battleship");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		
		
	}
	private void createPanels() {
		mainPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setHgap(100);
		layout.setVgap(100);
		mainPanel.setLayout(layout);
		mainPanel.setSize(frameWidth, frameHeight);
		
		players = new Player[playerNames.length];
		Grid grid1 = new Grid(50, 100, cellSize, true);
		Grid grid2 = new Grid(550, 100, cellSize, false);
		players[0] = new HumanPlayer(grid1, grid2, playerNames[0]);
		players[1] = new ComputerPlayer(grid2, grid1, playerNames[1]);
		grid1.owner = players[0];
		grid2.owner = players[1];
		
		mainPanel.add(players[0].grid);
		mainPanel.add(players[1].grid);

		frame.add(mainPanel);
		
	}
	private void createMenuBar() {
		menuBar = new JMenuBar();
		frame.add(menuBar);
		frame.setJMenuBar(menuBar);
		options = new JMenu("Options");
		restart = new JMenuItem("Restart Game");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				players[0].grid.reset();
				players[0].grid.spawnShips();
				players[1].grid.reset();
				players[1].grid.spawnShips();
				players[1].grid.hideShips();
			}
		});
		options.add(restart);
		help = new JMenu("Help");
		
		menuBar.add(options);
		menuBar.add(help);
	
	}
	public void createRandomizeButton() {
		JButton randomize = new JButton("Randomize");
		randomize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				players[0].grid.reset();
				players[0].grid.spawnShips();
			}
		});
		mainPanel.add(randomize);
	}
	
	public void createStatisticLabels() {
		String label = "Hit Percentage : 0%";
		player2Stats = new JLabel(label);
		mainPanel.add(player2Stats);
		player1Stats = new JLabel(label);
		mainPanel.add(player1Stats);
		
	}
	public static void updateStats() {
		int percentage = (int) (players[0].getHitPercentage() * 100);
		String label = "Computer Hit Percentage : " + percentage + "%";
		player1Stats.setText(label);
		percentage = (int) (players[1].getHitPercentage() * 100);
		label = "Player Hit Percentage : " + percentage + "%";
		player2Stats.setText(label);
		
	}
}
