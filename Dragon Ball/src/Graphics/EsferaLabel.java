package Graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class EsferaLabel extends JPanel {

	private BufferedImage i;
	
	public EsferaLabel(String esfera)
	{
		try
		{
		i=ImageIO.read(new File(esfera));
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
