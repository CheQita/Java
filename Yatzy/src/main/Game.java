package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Game implements Runnable{
		
		final static int screenWidth = 1000;
		final static int screenHeight = 800;
		
		final int desiredFPS = 60;
		long desiredDeltaLoop = (1000*1000*1000)/desiredFPS;
		
		boolean running = true;
		
		JFrame frame;
		static JPanel pane;
		Canvas canvas;
		BufferStrategy bufferStrategy;
		
		Player[] players;
		int currentPlayer;
		String[] names = new String[]{"Simon", "Hanna", "Matilda", "Micke"};
		ScoreBoard scoreBoard;
	
		public Game(int _nPlayers) {
		
			createUI();	
	
			players = new Player[_nPlayers];
			
			for(int i=0; i<_nPlayers; i++) {
				players[i] = new Player(names[i]);
			}
			players[0].showDice(true);					//kanske dålig lösning
			scoreBoard = new ScoreBoard(names);


		}
	 	private void createUI() {
	        frame = new JFrame("Yatsy");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        initComponents(frame);

	        frame.setResizable(false);
	        frame.pack();
	        frame.setVisible(true);
	        
	        canvas.createBufferStrategy(2);
			bufferStrategy = canvas.getBufferStrategy();
			canvas.requestFocus();
	   }

	   private void initComponents(final JFrame frame) {
	    	pane = (JPanel) frame.getContentPane();
			pane.setPreferredSize(new Dimension(screenWidth, screenHeight));
			pane.setLayout(null);
	        createMenu(frame);
	        createCanvas(frame);
	        
			JButton throwDice = new JButton("Kasta");
			throwDice.setBackground(Color.white);
			throwDice.setBounds(220, 100, 100, 40);
			pane.add(throwDice);
			throwDice.addActionListener(new ActionListener(){  
		    	  public void actionPerformed(ActionEvent e){ 
	  		  		players[currentPlayer].rollDice();
	  		  		updateTurn();
	  	          }
	  	      });
			
	    }
	   
	   private void createCanvas(JFrame frame) {
			canvas = new Canvas();
			canvas.setBounds(0, 0, screenWidth, screenHeight);
			canvas.setBackground(new Color(0, 50, 0));
			canvas.setIgnoreRepaint(true);
			pane.add(canvas);
			canvas.addMouseListener(new MouseControl());
			
	   }
	   
	   private void createMenu(JFrame frame) {	
			JMenuBar menuBar = new JMenuBar();
			frame.add(menuBar);
			frame.setJMenuBar(menuBar);
			JMenu menu = new JMenu("New Game");
			menuBar.add(menu);	
	   }
	  
	   public void run(){     
	      while(running){  
	         render();
	      }
	   }
	   
	   void updateTurn() {
		   if(players[currentPlayer].nThrows == 0) {
			   System.out.println("Nu är det " + players[currentPlayer].name + "'s tur!");
			   currentPlayer = (currentPlayer+1) % players.length;
			   players[currentPlayer].showDice(true);
		   }
		   
		   
	   }


	   private void render() {
	      Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
	      g.clearRect(0, 0, screenWidth, screenHeight);
	      render(g);
	      g.dispose();
	      bufferStrategy.show();
	   }

	   private void render(Graphics2D g) {

	      players[currentPlayer].savedSection.render(g);
	      scoreBoard.render(g);
		
	   }


	   public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		//System.out.println("Hur många spelare?");
		//int nPlayers = input.nextInt();
		Game g = new Game(4);
		g.run();

	   }


}
