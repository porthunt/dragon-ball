package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import System.Casa;
import System.Goku;
import System.Mapa;
import System.Ponto;
import System.Tratador;

public class RadarPainel extends JPanel {
	public static final int TXT_X = 700;
	public static final int TXT_Y = 525;
	Goku goku = null;
	private boolean ativado=true;
	Tratador tt = new Tratador();
	Color blackColor = new Color (62, 56, 56);
	
	private static final RadarPainel INSTANCE2 = new RadarPainel();
	
	private RadarPainel(){
		
	}
	
	public boolean isAtivado() {
		return ativado;
	}



	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public static synchronized RadarPainel getInstance(){
		return INSTANCE2;
	}
	
	public void paintComponent(Graphics g)  
	   {
		 goku = goku.getInstance();
		 int CORD_X = 3;
		 int CORD_Y = 3;
		 Ponto p = goku.getAtual();
		 g.setColor(new Color(1, 1, 1, 0.5f));
	     g.fillRect((p.getCoordX()-CORD_X)*15, (p.getCoordY()-CORD_Y)*15, 105, 105);
	     g.setColor(Color.RED);
	     g.drawRect((p.getCoordX()-CORD_X)*15, (p.getCoordY()-CORD_Y)*15, 105, 105);
	     }  
}
