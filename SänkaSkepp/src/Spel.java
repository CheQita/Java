import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Spel{
	//Inst�llningar
	private static final int F�NSTERBREDD = 600, F�NSTERH�JD = 1000;
	private static final int RADER = 10, KOLUMNER = 10, RUTSTORLEK = 46;
	private static final int BR�DBREDD = KOLUMNER*RUTSTORLEK, BR�DH�JD = RADER*RUTSTORLEK;
	private static final String TITEL = "S�nka skepp";
	private static final Color BAKGRUNDSF�RG = Color.PINK;
	
	//Grafiska komponenter
	private static JFrame spelf�nster;
	private static JPanel huvudPanel;
	private static Spelbr�de spelbr�de_1, spelbr�de_2;
	private static JMenuBar navigationsmeny;
	private static JMenu inst�llningar;
	private static JMenuItem omstart;
	
	//Konstruktor
	public Spel() {
		initieraGrafik();
		nyttSpel();
	}
	
	
	private void initieraGrafik() {
		skapaF�nster(F�NSTERBREDD, F�NSTERH�JD, TITEL);
		skapaMeny();
		skapaSpelbr�dor();
		
		spelf�nster.setResizable(false);
		spelf�nster.setVisible(true);
	}
	
	private void skapaF�nster(int bredd, int h�jd, String titel) {
		spelf�nster = new JFrame(titel);
		spelf�nster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spelf�nster.setSize(bredd, h�jd);
		
		huvudPanel = new JPanel();
		huvudPanel.setSize(F�NSTERBREDD, F�NSTERH�JD);
		huvudPanel.setBackground(BAKGRUNDSF�RG);
		spelf�nster.add(huvudPanel);
		
		
	}
	
	private void skapaMeny() {
		navigationsmeny = new JMenuBar();
		spelf�nster.add(navigationsmeny);
		spelf�nster.setJMenuBar(navigationsmeny);
		
		inst�llningar = new JMenu("Inst�llningar");
		navigationsmeny.add(inst�llningar);
	}
	
	private void skapaSpelbr�dor() {
		spelbr�de_1 = new Spelbr�de(KOLUMNER, RADER, RUTSTORLEK);	
		spelbr�de_2 = new Spelbr�de(KOLUMNER, RADER, RUTSTORLEK);
		spelbr�de_2.aktivaRutor(false);
		huvudPanel.add(spelbr�de_1);
		huvudPanel.add(spelbr�de_2);
	}
	
	private void nyttSpel() {
		
	}
	
	
	
	public static void main(String[] args) {
		Spel spel = new Spel();
		
		
	}
}
