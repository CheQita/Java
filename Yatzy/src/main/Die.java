package main;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Die extends JButton{
	Image image;
	boolean locked = false;
	int value;
	public Die() {
		setPreferredSize(new Dimension(80, 80));
		setImage(1);
		setOpaque(false);
		
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locked = !locked;
			}
		});
		
	}
	
	public void roll() {
		value = (int) (Math.random()*6 +1);
	}
	
	public void setImage(int n) {
		try {
			String filePath = new File("").getAbsolutePath() + "/images/";		
			File file = new File(filePath + "die_" + n + ".png");
			image = ImageIO.read(file);
			setIcon(new ImageIcon(image));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void paint(Graphics g) {
		   	super.paint(g);
		   	
		    g.drawImage(image, 0 , 0 , getWidth() , getHeight() , null);
		    if(locked) {
		   		g.setColor(Color.RED);
		   		g.drawRect(0, 0,  getWidth()-1 , getHeight()-1);
		   	}
	}
	
}
