import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;

public class Spelbräde extends JPanel{
	Ruta [][] rutor;					//En 2D-array för att representera spelbrädets alla rutor
	
	//Konstruktor
	public Spelbräde(int kolumner, int rader, int rutStorlek) {
		int brädBredd = kolumner*rutStorlek, brädHöjd = rader*rutStorlek;
		
		setPreferredSize(new Dimension(brädBredd, brädHöjd));
		setBackground(Color.PINK);
		GridLayout layout = new GridLayout(kolumner, rader);
		layout.setHgap(2);
		layout.setVgap(2);
		setLayout(layout);
		
		skapaRutor();
	}
	
	private void skapaRutor() {
		rutor = new Ruta[10][10];
		for(int y=0; y< 10; y++) {
			for(int x=0; x< 10; x++) {
				Ruta ruta = new Ruta(new Point(x, y), this);
				rutor[y][x] = ruta;
				
				add(ruta);
				
			}
		}
	}
	
	public void aktivaRutor(boolean aktiv) {
		for(int y=0; y< 10; y++) {
			for(int x=0; x< 10; x++) {
				
				rutor[y][x].setEnabled(aktiv);
			}
		}
	}
}