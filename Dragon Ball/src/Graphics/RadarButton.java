package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import System.Tratador;

public class RadarButton extends JButton {
	public static final int TXT_X = 48;
	public static final int TXT_Y = 27;
	private BufferedImage i;
	Tratador tt = new Tratador();
	
	public RadarButton (){
		try
		{
		i=ImageIO.read(new File("radar.png"));
		}
		catch(IOException e)
		{
		System.out.println(e.getMessage());
		System.exit(1);
		}
		
		this.setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(i, 0, 0, null);
	}
}
