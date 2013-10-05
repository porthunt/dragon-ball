package System;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JList;

public class Goku {

	private static final Goku INSTANCE = new Goku();
	private Ponto atual;
	private Ponto kame;
	private int qtdEsferas;
	private int custoCaminho;
	public Radar radar=new Radar();
	
	private Goku(){
		atual=new Ponto(19, 19);
	}
	
	public static synchronized Goku getInstance(){
		return INSTANCE;
	}

	public Ponto getAtual() {
		return atual;
	}

	public void setAtual(Ponto atual) {
		this.atual = atual;
	}

	public Ponto getKame() {
		return kame;
	}

	public void setKame(Ponto kame) {
		this.kame = kame;
	}

	public int getQtdEsferas() {
		return qtdEsferas;
	}

	public void setQtdEsferas(int qtdEsferas) {
		this.qtdEsferas = qtdEsferas;
	}

	public int getCustoCaminho() {
		return custoCaminho;
	}

	public void setCustoCaminho(int custoCaminho) {
		this.custoCaminho = custoCaminho;
	}

	public void Mover (int x, int y) {
		Ponto c = new Ponto (x,y);
		setAtual(c);
		//radar.PreencherRadar();
		
	}
	
}
