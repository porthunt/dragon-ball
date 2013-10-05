package System;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Graphics.*;

public class Mapa {
	
	private Casa casas[][] = new Casa[42][42];
	Goku goku = null;
	
	private static final Mapa INSTANCE1 = new Mapa();
	
	public static synchronized Mapa getInstance1(){
		return INSTANCE1;
	}
	
	private Mapa(){
		goku = goku.getInstance();
	}
	
	public Casa getCasas(int x, int y) {
		if(x>=0 && x<=41 && y>=0 && y<=41)
		{
			return casas[x][y];
		}
		else
		{
			return null;
		}
		
		
	}
	
	public Casa[][] getCasas() {
		return casas;
	}

	public void setCasas(Casa[][] casas) {
		this.casas = casas;
	}

	public void LerMapa() {
		
		Scanner sc;
		String str;
		int temp;
		int i, j;
		try {
			sc = new Scanner(new File("map.txt"));
			i = 0;
			j = 0;
			temp = 0;
			
			while (j!=42 ) 
			{
				str = sc.next();
				char chr;
				while(i!=42)
				{
					chr=str.charAt(i);
					if(str.charAt(i)=='A')
				{
					temp=10;
					
				}
				else
				{
					if(str.charAt(i)=='G')
					{
						temp=1;
					}
					else
					{
						if(str.charAt(i)=='M')
						{
							temp=60;
						}
						
					}
				}
				
				casas[i][j]= new Casa(i, j, temp, str.charAt(i));
				i++;
				}
				i=0;
				j++;
								
			}
			
			sc.close();
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}

		
	}
	
	public void SetarEsferas() {
		int i = 7;
		IntRandom rdm = new IntRandom();
		int coluna, linha;
		
		while (i>0) 
		{
			coluna = rdm.NumRandom();
			linha  = rdm.NumRandom();
			
			if (!(casas[coluna][linha].isEsfera()))
			{
				casas[coluna][linha].setEsfera(true);
				i--;
			}
		}
	}
	
	public void SetarEsferasManual() {
		
		Scanner sc;
		try {
			sc = new Scanner(new File("Esferas.txt"));
		
		int i = 7;
		int coluna, linha;
		while(sc.hasNext())
		{
			coluna = sc.nextInt();
			linha  = sc.nextInt();
		
			if (!(casas[coluna][linha].isEsfera()))
			{
				casas[coluna][linha].setEsfera(true);
			}
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
