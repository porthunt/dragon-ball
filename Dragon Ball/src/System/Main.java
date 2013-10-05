package System;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.swing.*;

import Graphics.InfoFrame;
import Graphics.Tela;

public class Main {

	public static void main(String[] args) 
	{
		int i=0, j=0;
		Mapa mp = null;
		Ponto cam;
		Goku gk = null;
		gk = gk.getInstance();
		mp = mp.getInstance1();
		mp.LerMapa();
		mp.SetarEsferasManual();
		mp.SetarEsferas();
		int Custo_Caminho=0;
		Tela f = new Tela();
		f.setVisible(true);
		InfoFrame iframe = new InfoFrame();
		List<Ponto>Caminho;
		FileWriter writer;
		JLabel jl;
		
		gk.radar.PreencherRadar();
		gk.radar.ReconhecerCenario();
		
		while(gk.getQtdEsferas()<7)
		{
			gk.radar.MenorCaminho();
			Caminho = gk.radar.GetCaminho();
			
			for (j=Caminho.size()-1; j>=0; j--){
				cam = Caminho.get(j);
				gk.Mover(cam.getCoordX(), cam.getCoordY());
				Custo_Caminho=mp.getCasas(gk.getAtual().getCoordX(),gk.getAtual().getCoordY()).getCusto();
				iframe.setCusto(Custo_Caminho);
				f.pint();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
				if(mp.getCasas(Caminho.get(0).getCoordX(),Caminho.get(0).getCoordY()).isEsfera())
				{
					mp.getCasas(Caminho.get(0).getCoordX(),Caminho.get(0).getCoordY()).setEsfera(false);
					mp.goku.radar.GetEsferas().remove(Caminho.get(0));
					mp.goku.setQtdEsferas(mp.goku.getQtdEsferas()+1);
					iframe.setaEsfera(mp.goku.getQtdEsferas());
					
					
				}
				gk.radar.PreencherRadar();
				gk.radar.ReconhecerCenario();
				
			
		}
		while(gk.getAtual().getCoordX()!=19 && gk.getAtual().getCoordY()!=19 )
		{
			gk.radar.retorno=true;
			gk.radar.MenorCaminho();
			Caminho = gk.radar.GetCaminho();
			
			for (j=Caminho.size()-1; j>=0; j--){
				cam = Caminho.get(j);
				gk.Mover(cam.getCoordX(), cam.getCoordY());
				Custo_Caminho=mp.getCasas(gk.getAtual().getCoordX(),gk.getAtual().getCoordY()).getCusto();
				iframe.setCusto(Custo_Caminho);
				f.pint();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
			
		}
		
		String nativeLF = UIManager.getSystemLookAndFeelClassName();
		try {
			UIManager.setLookAndFeel(nativeLF);
		} catch (InstantiationException e) {
		} catch (ClassNotFoundException e) {
		} catch (UnsupportedLookAndFeelException e) {
		} catch (IllegalAccessException e) {
		}
	}
}