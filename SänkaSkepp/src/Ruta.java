import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Ruta extends JButton{
	private Spelbräde spelBräde;
	private Point koordinat;
	private Color färg = Color.WHITE;
	
	public Ruta(Point _koordinat, Spelbräde _spelBräde) {
		spelBräde = _spelBräde;
		koordinat = _koordinat;
		
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				gissaRuta();
				
			}
		});
	}
	
	private void gissaRuta() {
		System.out.println(getKoordinat());
		setFärg(Color.GRAY);
	}
	
	private Point getKoordinat() {
		return koordinat;
	}
	
	private void setFärg(Color _färg){
		färg = _färg;
	}
	
	@Override
	public void paintComponent(Graphics g) {		
		g.setColor(färg);		
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
