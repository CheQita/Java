import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;

public class Spelbr�de extends JPanel{
	Ruta [][] rutor;					//En 2D-array f�r att representera spelbr�dets alla rutor
	
	//Konstruktor
	public Spelbr�de(int kolumner, int rader, int rutStorlek) {
		int br�dBredd = kolumner*rutStorlek, br�dH�jd = rader*rutStorlek;
		
		setPreferredSize(new Dimension(br�dBredd, br�dH�jd));
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