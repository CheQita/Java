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
	
	static Grid grid1, grid2;
	
	
	static int cellSize = 50;
	static int gridSize = cellSize*10;
	
	public Interface(){
		
		createFrame(frameWidth, frameHeight);
		createPanels();
		createMenuBar();
		createRandomizeButton();
		
		
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
		grid1 = new Grid(50, 100, cellSize);
		grid2 = new Grid(550, 100, cellSize);
		
		mainPanel.add(grid1);
		mainPanel.add(grid2);

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
	public void createRandomizeButton() {
		JButton randomize = new JButton("Randomize");
		randomize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				grid1.reset();
				grid1.spawnShips();
			}
		});
		mainPanel.add(randomize);
	}
}
