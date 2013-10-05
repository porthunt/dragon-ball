package System;

import java.awt.Color;

public class Casa {
	private Ponto p;
	private boolean esfera;
	private boolean visitado;
	private int custo;
	private char tipo;
	private boolean ponto_chave_visitado;
	
	public Casa(int x, int y, int custo, char tipo) {
		this.p = new Ponto(x, y);
		this.custo = custo;
		this.tipo = tipo;
		this.visitado=false;
	}
	
	public Ponto getP() {
		return p;
	}
	
	public boolean isEsfera() {
		return esfera;
	}
	public boolean isVisitado()
	{
		return visitado;
	}
	public boolean isPontoChaveVisitado()
	{
		return ponto_chave_visitado;
		
	}
	
	public void VisitaPontoChave()
	{
		ponto_chave_visitado=true;
	}
	
	public void Visita()
	{
		this.visitado=true;
	}
	public void Reseta()
	{
		this.visitado=false;
	}
	
	public boolean isPontoChave()
	{
		if (p.getCoordY()==3 && p.getCoordX()==3){
			return true;
		}
		
		else if (p.getCoordY()==38 && p.getCoordX()==3){
			return true;
		}
		
		else if (p.getCoordY()==3 && p.getCoordX()==38){
			return true;
		}
		
		else if (p.getCoordY()==38 && p.getCoordX()==38){
			return true;
		}
		
		else if ((((p.getCoordY()-3)%7)==0) && (((p.getCoordX()-3)%7)==0)){
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	
	public void setEsfera(boolean esfera) {
		this.esfera = esfera;
	}
	
	public int getCusto() {
		return custo;
	}
	
	public char getTipo() {
		return tipo;
	}	
	
}
