package System;

public class Estrutura {

	public Ponto pt;
	public int custo;
	public Estrutura Anterior;
	
	public Estrutura(int x, int y, int custo){
		pt = new Ponto(x, y);
		this.custo = custo;
	}
	
}
