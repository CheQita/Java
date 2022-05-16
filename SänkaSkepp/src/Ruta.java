import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Ruta extends JButton{
	private Spelbr�de spelBr�de;
	private Point koordinat;
	private Color f�rg = Color.WHITE;
	
	public Ruta(Point _koordinat, Spelbr�de _spelBr�de) {
		spelBr�de = _spelBr�de;
		koordinat = _koordinat;
		
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gissaRuta();
				
			}
		});
	}
	
	private void gissaRuta() {
		System.out.println(getKoordinat());
		setF�rg(Color.GRAY);
	}
	
	private Point getKoordinat() {
		return koordinat;
	}
	
	private void setF�rg(Color _f�rg){
		f�rg = _f�rg;
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		g.setColor(f�rg);		
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
