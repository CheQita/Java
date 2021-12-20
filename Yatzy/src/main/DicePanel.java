package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DicePanel extends JPanel{
	Die[] dice;
	static JButton rollButton;
	static JLabel info;
	Player currentPlayer;
	public DicePanel() {
		
		setPreferredSize(new Dimension(450, 250));
		setBorder(BorderFactory.createLineBorder(Color.black, 3));
		setBackground(new Color(0, 50, 0));
		
		createDice();
		addRollButton();
		addInfoLabel();
	}
	
	public void createDice() {
		dice = new Die[5];
		for(int i=0; i<dice.length; i++) {
			dice[i] = new Die();
			add(dice[i]);
		}
	}
	public void rollDice() {
		for(Die d : dice) {
			if(!d.locked) {
			d.roll();
			d.setImage(d.value);
			}
		}
	}
	public void addRollButton() {
		rollButton = new JButton("Rulla tärningar");
		rollButton.setPreferredSize(new Dimension(150, 40));
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer.nRolls > 0) {
				currentPlayer.nRolls--;	
				updateInfo();
				rollDice();
				currentPlayer.column.updateOptionValues(dice);
				
				}else {
					//visa meddelande
					System.out.println("Det kan du icke göra");
				}
			}
		});
		add(rollButton);
	}
	public void addInfoLabel() {
		info = new JLabel("HEJEHEHEJ");
		//info.setPreferredSize(new Dimension(150, 40));
		info.setFont(new Font("Serif", Font.PLAIN, 40));
		info.setForeground(Color.WHITE);
		add(info);
	}
	
	public void updateCurrentPlayer(Player player) {
		currentPlayer = player;
		updateInfo();
	}
	public void updateInfo() {
		String text = currentPlayer.name + " har " + currentPlayer.nRolls + " kast kvar!";
		info.setText(text);
		
	}
}
