import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Spel{
	//Inställningar
	private static final int FÖNSTERBREDD = 600, FÖNSTERHÖJD = 1000;
	private static final int RADER = 10, KOLUMNER = 10, RUTSTORLEK = 46;
	private static final int BRÄDBREDD = KOLUMNER*RUTSTORLEK, BRÄDHÖJD = RADER*RUTSTORLEK;
	private static final String TITEL = "Sänka skepp";
	private static final Color BAKGRUNDSFÄRG = Color.PINK;
	
	//Grafiska komponenter
	private static JFrame spelfönster;
	private static JPanel huvudPanel;
	private static Spelbräde spelbräde_1, spelbräde_2;
	private static JMenuBar navigationsmeny;
	private static JMenu inställningar;
	private static JMenuItem omstart;
	
	//Konstruktor
	public Spel() {
		initieraGrafik();
		nyttSpel();
	}
	
	
	private void initieraGrafik() {
		skapaFönster(FÖNSTERBREDD, FÖNSTERHÖJD, TITEL);
		skapaMeny();
		skapaSpelbrädor();
		
		spelfönster.setResizable(false);
		spelfönster.setVisible(true);
	}
	
	private void skapaFönster(int bredd, int höjd, String titel) {
		spelfönster = new JFrame(titel);
		spelfönster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		spelfönster.setSize(bredd, höjd);
		
		huvudPanel = new JPanel();
		huvudPanel.setSize(FÖNSTERBREDD, FÖNSTERHÖJD);
		huvudPanel.setBackground(BAKGRUNDSFÄRG);
		spelfönster.add(huvudPanel);
		
		
	}
	
	private void skapaMeny() {
		navigationsmeny = new JMenuBar();
		spelfönster.add(navigationsmeny);
		spelfönster.setJMenuBar(navigationsmeny);
		
		inställningar = new JMenu("Inställningar");
		navigationsmeny.add(inställningar);
	}
	
	private void skapaSpelbrädor() {
		spelbräde_1 = new Spelbräde(KOLUMNER, RADER, RUTSTORLEK);	
		spelbräde_2 = new Spelbräde(KOLUMNER, RADER, RUTSTORLEK);
		spelbräde_2.aktivaRutor(false);
		huvudPanel.add(spelbräde_1);
		huvudPanel.add(spelbräde_2);
	}
	
	private void nyttSpel() {
		
	}
	
	
	
	public static void main(String[] args) {
		Spel spel = new Spel();
		
		
	}
}
