package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import System.Casa;
import System.Goku;
import System.Mapa;
import System.Tratador;

public class Tela extends JFrame {

	public final int LARG_DEFAULT = 630;
	public final int ALT_DEFAULT = 650;
	Tratador tt = new Tratador();
	public int CORD_X=0;
	public int CORD_Y=0;
	Goku gk = null;
	private int gokuX;
	private int gokuY;
	private JPanel cp[][] = new JPanel[42][42];
	private JPanel radar[][] = new JPanel[7][7];
	Color greenColor = new Color(146,208,80);
	Color blueColor = new Color(83,141,211);
	Color brownColor = new Color(147,137,83); 
	Color redColor = new Color(192,80,77);
	Color blackColor = new Color (62, 56, 56);
	Color orangeColor = new Color (237, 176, 44);
	

	public Tela() {
		setTitle("Dragon Ball");
		setBounds(333, 10, LARG_DEFAULT, ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLayout(null);
		int i, j;
		gk = gk.getInstance();
		Casa c;
		Mapa mp = null;
		mp = mp.getInstance1();
		gokuX = gk.getAtual().getCoordX();
		gokuY = gk.getAtual().getCoordY();
		
		
		for(j=0; j<42; j++){
			
			for(i=0; i<42; i++)
			{
				c = mp.getCasas(i, j);
				cp[j][i]=new JPanel();
				
				if (c.isEsfera()){
					cp[j][i].setBackground(orangeColor);
				}
				else if ((gokuX)==i && (gokuY)==j){
					cp[j][i].setBackground(blackColor);
				}
				else if (c.isPontoChave()){
					cp[j][i].setBackground(Color.PINK);
				}
				
				else if (c.getTipo()=='A'){
					cp[j][i].setBackground(blueColor);
				}
				else if (c.getTipo()=='G'){
					cp[j][i].setBackground(greenColor);
				}
				else if (c.getTipo()=='M'){
					cp[j][i].setBackground(brownColor);
				}
				else
				{
					cp[j][i].setBackground(redColor);
				}
				
				cp[j][i].setBounds(CORD_X, CORD_Y, 15, 15);
				cp[j][i].setLayout(null);
				
				cp[j][i].setBorder(BorderFactory.createLineBorder(blackColor, 1));
				this.getContentPane().add(cp[j][i]);
				CORD_X+=15;
			}
			CORD_X=0;
			CORD_Y+=15;
		}

		RadarPainel painel = null;
		painel = painel.getInstance();
		painel.setOpaque(false);
		this.setGlassPane(painel);
		painel.setVisible(true);
	}
	
	
	public void pint()
	{
		int i, j;
		gk = gk.getInstance();
		gokuX = gk.getAtual().getCoordX();
		gokuY = gk.getAtual().getCoordY();
		Casa c;
		Mapa mp = null;
		mp = mp.getInstance1();
		
		for(j=0; j<42; j++)
		{
			
			for(i=0; i<42; i++)
			{
				c = mp.getCasas(i,j);
				
				if (c.isEsfera())
					{
						cp[j][i].setBackground(orangeColor);
					}
					else if (c.isPontoChave())
					{
						cp[j][i].setBackground(Color.PINK);
					}
					else
					{
						if (c.getTipo()=='A' && (cp[j][i].getBackground() != blueColor)){
					
							cp[j][i].setBackground(blueColor);
						}
						else if (c.getTipo()=='G' && (cp[j][i].getBackground() != greenColor)){
							cp[j][i].setBackground(greenColor);
						}
						else if (c.getTipo()=='M' && (cp[j][i].getBackground() != brownColor)){
							cp[j][i].setBackground(brownColor);
						}
						else if((gokuX != 19 || gokuY != 19) && (cp[j][i].getBackground() != redColor))
						{
							cp[19][19].setBackground(redColor);
						}
						
						cp[j][i].repaint();
					}
				if(gokuX == i && gokuY == j)
				{
					cp[j][i].setBackground(blackColor);
				}
				}
			
			
	
		}
		
		RadarPainel painel = null;
		painel = painel.getInstance();
		painel.setOpaque(false);
		this.setGlassPane(painel);
		painel.setVisible(true);
	}
}